package br.com.felipedias.ServiceRecord.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Entity
@Table(name = "tb_users")
@Data
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true)
    private String username;
    private String password;
}
