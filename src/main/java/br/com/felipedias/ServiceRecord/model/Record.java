package br.com.felipedias.ServiceRecord.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "tb_service")
@Data
public class Record {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private Date deliveryDate;
    private String status;

}

