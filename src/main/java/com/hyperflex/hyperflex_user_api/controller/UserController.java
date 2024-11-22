package com.hyperflex.hyperflex_user_api.controller;

import com.hyperflex.hyperflex_user_api.persistence.entity.UserEntity;
import com.hyperflex.hyperflex_user_api.service.UserService;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET
    @GetMapping()
    public ResponseEntity<List<UserEntity>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long idUser) {
        Optional<UserEntity> user = userService.getUser(idUser);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity<UserEntity> getByUserName(@PathVariable String userName){
        Optional<UserEntity> user = userService.getByUserName(userName);

        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }

    //POST

    @PostMapping("/insert")
    public ResponseEntity<List<UserEntity>> createUsers(@RequestBody List<UserEntity> users){
        return ResponseEntity.ok(userService.saveAll(users));
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        if (user.getIdUser() == null || !userService.exist(user.getIdUser())) {
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok(userService.save(user));
        }
        return ResponseEntity.badRequest().build();
    }


    // PUT
    @PutMapping
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
        if (user.getIdUser() != null && userService.exist(user.getIdUser())) {
            return ResponseEntity.ok(userService.save(user));
        }
        return ResponseEntity.badRequest().build();
    }

    //DELETE
    @DeleteMapping("/{idUser}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long idUser){
        if(userService.exist(idUser)){
            userService.deleteUser(idUser);
            return ResponseEntity.ok(true);
        }

        return ResponseEntity.badRequest().build();
    }

}