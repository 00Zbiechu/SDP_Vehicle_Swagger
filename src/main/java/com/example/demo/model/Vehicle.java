package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_veh"
    )
    @SequenceGenerator(
            name = "seq_veh",
            initialValue = 4
    )
    @Column(name = "id", nullable = false)
    private Long id;
    private String vin;
    private String model;
    private String brand;
    private Integer productionYear;

}
