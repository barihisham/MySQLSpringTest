package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This means that this class is a Controller
//@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
@CrossOrigin
public class MainController {

    @Autowired
    private UserRepository userRepository;

    //ADD DATA
    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){

        User u = new User();
        u.setName(name);
        u.setEmail(email);
        userRepository.save(u);
        return "Saved";
        //test?
    }

    //GET DATA
    /*
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
     */
    @RequestMapping(path ="/all")
    //@GetMapping("/all")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
