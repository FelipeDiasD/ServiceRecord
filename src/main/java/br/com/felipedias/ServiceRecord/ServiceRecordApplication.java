package br.com.felipedias.ServiceRecord;

import br.com.felipedias.ServiceRecord.controller.UserController;
import br.com.felipedias.ServiceRecord.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ServiceRecordApplication {
	public static void main(String[] args) {



		SpringApplication.run(ServiceRecordApplication.class, args);
;

	}

}
