package br.com.felipedias.ServiceRecord.services;

import br.com.felipedias.ServiceRecord.Repository.UserRepository;
import br.com.felipedias.ServiceRecord.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity create(@RequestBody User user) throws Exception{


        var foundUser = this.userRepository.findByUsername(user.getUsername());

        if(foundUser != null){
            //Throw an exception or an 400 status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("USUÁRIO COM A MESMA USENAME NA BASE DE DADOS");
        }
        var userCreated = this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }


}
