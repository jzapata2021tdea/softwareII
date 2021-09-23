package net.software.backendcursojava.services;

import org.springframework.stereotype.Service;

import net.software.backendcursojava.shared.dto.UserDTO;

@Service
public class UserService implements UserServiceInterface{
  
    @Override
    public UserDTO createrUser(UserDTO userDTO) {
        // TODO logica creacion de usuarios
        return null;
    }

}
