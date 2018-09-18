package com.example.example_db_auth.repository;

import com.example.example_db_auth.domain.Product;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByName(String name);

}
