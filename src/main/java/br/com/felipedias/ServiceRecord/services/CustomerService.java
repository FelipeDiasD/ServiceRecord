package br.com.felipedias.ServiceRecord.services;

import br.com.felipedias.ServiceRecord.Repository.CustomerRepository;
import br.com.felipedias.ServiceRecord.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public List<Customer> findCustomerByName(String name){
        return customerRepository.findByName(name);
    }

    public ResponseEntity<Customer> addCustomer(Customer customer){

        //Validations
        //IS this customer already registered?
        //There is obligatory some field missing?
        Customer receivedCustomer = customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(receivedCustomer);
    }

    public ResponseEntity<Customer> updateCustomer(Customer customer, UUID id){

        //Validations
        //Is this customer already registered?
        //There is obligatory some field missing?

        //Find desired customer
        var targetCustomer = customerRepository.findById(id);

        //Verify fields for change

        //Modify existing customer with information

        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
