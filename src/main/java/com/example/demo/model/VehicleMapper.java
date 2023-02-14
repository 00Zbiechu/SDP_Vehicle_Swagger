package com.example.demo.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {

    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    VehicleDTO vehicleToDto(Vehicle vehicle);

    Vehicle dtoToVehicle(VehicleDTO vehicleDTO);

}
