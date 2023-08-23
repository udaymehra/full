package com.signup.SignupForm.Service;
import com.signup.SignupForm.UserRepository.UserRepository;
import com.signup.SignupForm.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<UserModel> getAllUsers(){
        List<UserModel> users=new ArrayList<>();
        userRepository.findAll().forEach(userModel -> users.add(userModel));
        return  users;
    }

    public Optional<UserModel> getUserinfo(String email){
        return userRepository.findById(email);
    }
    public UserModel createUser(UserModel user){
        userRepository.save(user);
        return  user;
    }
    public UserModel update(String email,UserModel updateduser){

       userRepository.deleteById(email);
       return userRepository.save(updateduser);

    }
    public Optional<UserModel> deleteUser(String email){
        Optional<UserModel> user=userRepository.findById(email);
        userRepository.deleteById(email);
        return user;
    }
}
