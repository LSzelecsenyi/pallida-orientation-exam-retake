package com.greenfox.clothing.repo;

import com.greenfox.clothing.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClothingRepo extends CrudRepository<Product, Integer>{

    List<Product> findAllByUnitPriceEquals(double price);
    List<Product> findAllByUnitPriceIsGreaterThan(double price);
    List<Product> findAllByUnitPriceIsLessThan(double price);


//    List<Product> findDistinctByItemName();  I couldnt use them, if they were not commented out, i could not run the app, because of a bean error...
//    List<Product> findDistinctBySize();
//    @Query("SELECT DISTINCT size FROM warehouse")
//    List<String> findDistinctSizes();


}

