package com.snva.service;

import java.util.List;
import java.util.Map;

import com.snva.entity.Product;

public interface ProductService {
	
	Product createProduct(Product product);

	Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Product product);

    void deleteProduct(Long id);
    
    Product partialFieldUpdate(long id, Map<String, Object> fields);

}
