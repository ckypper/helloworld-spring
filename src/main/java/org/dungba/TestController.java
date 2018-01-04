package org.dungba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    
    @Autowired
    private UserRepository repository;

    @RequestMapping(path="/")
    public ResponseEntity<User> index() {
        return new ResponseEntity<User>(repository.getUser(1), HttpStatus.OK);
    }
}
