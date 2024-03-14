package br.com.felipedias.ServiceRecord.services;

import br.com.felipedias.ServiceRecord.Repository.UserRepository;
import br.com.felipedias.ServiceRecord.errors.ResourceNotFoundException;
import br.com.felipedias.ServiceRecord.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public User findByUsername(String username){
        try {
            return userRepository.findByUsername(username);
        }
        catch (NoSuchElementException e){
            throw new ResourceNotFoundException(username);
        }
    }


    public ResponseEntity createNewUser(@RequestBody User user){


        var foundUser = this.userRepository.findByUsername(user.getUsername());

        if(foundUser != null){
            //Throw an exception or an 400 status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("USUÁRIO COM A MESMA USERNAME NA BASE DE DADOS");
        }


        var userCreated = this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    public User updateExistingUser(String targetUsername, User userObj){

        try {
            var targetUser = findByUsername(targetUsername);

            if(userObj.getUsername() != null || !userObj.getUsername().isEmpty()){
                targetUser.setUsername(userObj.getUsername());
            }
            else if (userObj.getPassword() != null || !userObj.getPassword().isEmpty()) {
                targetUser.setPassword(userObj.getPassword());
            }
            return userRepository.save(targetUser);
        } catch (NoSuchElementException e){

            throw new ResourceNotFoundException(userObj.getId());
        }





    }



}
