package br.com.felipedias.ServiceRecord.services;

import br.com.felipedias.ServiceRecord.Repository.CustomerRepository;
import br.com.felipedias.ServiceRecord.Repository.RecordRepository;
import br.com.felipedias.ServiceRecord.model.JobRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobRecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public List<JobRecord> findAllRecords(){
        return recordRepository.findAll();
    }

    public JobRecord findRecordById(Long id){

        Optional<JobRecord> foundRecord = recordRepository.findById(id);
        return foundRecord.get();
    }

    public ResponseEntity insertNewRecord(JobRecord jobObj){

        var customerId = jobObj.getCustomer().getId();

        if(customerId != null){

            var foundCustomer = customerRepository.findById(customerId).get();
            foundCustomer.addJob(recordRepository.save(jobObj));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(foundCustomer);
        }

        else
            return ResponseEntity.status(HttpStatus.CREATED).body(recordRepository.save(jobObj));
    }

    public JobRecord updateRecord(JobRecord jobRecordObj, Long id) {

        var targetJobRecord = recordRepository.findById(id).get();

        if (jobRecordObj.getJobStatus() != null) {
            targetJobRecord.setJobStatus(jobRecordObj.getJobStatus());
        }
        else if (jobRecordObj.getDescription() != null) {
            targetJobRecord.setDescription(jobRecordObj.getDescription());
        }

       return recordRepository.save(targetJobRecord);
    }
}
