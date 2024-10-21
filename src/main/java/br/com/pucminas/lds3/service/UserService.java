package br.com.pucminas.lds3.service;

import br.com.pucminas.lds3.model.User;
import br.com.pucminas.lds3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User criarUser(User user) {
        return userRepository.save(user);
    }

    public List<User> listarUsers() {
        return userRepository.findAll();
    }

    public Optional<User> buscarUserPorId(Long id) {
        return userRepository.findById(id);
    }

    public User atualizarUser(Long id, User userAtualizado) {
        Optional<User> userExistente = userRepository.findById(id);
        if (userExistente.isPresent()) {
            User user = userExistente.get();
            user.setNome(userAtualizado.getNome());
            user.setEmail(userAtualizado.getEmail());
            // Atualize outros campos conforme necessário
            return userRepository.save(user);
        } else {
            return null;
        }
    }
}
