package com.example.SpringData;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>, QueryByExampleExecutor<Product>{
    List<Product> findByName(String name);

    default Product saveWithNameSuffix(Product product) {
//        String name = product.getName();
//        name += " TM";
        product.setName(product.getName() + " TM");
        return save(product);

    }

}
