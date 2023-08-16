package com.example.simplerestapi.repository;


import com.example.simplerestapi.model.Car;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    default Car getByIdOrThrowException(@NotNull Long id){
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
