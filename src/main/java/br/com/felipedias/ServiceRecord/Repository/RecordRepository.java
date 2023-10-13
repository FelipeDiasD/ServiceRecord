package br.com.felipedias.ServiceRecord.Repository;

import br.com.felipedias.ServiceRecord.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecordRepository extends JpaRepository<Record, UUID> {
}
