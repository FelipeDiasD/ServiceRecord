package br.com.felipedias.ServiceRecord.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "tb_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @JsonManagedReference
    @NonNull
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<JobRecord> jobs =  new ArrayList<>();

    public void addJob(JobRecord jobRecord){
        jobs.add(jobRecord);
    }

}