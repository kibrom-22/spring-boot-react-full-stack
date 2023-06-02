package com.snva.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snva.entity.Product;
import com.snva.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService pService;
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
	Product newProduct =	pService.createProduct(product);
	 return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> products =	pService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id, @RequestBody Product product){
	Product existingProduct =	pService.getProductById(id);
	return new ResponseEntity<Product>(existingProduct, HttpStatus.FOUND);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Long id){
		pService.deleteProduct(id);
	return new ResponseEntity<String>("Succsusfully Deleted Item!!", HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable Long id, @RequestBody Product product){
	    product.setId(id);
		Product updatedProduct =	pService.updateProduct(product);
	return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<Product> partialFieldUpdate(@PathVariable long id,@RequestBody Map<String, Object> fields){
		return new ResponseEntity<Product>(pService.partialFieldUpdate(id, fields), HttpStatus.OK);
	}
	
	

}
