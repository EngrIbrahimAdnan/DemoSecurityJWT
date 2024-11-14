package com.example.demo.controller;

import com.example.demo.bo.CreateUserRequest;
import com.example.demo.bo.UserResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

    @GetMapping("/sayHi")
    public String sayHi() {
        return "Hi, you are an authenticated user";
    }


    //Setup as follows:
    //Post on postman (noAuth): http://localhost:8080/api/v1/auth/signup
    //{"name":"IbrashiSDSDm",
    //"username":"IbrahiSSSSm123",
    //"password":"SkwnejNJ3849",
    //"role":"admSSin"}

    //Post on postman (noAuth): http://localhost:8080/api/v1/auth/login
    //{"name":"IbrashiSDSDm",
    //"username":"IbrahiSSSSm123",
    //"password":"SkwnejNJ3849",
    //"role":"admSSin"}

    //With token: eyJhbGciOiJIUzI1NiJ9....
    //Post on postman (noAuth): http://localhost:8080/api/v1/user/update-profile
//    { "username":"NewUsername",
//            "email":"NewEmail",
//            "phoneNumber":"NewNumber",
//            "address":"NewAddress",
//            "password":"tHIS IS MY PASSWORD"}

    @PostMapping("/update-profile")
    public String updateProfile(@RequestBody CreateUserRequest updatedInfo) {
        System.out.println(updatedInfo.getUsername() + updatedInfo.getEmail() + updatedInfo.getPhoneNumber() + updatedInfo.getAddress() + updatedInfo.getPassword());
        return updatedInfo.getUsername() + updatedInfo.getEmail() + updatedInfo.getPhoneNumber() + updatedInfo.getAddress() + updatedInfo.getPassword();
    }
}
