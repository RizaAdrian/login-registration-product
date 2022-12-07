package com.project.login.dto;

import com.project.login.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author RizaAdrian
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class ProductDTO {

	@NotEmpty
	private Long productId;
	@NotEmpty
	private String productName;
	@NotEmpty
	private double price;
	@NotEmpty
	private ProductType productType;
	@NotEmpty
	private boolean isAvailable;
}
