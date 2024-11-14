package com.example.demo.controller;

import com.example.demo.bo.CreateUserRequest;
import com.example.demo.bo.UserResponse;
import com.example.demo.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
    public ResponseEntity<CreateUserRequest> updateProfile(@RequestBody CreateUserRequest updatedInfo) {
        CreateUserRequest response = userService.updateUserIno(updatedInfo);

        // Check if the response is not null (indicating a successful update)
        if (response != null) {
            // Return ok Created status code along with the updated user data
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            // Handle the case where the creation was not successful (e.g., validation failed)
            // You can return a different status code or error message as needed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
