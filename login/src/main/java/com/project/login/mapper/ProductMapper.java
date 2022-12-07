package com.project.login.mapper;

import com.project.login.dto.ProductDTO;
import com.project.login.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author RizaAdrian
 */
@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	Product sourceToDestination(ProductDTO productDTO);

	List<Product> sourceToDestination(List<ProductDTO> productDTOList);

	ProductDTO destinationToSource(Product product);

	List<ProductDTO> destinationToSource(List<Product> productsList);
}
