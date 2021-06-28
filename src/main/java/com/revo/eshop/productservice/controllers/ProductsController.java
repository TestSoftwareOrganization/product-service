package com.revo.eshop.productservice.controllers;

import com.revo.eshop.productservice.service.ProductService;
import com.revo.eshop.productservice.shared.ProductDto;
import com.revo.eshop.productservice.ui.model.CreateProductRequestModel;
import com.revo.eshop.productservice.ui.model.CreateProductResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    final Logger logger = LoggerFactory.getLogger(ProductsController.class);

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CreateProductResponseModel> createProduct(@Valid @RequestBody CreateProductRequestModel productDetails) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ProductDto productDto = modelMapper.map(productDetails, ProductDto.class);

        productDto = productService.createProduct(productDto);
        CreateProductResponseModel responseModel = modelMapper.map(productDto, CreateProductResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }

    @GetMapping
    public List<CreateProductResponseModel> getAllProducts() {
        List<CreateProductResponseModel> returnedValue = new ArrayList<>();
        List<ProductDto> productDtos = productService.getAllProducts();

        if (productDtos.isEmpty() && productDtos == null) {
            return returnedValue;
        }

        Type listType = new TypeToken<List<CreateProductResponseModel>>() {
        }.getType();

        returnedValue = new ModelMapper().map(productDtos,listType);
        logger.info("Returning " + returnedValue.size() + " products! Have a nice day!");

        return returnedValue;
    }
}
