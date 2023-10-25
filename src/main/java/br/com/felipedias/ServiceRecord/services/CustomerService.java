package br.com.felipedias.ServiceRecord.services;

import br.com.felipedias.ServiceRecord.Repository.CustomerRepository;
import br.com.felipedias.ServiceRecord.model.Customer;
import br.com.felipedias.ServiceRecord.model.JobRecord;
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

    public ResponseEntity addCustomer(Customer customer){

        //Validations
        //IS this customer already registered?
        var email = customer.getEmail();

        if(customerRepository.findByEmail(email) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CLIENTE JÁ REGISTRADO NA PLATAFORMA");
        }

        var jobs = customer.getJobs();

        for(int i = 0; i < jobs.size(); i++){
            JobRecord job = jobs.get(i);
            job.setCustomer(customer);
        }




        //There is obligatory some field missing?
        Customer receivedCustomer = customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(receivedCustomer);
    }

    public ResponseEntity<Customer> updateCustomer(Customer customer, UUID id){

        //Find desired customer for changes
        var targetCustomer = customerRepository.findById(id).get();

        //Validations


        //There is obligatory some field missing?



        //Verify fields for change
        //Modify existing customer with information
        if(customer.getName() != null){
            targetCustomer.setName(customer.getName());
        }
        else if (customer.getEmail() != null) {
            targetCustomer.setEmail(customer.getEmail());
        }
        else if(customer.getAddress() != null){
            targetCustomer.setAddress(customer.getAddress());
        }

        customerRepository.save(targetCustomer);


        return ResponseEntity.status(HttpStatus.CREATED).body(targetCustomer);
    }
}
