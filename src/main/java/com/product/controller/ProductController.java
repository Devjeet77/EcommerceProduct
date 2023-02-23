package com.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.services.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody @Valid Product product) throws Exception {
		return productService.addProduct(product);
	}
	
	@GetMapping("/product/all")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/product/id/{id}")
	public Product getProduct(@PathVariable String id) throws Exception {
		return productService.getProduct(Long.parseLong(id));
	}
	
	@PostMapping("/product/search")
	public List<Product> searchProduct(@RequestBody String name) throws Exception{
		return productService.searchProduct(name);
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable String id) throws Exception{
		return productService.deleteProduct(Long.parseLong(id));
	}
	
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable String id, @RequestBody @Valid Product product) throws Exception{
		return productService.updateProduct(Long.parseLong(id),product);
	}

}
