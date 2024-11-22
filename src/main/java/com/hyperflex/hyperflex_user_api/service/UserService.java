package com.hyperflex.hyperflex_user_api.service;

import com.hyperflex.hyperflex_user_api.persistence.entity.UserEntity;
import com.hyperflex.hyperflex_user_api.persistence.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //GET
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUser(Long idUser){
        return userRepository.findById(idUser);
    }

    public Optional<UserEntity> getByUserName(String userName){
        return userRepository.findByUserNameIgnoreCase(userName);
    }

    //POST && PUT
    public  List<UserEntity> saveAll(List<UserEntity> users){
        for(UserEntity user: users){
            if(user.getIdUser() == null){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
        }
        return userRepository.saveAll(users);
    }

    public UserEntity save(UserEntity user){

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("El campo 'password' no puede ser nulo o vacío");
        }

        //Pasos para guardar o actualizar password encriptado
        if(user.getIdUser() == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else{
            UserEntity existingUser = userRepository.findById(user.getIdUser())
                    .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado") );

            if(!user.getPassword().equals(existingUser.getPassword())){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
        }

        return userRepository.save(user);
    }

    //DELETE
    public boolean deleteUser(Long idUser){
        if(userRepository.existsById(idUser)){
            userRepository.deleteById(idUser);
            return true;
        }
        return false;
    }


    public boolean exist(Long idUser){
        return userRepository.existsById(idUser);
    }
}
