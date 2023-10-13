package br.com.felipedias.ServiceRecord.Repository;

import br.com.felipedias.ServiceRecord.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
