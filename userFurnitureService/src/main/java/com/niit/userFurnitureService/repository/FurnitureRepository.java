package com.niit.userFurnitureService.repository;

import com.niit.userFurnitureService.domain.Furniture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends MongoRepository<Furniture,Integer> {

}
