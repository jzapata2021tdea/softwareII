package net.software.backendcursojava.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.software.backendcursojava.models.request.UserDetailRequestModel;
import net.software.backendcursojava.models.responses.UserRest;
import net.software.backendcursojava.services.UserServiceInterface;
import net.software.backendcursojava.shared.dto.UserDTO;

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {

    @Autowired
    UserServiceInterface userService;

    @GetMapping //obtener consultar informacion
    public String getUser() {
        return "Obtener usuarios";
    }

    @PostMapping //creando informacion
    //public String createrUser(@requestBody UserDetailRequestModel UserDetails){
        public UserRest createrUser(@RequestBody UserDetailRequestModel userDetails){  
           
            UserRest userToReturn = new UserRest();

            UserDTO userDTO = new UserDTO();

            extracted(userDetails, userDTO);

            UserDTO createrUser = userService.createrUser(userDTO);

            BeanUtils.copyProperties(createrUser, userToReturn);

            //return "Creando usuarios";
        return userToReturn;
    }

    private void extracted(UserDetailRequestModel userDetails, UserDTO userDTO) {
        BeanUtils.copyProperties(userDetails, userDTO);
    }
    
    }
    
   
