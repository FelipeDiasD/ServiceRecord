package br.com.felipedias.ServiceRecord.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Entity
@Table(name = "tb_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private Long id;
    @JsonBackReference
    @OneToOne(mappedBy = "address")
    private Customer customer;
    private String street;
    private String city;
    private String state;
    private String cep;
    private String country;


}
