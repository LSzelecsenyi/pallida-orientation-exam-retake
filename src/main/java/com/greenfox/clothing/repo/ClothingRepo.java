package com.greenfox.clothing.repo;

import com.greenfox.clothing.model.Warehouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClothingRepo extends CrudRepository<Warehouse, Integer>{

    List<Warehouse> findAllByUnitPriceEquals(double price);
    List<Warehouse> findAllByUnitPriceIsGreaterThan(double price);
    List<Warehouse> findAllByUnitPriceIsLessThan(double price);


//    List<Warehouse> findDistinctByItemName();
//    List<Warehouse> findDistinctBySize();
//    @Query("SELECT DISTINCT size FROM warehouse")
//    List<String> findDistinctSizes();


}

