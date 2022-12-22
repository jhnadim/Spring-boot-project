package com.example.FulLstackbackend.Controller;


//import com.example.fullstackbackend.exception.UserNotFoundException;
import com.example.FulLstackbackend.Exception.RootException;
import com.example.FulLstackbackend.Model.Register;
import com.example.FulLstackbackend.Repository.MainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class RegisterController {
    @RequestMapping(value = "/welcome")
    public String welcome(){
        String text = "Hello! welcome to Employee register application. This is from backend";
        return text;
    }


    @Autowired
    private MainRepo userRepository;
    @GetMapping("/users")
    List<Register> getAllUsers() {
        return userRepository.findAll();
    }



    @PostMapping("/user")
    Register newUser(@RequestBody Register newUser) {
        return userRepository.save(newUser);
    }




    @GetMapping("/user/{id}")
    Register getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RootException(id));
    }
//
    @PutMapping("/user/{id}")
    Register updateUser(@RequestBody Register newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RootException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new RootException(id);
        }
        userRepository.deleteById(id);
        return  "User with id ("+id+") has been deleted successfully.";
    }



}