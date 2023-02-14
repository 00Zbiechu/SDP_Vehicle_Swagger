package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class VehicleDTO {

    private String vin;
    private String model;
    private String brand;
    private Integer productionYear;

}
