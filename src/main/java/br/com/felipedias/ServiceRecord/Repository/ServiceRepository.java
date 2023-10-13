package br.com.felipedias.ServiceRecord.Repository;

import br.com.felipedias.ServiceRecord.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {
}
