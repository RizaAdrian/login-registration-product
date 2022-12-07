package com.project.login.service;

import com.project.login.dto.ProductDTO;
import com.project.login.mapper.ProductMapper;
import com.project.login.model.Product;
import com.project.login.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author RizaAdrian
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	@Override
	public List<ProductDTO> createProducts(List<ProductDTO> productDTOList) {

		List<Product> productList = productMapper.sourceToDestination(productDTOList);

		List<Product> products = productList.stream().map(productRepository::save).toList();

		return productMapper.destinationToSource(products);
	}

	@Override
	public ProductDTO getProductByProductId(Long productId) {
		Optional<Product> productOpt = productRepository.findByProductId(productId);
		if(productOpt.isEmpty()){
			throw new IllegalStateException("Product does not exists!");
		}

		return productMapper.destinationToSource(productOpt.get());
	}

	@Override
	public List<ProductDTO> getAllProducts() {

		List<Product> allProducts = productRepository.findAll();
		return productMapper.destinationToSource(allProducts);
	}
	@Override
	public void deleteProduct(Long productId) {

		Optional<Product> productOpt = productRepository.findByProductId(productId);
		if(productOpt.isEmpty()){
			throw new IllegalStateException("Product does not exists!");
		}
		productRepository.delete(productOpt.get());
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {

		Optional<Product> productOpt = productRepository.findByProductId(productDTO.getProductId());
		if(productOpt.isEmpty()){
			throw new IllegalStateException("Product does not exists");
		}

		return productMapper.destinationToSource(productRepository.save(productOpt.get()));
	}
}
