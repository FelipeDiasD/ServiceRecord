package br.com.felipedias.ServiceRecord.controller;

import br.com.felipedias.ServiceRecord.Repository.CustomerRepository;
import br.com.felipedias.ServiceRecord.Repository.UserRepository;
import br.com.felipedias.ServiceRecord.model.Customer;
import br.com.felipedias.ServiceRecord.model.User;
import br.com.felipedias.ServiceRecord.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController{


    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
       List<User> foundUsers = userService.findAllUsers();
       return ResponseEntity.ok().body(foundUsers);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username){
        User foundUser = userService.findByUsername(username);
        return ResponseEntity.ok().body(foundUser);
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User userObj){

        var savedUser =  this.userService.createNewUser(userObj);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/{username}")
    public ResponseEntity updateExistingUser(@RequestBody User userObj, @PathVariable String username){

        var updatedUser = userService.updateExistingUser(username, userObj);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);

    }



}
