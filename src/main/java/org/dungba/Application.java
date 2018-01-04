package org.dungba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class Application {
    
    @Autowired
    private IUserRepository repository;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name="id") int id) {
        return new ResponseEntity<User>(repository.getUser(id), HttpStatus.OK);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
