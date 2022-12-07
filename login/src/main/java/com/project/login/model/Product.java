package com.project.login.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author RizaAdrian
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Product {

	@SequenceGenerator(
			name = "product_sequence",
			sequenceName = "product_sequence",
			allocationSize = 1
	)
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "product_sequence"
	)
	private Long id;
	private Long productId;
	private String productName;
	private double price;
	@Enumerated(EnumType.STRING)
	private ProductType productType;
	private boolean isAvailable;

	public Product(Long productId, String productName,
			double price, ProductType productType, boolean isAvailable) {

		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productType = productType;
		this.isAvailable = isAvailable;
	}
}
