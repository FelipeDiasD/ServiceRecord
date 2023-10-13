package br.com.felipedias.ServiceRecord.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;



@Entity
@Table(name = "tb_service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private Date expectedEndDate;
    private String status;

}
