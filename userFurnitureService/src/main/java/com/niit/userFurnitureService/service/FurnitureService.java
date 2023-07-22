package com.niit.userFurnitureService.service;

import com.niit.userFurnitureService.domain.Furniture;
import com.niit.userFurnitureService.exception.FurnitureAlreadyExistsException;

import java.util.List;
import java.util.Optional;

public interface FurnitureService {
   public Furniture saveFurniture(Furniture furniture) throws FurnitureAlreadyExistsException;
   public List<Furniture> getAllFurniture();
   public boolean deleteFurniture(int id);
   public Furniture updateFurniture(Furniture furniture, int id);
   public Optional<Furniture> getOneFurniture(int id);
}
