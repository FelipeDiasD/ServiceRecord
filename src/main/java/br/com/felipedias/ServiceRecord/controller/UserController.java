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




}
