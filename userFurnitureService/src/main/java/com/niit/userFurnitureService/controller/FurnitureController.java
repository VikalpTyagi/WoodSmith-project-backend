package com.niit.userFurnitureService.controller;

import com.niit.userFurnitureService.domain.Furniture;
import com.niit.userFurnitureService.exception.FurnitureAlreadyExistsException;
import com.niit.userFurnitureService.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins = "http://localhost:4200")
public class FurnitureController {

    private FurnitureService furnitureService;
    @Autowired
    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @PostMapping("/furniture/save")
    ResponseEntity<?> saveFurniture(@RequestBody Furniture furniture) throws FurnitureAlreadyExistsException {
    return new ResponseEntity<>(furnitureService.saveFurniture(furniture), HttpStatus.ACCEPTED);
    }
    @GetMapping("/furniture")
    ResponseEntity<?> getFurniture() throws FurnitureAlreadyExistsException {
        return new ResponseEntity<>(furnitureService.getAllFurniture(), HttpStatus.OK);
    }
    @DeleteMapping("furniture/delete/{id}")
    ResponseEntity<?> deleteFurniture(@PathVariable int id){
        return new ResponseEntity<>(furnitureService.deleteFurniture(id),HttpStatus.OK);
    }
    @PutMapping("furniture/update/{id}")
    public ResponseEntity<?> updateFurniture(@RequestBody Furniture furniture, @PathVariable int id) {
        return new ResponseEntity<>(furnitureService.updateFurniture(furniture, id), HttpStatus.OK);
    }
    @GetMapping("/furniture/one/{id}")
    ResponseEntity<?> getOneFurniture(@PathVariable int id){
        return new ResponseEntity<>(furnitureService.getOneFurniture(id), HttpStatus.OK);
    }
}
