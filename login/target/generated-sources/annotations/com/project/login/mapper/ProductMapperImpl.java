package com.project.login.mapper;

import com.project.login.dto.ProductDTO;
import com.project.login.model.Product;
import com.project.login.model.ProductType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-02T18:08:46+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product sourceToDestination(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( productDTO.getProductId() );
        product.setProductName( productDTO.getProductName() );
        product.setPrice( productDTO.getPrice() );
        product.setProductType( productDTO.getProductType() );
        product.setAvailable( productDTO.isAvailable() );

        return product;
    }

    @Override
    public List<Product> sourceToDestination(List<ProductDTO> productDTOList) {
        if ( productDTOList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDTOList.size() );
        for ( ProductDTO productDTO : productDTOList ) {
            list.add( sourceToDestination( productDTO ) );
        }

        return list;
    }

    @Override
    public ProductDTO destinationToSource(Product product) {
        if ( product == null ) {
            return null;
        }

        Long productId = null;
        String productName = null;
        double price = 0.0d;
        ProductType productType = null;

        productId = product.getProductId();
        productName = product.getProductName();
        price = product.getPrice();
        productType = product.getProductType();

        boolean isAvailable = false;

        ProductDTO productDTO = new ProductDTO( productId, productName, price, productType, isAvailable );

        return productDTO;
    }

    @Override
    public List<ProductDTO> destinationToSource(List<Product> productsList) {
        if ( productsList == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( productsList.size() );
        for ( Product product : productsList ) {
            list.add( destinationToSource( product ) );
        }

        return list;
    }
}
