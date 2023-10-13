package br.com.felipedias.ServiceRecord.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "tb_address")
@Data
public class Address {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @OneToOne(mappedBy = "address")
    private Customer customer;
    private String street;
    private String city;
    private String state;
    private String cep;
    private String country;


}
