package com.terra.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {
	
	@Autowired
	ProductMongoRepository repository;

	@Autowired
	RestTemplate restTemplate;

	public String saveProduct(Product product) {
		Product created=repository.save(product);
		sendProductDetails(created);
		if(created != null) {
			return "Product created Successfully";
		}else {
			return "Product not created Successfully";
		}
	}

	public Product getById(String id) {
		Optional<Product> product= repository.findById(id);
		if(product.isPresent()){
			return product.get();
		}else {
			Product p=new Product();
			p.setRemarks("Product not found");
			return p;
		}		
	}

	public List<Product> getByProductName(String productName) {
		return repository.findProductByProductName(productName);
	}

	private ResponseEntity<String> invokeEmailService(@RequestBody mailDetails emailDeatails) {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		ResponseEntity<String> sys = restTemplate.postForEntity("http://PRODUCT-SERVICE:8989/api/sendMail",
				emailDeatails, String.class);
		return sys;
	}
	

	private void sendProductDetails(Product product) {
		try {
			mailDetails emailDetails = new mailDetails();
			ObjectMapper mapper = new ObjectMapper();		
			emailDetails.setMsgBody(mapper.writeValueAsString(product));		
			emailDetails.setRecipient("sudhanreddy07@gmail.com.com");
			emailDetails.setSubject("Email Details");
			ResponseEntity<String> response = invokeEmailService(emailDetails);
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}
	}

	private void createAndSendListOfProductDetails(List<Product> listOfProduct)  {
		try {
		mailDetails emailDetails = new mailDetails();
		ObjectMapper mapper = new ObjectMapper();
		
			emailDetails.setMsgBody(mapper.writeValueAsString(listOfProduct));		
		emailDetails.setRecipient("sudhanreddy07@gmail.com.com");
		emailDetails.setSubject("Email Details");
		ResponseEntity<String> response = invokeEmailService(emailDetails);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
