package net.software.backendcursojava.services;
import net.software.backendcursojava.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.software.backendcursojava.entities.UserEntity;
import net.software.backendcursojava.shared.dto.UserDTO;

@Service
public class UserService<userRepository> implements UserServiceInterface{

    @Autowired
    UserRepository userRepository;
  
    @Override
    public UserDTO createrUser(UserDTO userDTO) {

        
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        
        //userRepository.save(userEntity);

        //UserDTO userToReturn = UserDTO();
        //BeanUtils.copyProperties(userEntity, userToReturn);

        userEntity.setEncryptedPassword("testpassword");
        userEntity.setUserId("testUserId");

        UserEntity storedUserdetail = UserRepository.save(userEntity);
        
        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserdetail, userToReturn);
        
        return userToReturn;
    }

}
