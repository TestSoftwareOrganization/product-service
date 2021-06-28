package com.revo.eshop.productservice.service;

import com.revo.eshop.productservice.shared.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto product);

    List<ProductDto> getAllProducts();
}
