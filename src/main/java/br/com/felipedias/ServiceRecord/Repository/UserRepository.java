package br.com.felipedias.ServiceRecord.Repository;

import br.com.felipedias.ServiceRecord.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
}
