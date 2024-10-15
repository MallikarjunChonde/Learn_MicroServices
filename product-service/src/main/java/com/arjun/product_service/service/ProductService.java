package com.arjun.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arjun.product_service.dto.ProductRequest;
import com.arjun.product_service.dto.ProductResponse;
import com.arjun.product_service.model.Product;
import com.arjun.product_service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {
		Product product= Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();

		productRepository.insert(product);
		log.info("product {} is saved", product.getId());
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return 	products.stream().map(product -> mapToProductResponse(product)).toList();

	}

	public ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}

	public Product getProductById(String id) {
		return 	productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("Prouct not found with this id %s", id)));
	}
	

	public Product updateProduct(Product product) {

		Product savedProduct = productRepository.findById(product.getId())
				.orElseThrow(() -> new RuntimeException(String.format("User with this id not found", product.getId())));

		savedProduct.setName(product.getName());
		savedProduct.setDescription(product.getDescription());
		savedProduct.setPrice(product.getPrice());

		return productRepository.save(product);
	}
	
	public void deleteProductById(String id) {
		productRepository.findById(id);
	}
}








