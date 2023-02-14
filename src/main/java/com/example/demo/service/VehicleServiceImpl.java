package com.example.demo.service;

import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleDTO;
import com.example.demo.model.VehicleMapper;
import com.example.demo.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;




@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;



    public List<VehicleDTO> findAll() {

        return vehicleRepository.findAll().stream()
                .map(VehicleMapper.INSTANCE::vehicleToDto)
                .collect(Collectors.toList());

    }

    public VehicleDTO findByVin(String vin) {

        return VehicleMapper.INSTANCE.vehicleToDto(vehicleRepository.findByVin(vin));

    }

    public void save(VehicleDTO vehicleDTO) {

        Vehicle vehicle = VehicleMapper.INSTANCE.dtoToVehicle(vehicleDTO);
        vehicleRepository.save(vehicle);

    }
}
