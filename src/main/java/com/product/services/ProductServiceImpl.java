package com.product.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(@Valid Product product) throws Exception {
		// TODO Auto-generated method stub
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(long parseLong) throws Exception {
		// TODO Auto-generated method stub
		Product check =productRepository.findById(parseLong).get();
		if(check==null) {
			throw new Exception("Product not found");
		}
		else {
			return check;
		}
		
	}

	@Override
	public String deleteProduct(long parseLong) throws Exception {
		Product check =productRepository.findById(parseLong).get();
		if(check==null) {
			throw new Exception("Product not found");
		}
		else {
			productRepository.deleteById(parseLong);
			return "Product deleted Succesfully";
		}
	}

	@Override
	public Product updateProduct(long parseLong, @Valid Product product) throws Exception {
		Product check =productRepository.findById(parseLong).get();
		if(check==null) {
			throw new Exception("Product not found");
		}
		else {
			check.setCategory(product.getCategory());
			check.setDetails(product.getDetails());
			check.setImage(product.getImage());
			check.setName(product.getName());
			check.setPrice(product.getPrice());
			check.setStock(product.getStock());
			return productRepository.save(check);

		}
	
	}

	@Override
	public List<Product> searchProduct(String name) throws Exception {
		// TODO Auto-generated method stub
		 return productRepository.findByNameContainingIgnoreCase(name);
		
	}
}
