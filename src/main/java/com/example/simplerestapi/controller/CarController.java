package com.example.simplerestapi.controller;

import com.example.simplerestapi.model.CarCreateRequest;
import com.example.simplerestapi.model.CarDetails;
import com.example.simplerestapi.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping(value = "/cars")
    public ResponseEntity<List<CarDetails>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping("/cars")
    public ResponseEntity<CarDetails> addNewCar(@RequestBody CarCreateRequest request) {
        return ResponseEntity.ok(carService.addNewCar(request));
    }

    @GetMapping(value = "/car/{id}")
    public ResponseEntity<CarDetails> getCarById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<CarDetails> updateCarDetails(@PathVariable("id") Long id, @RequestBody CarCreateRequest request) {
        return ResponseEntity.ok(carService.updateCarDetails(id, request));
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<List<CarDetails>> deleteCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.deleteCarById(id));
    }


}