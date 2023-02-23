package com.product.services;

import java.util.List;

import javax.validation.Valid;

import com.product.entity.Product;

public interface ProductService {

	public Product addProduct(@Valid Product product) throws Exception;

	public List<Product> getProducts();

	public Product getProduct(long parseLong) throws Exception;

	public String deleteProduct(long parseLong) throws Exception;

	public Product updateProduct(long parseLong, @Valid Product product)throws Exception;

	public List<Product> searchProduct(String name) throws Exception;

}
