package br.com.felipedias.ServiceRecord.controller;


import br.com.felipedias.ServiceRecord.Repository.CustomerRepository;
import br.com.felipedias.ServiceRecord.model.Customer;
import br.com.felipedias.ServiceRecord.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {



    @Autowired
    private CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomer(){
        List<Customer> foundCustomers = customerService.findAllCustomers();
        return ResponseEntity.ok().body(foundCustomers);
    }
    @PostMapping
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer){
        return this.customerService.addCustomer(customer);
    }
}
