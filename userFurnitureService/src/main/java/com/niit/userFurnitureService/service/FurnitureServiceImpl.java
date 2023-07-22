package com.niit.userFurnitureService.service;

import com.niit.userFurnitureService.domain.Furniture;
import com.niit.userFurnitureService.exception.FurnitureAlreadyExistsException;
import com.niit.userFurnitureService.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FurnitureServiceImpl implements FurnitureService {
    private FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureServiceImpl(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public Furniture saveFurniture(Furniture furniture) throws FurnitureAlreadyExistsException {
    if(furnitureRepository.findById(furniture.getId()).isPresent()){
        throw new FurnitureAlreadyExistsException();
    }
    else
        return furnitureRepository.save(furniture);
    }

    @Override
    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }

    @Override
    public boolean deleteFurniture(int id) {
        if(furnitureRepository.findById(id).isPresent())
        {
            furnitureRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Furniture updateFurniture(Furniture furniture, int id) {
        Optional<Furniture> findFurniture=furnitureRepository.findById(id);
        if (findFurniture.isEmpty()){
            return null;
        }
        Furniture existFurniture=findFurniture.get();
        if (furniture.getId()!=0){
            existFurniture.setId(furniture.getId());
        }
        if (furniture.getName()!=null){
            existFurniture.setName(furniture.getName());
        }
        if (furniture.getPrice()!=0){
            existFurniture.setPrice(furniture.getPrice());
        }
        return furnitureRepository.save(existFurniture);
    }

    @Override
    public Optional<Furniture> getOneFurniture(int id) {
        return furnitureRepository.findById(id);
    }
}
