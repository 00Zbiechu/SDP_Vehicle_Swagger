package com.example.demo.controller;


import com.example.demo.model.VehicleDTO;
import com.example.demo.service.VehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @ApiOperation(value = "Return list of all vehicle from database")
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> findAll(){

        return ResponseEntity.ok(vehicleService.findAll());

    }

    @ApiOperation(value = "Return object of vehicle from database by vin of car")
    @GetMapping("/{vin}")
    public ResponseEntity<VehicleDTO> findByVin(@ApiParam(value = "Unique vin of vehicle", example = "JNRAS08U08X102892") @PathVariable("vin") String vin){

       return ResponseEntity.ok(vehicleService.findByVin(vin));

    }

    @ApiOperation(value = "Add new vehicle to db")
    @PostMapping
    public ResponseEntity<VehicleDTO> save(@ApiParam(value = "VehicleDTO object")@RequestBody VehicleDTO vehicle){

        vehicleService.save(vehicle);
        return ResponseEntity.ok(vehicle);

    }


}
