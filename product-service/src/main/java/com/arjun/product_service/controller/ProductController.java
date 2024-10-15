package com.arjun.product_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.arjun.product_service.dto.ProductRequest;
import com.arjun.product_service.dto.ProductResponse;
import com.arjun.product_service.model.Product;
import com.arjun.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping
	public ResponseEntity createProduct(@RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<List<ProductResponse>> getAllProduct(){	
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id){
		return ResponseEntity.ok(productService.getProductById(id));
	}

	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		return ResponseEntity.ok(productService.updateProduct(product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable String id) {
		productService.deleteProductById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
	}

}