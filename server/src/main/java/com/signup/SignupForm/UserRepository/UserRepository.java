package com.signup.SignupForm.UserRepository;

import com.signup.SignupForm.Model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel,String> {
}
