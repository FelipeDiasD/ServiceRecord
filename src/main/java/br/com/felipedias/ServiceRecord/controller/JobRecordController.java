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
    public ResponseEntity insertNewRecord(@RequestBody JobRecord jobRecordObj){

      return recordService.insertNewRecord(jobRecordObj);

    }

    @PutMapping("/{id}")
    public ResponseEntity<JobRecord> updateExistingRecord(@RequestBody JobRecord jobRecord, @PathVariable Long id){

        JobRecord updatedRecord = recordService.updateRecord(jobRecord, id);

        return ResponseEntity.ok().body(updatedRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExistingRecord (@PathVariable Long id){

        return recordService.deleteJobRecord(id);
    }




}
