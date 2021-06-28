package com.revo.eshop.productservice.repositories;

import com.revo.eshop.productservice.data.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
