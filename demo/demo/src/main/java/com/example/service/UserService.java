package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserModel;
import com.example.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(String username, String password) {

        if (userRepository.findByUser(username).isPresent()) {
            return "Usuário já existe!";
        }

        UserModel newUser = new UserModel(username, password);
        userRepository.save(newUser);

        return "Usuário cadastrado com sucesso!";
    }

    public String login(String username, String password) {

        Optional<UserModel> userOptional = userRepository.findByUser(username);

        if (userOptional.isEmpty()) {
            return "Usuário não encontrado!";
        }

        if (!userOptional.get().getPassword().equals(password)) {
            return "Senha incorreta!";
        }

        return "Login realizado com sucesso!";
    }
}