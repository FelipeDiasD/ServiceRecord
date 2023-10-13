package br.com.felipedias.ServiceRecord.config;

import br.com.felipedias.ServiceRecord.Repository.UserRepository;
import br.com.felipedias.ServiceRecord.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        User mainUser = new User(null, "Roberto", "GostoDeBiscoitos");

        userRepository.save(mainUser);

    }
}
