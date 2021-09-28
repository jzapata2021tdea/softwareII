package net.software.backendcursojava.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import net.software.backendcursojava.entities.UserEntity;
import net.software.backendcursojava.shared.dto.UserDTO;

@Service
public class UserService implements UserServiceInterface{
  
    @Override
    public UserDTO createrUser(UserDTO userDTO) {
        // TODO logica creacion de usuarios

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        
        UserRepository.save(userEntity);

        UserDTO userToReturn = UserDTO();
        BeanUtils.copyProperties(userEntity, userToReturn);

        userEntity.setEncryptedPassword("tespassword");
        userEntity.setUserID("tesUserID");

        UserEntity storedUserdetail = userRepository.save(userEntity);

        return userToReturn;
    }

}
