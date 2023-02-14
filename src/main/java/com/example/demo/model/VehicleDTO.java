package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class VehicleDTO {

    @ApiModelProperty(value = "Vin of vehicle")
    private String vin;
    @ApiModelProperty("Model of car")
    private String model;
    @ApiModelProperty("Brand of car")
    private String brand;
    @ApiModelProperty("Year when car was produced")
    private Integer productionYear;

}
