package br.com.felipedias.ServiceRecord.services;

import br.com.felipedias.ServiceRecord.Repository.RecordRepository;
import br.com.felipedias.ServiceRecord.model.JobRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobRecordService {

    @Autowired
    private RecordRepository recordRepository;


    public List<JobRecord> findAllRecords(){
        return recordRepository.findAll();
    }

    public JobRecord findRecordById(Long id){

        Optional<JobRecord> foundRecord = recordRepository.findById(id);
        return foundRecord.get();
    }
}
