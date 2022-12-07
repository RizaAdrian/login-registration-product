package com.project.login.service;

import com.project.login.dto.ProductDTO;

import java.util.List;

/**
 * @author RizaAdrian
 */
public interface ProductService {

	List<ProductDTO> createProducts(List<ProductDTO> productDTOList);
	ProductDTO getProductByProductId(Long productId);
	List<ProductDTO> getAllProducts();
	void deleteProduct(Long productId);

	ProductDTO updateProduct(ProductDTO productDTO);
}
