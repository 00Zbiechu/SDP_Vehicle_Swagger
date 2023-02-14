package com.example.demo;


import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleDTO;
import com.example.demo.model.VehicleMapper;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {

    @Mock
    VehicleRepository vehicleRepository;

    VehicleServiceImpl vehicleService;

    @Before
    public void setUp(){

        given(vehicleRepository.findAll()).willReturn(create_mock_data_for_vehicle_repo_find_all());

        given(vehicleRepository.findByVin(anyString()))
                .willReturn(new Vehicle(1l,"1GYS3NKJ5FR513133","M3","BMW",2010));

        vehicleService = new VehicleServiceImpl(vehicleRepository);


    }

    @Test
    public void should_has_three_values_at_start(){


        //when
        List<VehicleDTO> list = vehicleService.findAll();

        //then
        Assert.assertEquals(3,list.size());

    }


    @Test
    public void should_return_vehicle_with_vin_same_as_argument(){

        //given
        VehicleDTO vehicleDTOTest = new VehicleDTO("1GYS3NKJ5FR513133","M3","BMW",2010);

        //when
        VehicleDTO vehicleDTO = vehicleService.findByVin(anyString());

        //then
        Assert.assertEquals(vehicleDTOTest.getVin(), vehicleDTO.getVin());

    }

    private List<Vehicle> create_mock_data_for_vehicle_repo_find_all(){


        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle(1l,"1GYS3NKJ5FR513133","M3","BMW",2010));
        list.add(new Vehicle(1l,"1GTN2UEC8EZ326495","A3","Audi",2012));
        list.add(new Vehicle(1l,"2HGFB2F53EH553085","RX8","Mazda",1999));

        return list;

    }


}
