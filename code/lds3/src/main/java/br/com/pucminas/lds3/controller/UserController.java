package br.com.pucminas.lds3.controller;

import br.com.pucminas.lds3.model.User;
import br.com.pucminas.lds3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000") 
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> criarUser(@RequestBody User user) {
        User novoUser = userService.criarUser(user);
        return ResponseEntity.ok(novoUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> listarUsers() {
        List<User> users = userService.listarUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUserPorId(@PathVariable Long id) {
        return userService.buscarUserPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUser(@PathVariable Long id, @RequestBody User user) {
        User userAtualizado = userService.atualizarUser(id, user);
        if (userAtualizado != null) {
            return ResponseEntity.ok(userAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

}