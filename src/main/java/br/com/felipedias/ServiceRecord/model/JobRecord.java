package br.com.felipedias.ServiceRecord.model;

import br.com.felipedias.ServiceRecord.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;



@Entity
@Table(name = "tb_job_record")
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
    private LocalDateTime expectedEndDate;
    private String status;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    private Status jobStatus;

}

