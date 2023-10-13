package br.com.felipedias.ServiceRecord.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "tb_customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany
    private List<Service> servicos;

}