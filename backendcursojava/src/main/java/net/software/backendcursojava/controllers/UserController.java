package net.software.backendcursojava.controllers;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.software.backendcursojava.models.request.UserDetailRequestModel;
import net.software.backendcursojava.models.responses.UserRest;

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {

    @GetMapping //obtener consultar informacion
    public String getUser () {
        return "obtener usuarios";
    }
    @PostMapping //creando informacion
    //public String createrUser(@requestBody UserDetailRequestModel UserDetails){
        public UserRest createrUser(@RequestBody UserDetailRequestModel UserDetails){  
        //return "Creando usuarios";
        return null;
    }
   
}