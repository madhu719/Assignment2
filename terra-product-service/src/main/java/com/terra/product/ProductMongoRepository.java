package com.terra.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMongoRepository extends JpaRepository<Product, String> {

	List<Product> findProductByProductName(String productName);

}
