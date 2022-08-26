package com.example.SpringData;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>,
        QueryByExampleExecutor<Product>, JpaSpecificationExecutor<Product> {

    List<Product> findByName(String name);

    default Product saveWithNameSuffix(Product product) {
        product.setName(product.getName() + " TM");
        return save(product);
    }

    @Modifying
    @Query("select p from Product p where p.price > ?1")
    List<Product> findProductsWithHighPrices(Integer price);

}