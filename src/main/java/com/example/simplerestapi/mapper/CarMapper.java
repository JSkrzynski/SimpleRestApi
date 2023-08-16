package com.example.simplerestapi.mapper;

import com.example.simplerestapi.model.Car;
import com.example.simplerestapi.model.CarCreateRequest;
import com.example.simplerestapi.model.CarDetails;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        builder = @Builder(disableBuilder = true),
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CarMapper {
    @Mapping(target = "id", ignore = true)
    Car toEntity(@NotNull CarCreateRequest request);

    CarDetails toDetails(@NotNull Car car);

    @Mapping(target = "id", ignore = true)
    Car update(@NotNull @MappingTarget Car car, @NotNull CarCreateRequest request);

}
