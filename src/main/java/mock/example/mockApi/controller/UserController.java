
package mock.example.mockApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mock.example.mockApi.model.User;
import mock.example.mockApi.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> setDataUser(@RequestBody User user){
        log.info("Creating new user");
        User createdUser = userService.setDataUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{userid}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<User>> getDataUser(@PathVariable String userid) {
        log.info("Fetching user with ID: {}", userid);
        List<User> users = userService.getDataUser(userid);
        return new ResponseEntity<>(users, HttpStatus.OK); 
    }
    
    @DeleteMapping(value = "/{userid}")
    public ResponseEntity<Void> delDataUser(@PathVariable String userid) {
        log.info("Deleting user with ID: {}", userid);
        userService.delDataUser(userid);
        return ResponseEntity.ok().build();
    }
}
