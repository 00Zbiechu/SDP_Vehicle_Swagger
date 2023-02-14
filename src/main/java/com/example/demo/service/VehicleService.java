package com.example.demo.service;

import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleDTO;

import java.util.List;

public interface VehicleService {

    List<VehicleDTO> findAll();

    VehicleDTO findByVin(String vin);

    void save(VehicleDTO vehicleDTO);

}
