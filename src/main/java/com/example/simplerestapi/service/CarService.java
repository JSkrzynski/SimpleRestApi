package com.example.simplerestapi.service;

import com.example.simplerestapi.mapper.CarMapper;
import com.example.simplerestapi.model.Car;
import com.example.simplerestapi.model.CarCreateRequest;
import com.example.simplerestapi.model.CarDetails;
import com.example.simplerestapi.repository.CarRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDetails> getAllCars() {

        return carRepository.findAll()
                .stream()
                .filter( car -> StringUtils.isNotBlank(car.getMake()))
                .map(carMapper::toDetails)
                .collect(Collectors.toList());
    }

    @NotNull
    public CarDetails addNewCar(@NotNull CarCreateRequest request) {
        Car entity = carMapper.toEntity(request);
        Car saved = carRepository.save(entity);

        return carMapper.toDetails(saved);
    }

    @NotNull
    public CarDetails getCarById(@NotNull Long id) {
        Car car = carRepository.getByIdOrThrowException(id);

        return carMapper.toDetails(car);
    }

    @NotNull
    public CarDetails updateCarDetails(@NotNull Long id,@NotNull CarCreateRequest request) {
        Car car = carRepository.getByIdOrThrowException(id);



        Car updatedCar = carMapper.update(car, request);
        Car saved = carRepository.save(updatedCar);

        return carMapper.toDetails(saved);
    }

    public List<CarDetails> deleteCarById(@NotNull Long id) {
        carRepository.deleteById(id);

        return getAllCars();
    }
}
