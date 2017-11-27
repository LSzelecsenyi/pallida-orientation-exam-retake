package com.greenfox.clothing.repo;

import com.greenfox.clothing.model.Warehouse;
import org.springframework.data.repository.CrudRepository;

public interface ClothingRepo extends CrudRepository<Warehouse, Integer>{

}
