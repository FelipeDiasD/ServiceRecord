package br.com.felipedias.ServiceRecord.serviceTests;

import br.com.felipedias.ServiceRecord.controller.CustomerController;
import br.com.felipedias.ServiceRecord.model.Address;
import br.com.felipedias.ServiceRecord.model.Customer;
import br.com.felipedias.ServiceRecord.model.JobRecord;
import br.com.felipedias.ServiceRecord.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CustomerTests {

    @Mock
    CustomerController customerController;

    @Test
    void validarGet() throws Exception {


        List<JobRecord> jobs = new ArrayList<>();
        Customer customer = new Customer(UUID.randomUUID(), "Alex", "alex@email.com", new Address(), jobs);

       customerController.createNewCustomer(customer);

       Assertions.assertEquals(customer, customerController.findCustomerById(customer.getId()));
    }

}
