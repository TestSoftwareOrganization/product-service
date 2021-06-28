package com.revo.eshop.productservice.service;

import com.revo.eshop.productservice.data.ProductEntity;
import com.revo.eshop.productservice.repositories.ProductRepository;
import com.revo.eshop.productservice.shared.ProductDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto product) {
        product.setProductId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        productEntity = productRepository.save(productEntity);
        ProductDto returnedValue = modelMapper.map(productEntity, ProductDto.class);
        return returnedValue;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductEntity> productEntities = (List<ProductEntity>) productRepository.findAll();
        Type listType = new TypeToken<List<ProductDto>>() {
        }.getType();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<ProductDto> returnedValue = modelMapper.map(productEntities, listType);
        return returnedValue;
    }
}
