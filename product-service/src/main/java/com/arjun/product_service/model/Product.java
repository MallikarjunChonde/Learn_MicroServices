package com.arjun.product_service.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Entity(name = "productInfo")
@Document("product")
public class Product {

//	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
}
