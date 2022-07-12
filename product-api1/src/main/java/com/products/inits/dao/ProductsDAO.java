package com.products.inits.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import com.products.inits.entitys.*;

public interface ProductsDAO extends JpaRepository<Product, Long> {

}
