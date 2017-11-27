package com.greenfox.clothing.repository;

import com.greenfox.clothing.model.Warehouse;
import org.springframework.data.repository.CrudRepository;

public interface ClothingRepository extends CrudRepository<Warehouse, Long> {
}
