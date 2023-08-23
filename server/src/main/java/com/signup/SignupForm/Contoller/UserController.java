package com.signup.SignupForm.Contoller;

import com.signup.SignupForm.Model.UserModel;
import com.signup.SignupForm.Service.UserService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(method = RequestMethod.GET,value = "/users")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping(method = RequestMethod.GET,value = "/users/{email}")
    public Optional<UserModel> getUserinfo(@PathVariable String email) {
        return userService.getUserinfo(email);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public UserModel createUser(@RequestBody UserModel user){
        return userService.createUser(user);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/users/{email}")
    public UserModel update(@PathVariable String email,@RequestBody UserModel userModel){
        return userService.update(email,userModel);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/users/{email}")
    public Optional<UserModel> deleteUserModel(@PathVariable String email){
    return userService.deleteUser(email);
    }


}
