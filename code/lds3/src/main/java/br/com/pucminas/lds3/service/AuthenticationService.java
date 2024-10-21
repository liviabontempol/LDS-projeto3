package br.com.pucminas.lds3.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.pucminas.lds3.model.LoginRequest;
import br.com.pucminas.lds3.model.User;
import br.com.pucminas.lds3.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean authenticate(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            // Autenticação bem-sucedida
            return true;
        }
        
        return false;
    }
}
