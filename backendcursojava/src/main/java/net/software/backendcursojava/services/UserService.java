package net.software.backendcursojava.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import net.software.backendcursojava.entities.UserEntity;
import net.software.backendcursojava.shared.dto.UserDTO;

@Service
public class UserService implements UserServiceInterface{
  
    @Override
    public UserDTO createrUser(UserDTO userDTO) {

        //TODO logica de la creacion del usuario
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        
        //userRepository.save(userEntity);

        //UserDTO userToReturn = UserDTO();
        //BeanUtils.copyProperties(userEntity, userToReturn);

        userEntity.setEncryptedPassword("testpassword");
        userEntity.setUserId("testUserId");

        UserEntity storedUserdetail = userRepository.save(userEntity);
        
        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserdetail, userToReturn);
        
        return userToReturn;
    }

}
