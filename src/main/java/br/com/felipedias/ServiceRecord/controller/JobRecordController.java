package br.com.felipedias.ServiceRecord.controller;

import br.com.felipedias.ServiceRecord.model.JobRecord;
import br.com.felipedias.ServiceRecord.services.JobRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class JobRecordController {

    @Autowired
    private JobRecordService recordService;

    @GetMapping
    public ResponseEntity<List<JobRecord>> findAllRecords(){
        List<JobRecord> foundRecords = recordService.findAllRecords();
        return ResponseEntity.ok().body(foundRecords);

    }

    @GetMapping("/{id}")
    public ResponseEntity<JobRecord> findRecordById(@PathVariable Long id){
        JobRecord returnedObj = recordService.findRecordById(id);
        return ResponseEntity.ok().body(returnedObj);
    }

    @PostMapping
    public ResponseEntity<JobRecord> insertNewRecord(@RequestBody JobRecord jobRecordObj){

       JobRecord returnedObj = recordService.insertNewRecord(jobRecordObj);
        return ResponseEntity.ok().body(returnedObj);
    }

}
