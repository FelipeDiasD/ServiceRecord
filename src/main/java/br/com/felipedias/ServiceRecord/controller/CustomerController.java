package br.com.felipedias.ServiceRecord.controller;

import br.com.felipedias.ServiceRecord.model.Customer;
import br.com.felipedias.ServiceRecord.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity findCustomerById(@PathVariable UUID id) throws Exception {
        var foundCustomer = customerService.findCustomerById(id);

        return ResponseEntity.status(HttpStatus.OK).body(foundCustomer);
    }
    @PostMapping
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer){
        return this.customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable UUID id){
        return this.customerService.updateCustomer(customer, id);
    }
}
