package br.com.felipedias.ServiceRecord.Repository;

import br.com.felipedias.ServiceRecord.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Customer findByName(String name);
}
