package com.administrative.painel.controller;

import com.administrative.painel.dto.UserDTO;
import com.administrative.painel.model.User;
import com.administrative.painel.repository.UserRepository;
import com.administrative.painel.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/usuarios")
    public List<UserDTO> findAllUsers() {
        return userService.getUsers();
    }

    @Transactional
    @PostMapping("/cadastros/usuarios/novo")
    public void registerUser(@RequestBody UserDTO dados) {
        userRepository.save(new User(dados));
    }

    //@Transactional
    //@DeleteMapping("usuarios/{id}")
    //public void deleteUser(@PathVariable("id") Long id) {
    //    userRepository.deleteById(id);
    //}
}
