package com.terra.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public String createProduct(@RequestBody Product product) throws Exception {
		String message=productService.saveProduct(product);
		return message;
	}

	
	@GetMapping("/name/{productName}")
	public List<Product> getByProductName(@PathVariable String productName) throws Exception {
		List<Product> listOfProduct = productService.getByProductName(productName);
		return listOfProduct;
	}


	@GetMapping("/{id}")
	private Product getUser(@PathVariable String id) throws Exception {
		Product product = productService.getById(id);		
		return product;
	}

}
