package com.project.login.controller;

import com.project.login.dto.ProductDTO;
import com.project.login.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.project.login.model.UserRole.USER;

/**
 * @author RizaAdrian
 */
@RestController
@RequestMapping(path = "api/product")
@AllArgsConstructor
public class ProductController {

	private ProductService productService;

	@PostMapping
	public List<ProductDTO> createProducts(@RequestBody List<ProductDTO> productDTOList) {

		return productService.createProducts(productDTOList);
	}

	@GetMapping("/{id}")
	public ProductDTO getByProductId(@PathVariable Long id) {

		return productService.getProductByProductId(id);
	}

	@GetMapping("/all")
	public List<ProductDTO> getAllProducts(){
		return productService.getAllProducts();
	}

	@DeleteMapping("/{id}")
	public void deleteByProductId(@PathVariable Long id) {

		productService.deleteProduct(id);
	}

	@PutMapping("/{id}")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){

		return productService.updateProduct(productDTO);
	}
}
