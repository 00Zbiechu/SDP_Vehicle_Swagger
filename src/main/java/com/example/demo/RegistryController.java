package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/registry")
public class RegistryController {

    @GetMapping("/{vin}")
    public Vehicle get(@PathVariable("vin") String vin){

        Vehicle v = new Vehicle();
        v.setVin(vin);
        v.setModel("Arteon");
        v.setBrand("VW");
        v.setProductionYear(2022);

        log.info("Returning vehicle with vin: {}",vin);

        return v;

    }


}
