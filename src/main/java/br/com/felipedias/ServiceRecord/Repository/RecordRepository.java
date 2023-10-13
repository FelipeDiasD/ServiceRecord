package br.com.felipedias.ServiceRecord.Repository;

import br.com.felipedias.ServiceRecord.model.JobRecord;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordRepository extends JpaRepository<JobRecord, Long> {
}
