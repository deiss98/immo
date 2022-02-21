package com.siri.immo.controller;

import com.siri.immo.model.Products;
import com.siri.immo.model.Users;
import com.siri.immo.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/signup")
    public ResponseEntity<Users> createUsers(@RequestBody Users users, HttpServletRequest httpServletRequest) throws URISyntaxException {
        Users result = usersRepository.save(users);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Users> updateUsers(@RequestBody Users users, HttpServletRequest httpServletRequest) throws URISyntaxException {
        if (users.getId() == null) { }
        Users result = usersRepository.save(users);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/list-users")
    public ResponseEntity<List<Users>> getUsers(HttpServletRequest httpServletRequest) {
        List<Users> users = usersRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

}
