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
    private CustomerService customerService;


    public List<JobRecord> findAllRecords(){
        return recordRepository.findAll();
    }

    public JobRecord findRecordById(Long id){

        Optional<JobRecord> foundRecord = recordRepository.findById(id);
        return foundRecord.get();
    }

    public ResponseEntity insertNewRecord(JobRecord jobObj){

        if(jobObj.getDescription() == null || jobObj.getDescription().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DESCRIÇÃO É NECESSÁRIA");
        }

        else if( jobObj.getJobStatus() == null){

        }

        var customerId = jobObj.getCustomer().getId();

        if(customerId != null){

            var foundCustomer = customerService.findCustomerById(customerId);
            var addedJob = recordRepository.save(jobObj);
            foundCustomer.addJob(addedJob);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.findCustomerById(customerId));
        }

        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID DO CLIENTE NECESSÁRIO");
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

    public ResponseEntity deleteJobRecord(Long id){
        var targetJobRecord = recordRepository.findById(id).get();

        if(targetJobRecord != null){

            recordRepository.delete(targetJobRecord);
        }

        return ResponseEntity.accepted().body("TRABALHO DELETADO");
    }
}
