package com.ecommerce.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.microservice.entity.Product;
import com.ecommerce.microservice.repository.ProductRepository;



@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	//@Scheduled(fixedRate = 60000)
	public List<Product> retrieveAllProduit() {
		List<Product> produits=(List<Product>) productRepository.findAll();
		return produits;
	}
	public Product addProduct(Product product){
		return productRepository.save(product);
	}
	
	public Product getProductByid (int id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : null;
		return product;
	}
	
	public Product updateProduct(int id, Product newProduct){
		if(productRepository.findById(id).isPresent()){
			Product existingProductt =productRepository.findById(id).get();
			existingProductt.setProductName(newProduct.getProductName());
			existingProductt.setPrice(newProduct.getPrice());
			existingProductt.setDescription(newProduct.getDescription());
			existingProductt.setCategory(newProduct.getCategory());
			existingProductt.setAvailability(newProduct.getAvailability());
			existingProductt.setImageUrl(newProduct.getImageUrl());
			return productRepository.save(existingProductt);
			
		}else{
			return null;
		}

	}
	public String deleteProduct(int id){
		if(productRepository.findById(id).isPresent()){
			productRepository.deleteById(id);
			return  "product  supprimé";
		}else
			return "product non supprimé";
	}
	

}
