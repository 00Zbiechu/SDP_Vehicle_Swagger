package com.example.demo.controller;


import com.example.demo.model.VehicleDTO;
import com.example.demo.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;


    @GetMapping
    public ResponseEntity<List<VehicleDTO>> findAll(){

        return ResponseEntity.ok(vehicleService.findAll());

    }

    @GetMapping("/{vin}")
    public ResponseEntity<VehicleDTO> findByVin(@PathVariable("vin") String vin){

       return ResponseEntity.ok(vehicleService.findByVin(vin));

    }

    @PostMapping
    public ResponseEntity<VehicleDTO> save(@RequestBody VehicleDTO vehicle){

        vehicleService.save(vehicle);
        return ResponseEntity.ok(vehicle);

    }


}
