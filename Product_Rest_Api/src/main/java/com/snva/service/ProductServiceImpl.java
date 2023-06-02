package com.snva.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.snva.entity.Product;

import com.snva.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
	private ProductRepository pRepository;
	@Override
	public Product createProduct(Product product) {
		Product newProduct = pRepository.save(product);
		return newProduct;
	}

	@Override
	public Product getProductById(Long id) {
	Optional<Product> product =	pRepository.findById(id);
		return product.get();
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = pRepository.findAll();
		return products;
	}

	@Override
	public Product updateProduct(Product product) {
	Product exisProduct =	pRepository.findById(product.getId()).get();
		exisProduct.setName(product.getName());
		exisProduct.setPrice(product.getPrice());
		exisProduct.setQuantity(product.getQuantity());
	Product updateProduct =	pRepository.save(exisProduct);
	return updateProduct;
	}

	@Override
	public void deleteProduct(Long id) {
		pRepository.deleteById(id);
		
	}
	
	 
	
	@Override
	public Product partialFieldUpdate(long id, Map<String, Object> fields) {
		Optional<Product> existingProduct =	pRepository.findById(id);
		if(existingProduct.isPresent()) {
			fields.forEach((key, value)->{
		Field field = ReflectionUtils.findRequiredField(Product.class, key);
		//ReflectionUtils - Creates an instance of the class with the given fully qualified name 
		ReflectionUtils.setField(field, existingProduct.get(), value);
				
			});
			return pRepository.save(existingProduct.get());
		}
		return null;
	}

}
