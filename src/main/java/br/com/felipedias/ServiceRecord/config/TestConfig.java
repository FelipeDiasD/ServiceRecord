package br.com.felipedias.ServiceRecord.config;

import br.com.felipedias.ServiceRecord.Repository.CustomerRepository;
import br.com.felipedias.ServiceRecord.Repository.RecordRepository;
import br.com.felipedias.ServiceRecord.Repository.UserRepository;
import br.com.felipedias.ServiceRecord.model.Customer;
import br.com.felipedias.ServiceRecord.model.JobRecord;
import br.com.felipedias.ServiceRecord.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RecordRepository recordRepository;
    @Override
    public void run(String... args) throws Exception {

/*        User mainUser = new User(null, "Roberto", "GostoDeBiscoitos");

        JobRecord firstJob = new JobRecord();
        List<JobRecord> jobs = new ArrayList<>();
        jobs.add(firstJob);



        Customer firstCustomer = new Customer(null, "Leonardo", "leo@email.com", null, jobs);

        userRepository.save(mainUser);
        recordRepository.save(firstJob);
        customerRepository.save(firstCustomer);*/

    }
}
