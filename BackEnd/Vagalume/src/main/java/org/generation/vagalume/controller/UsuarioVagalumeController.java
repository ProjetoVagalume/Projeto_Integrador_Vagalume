package org.generation.vagalume.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.generation.vagalume.model.UsuarioVagalumeLogin;
import org.generation.vagalume.model.UsuarioVagalume;
import org.generation.vagalume.repository.UsuarioVagalumeRepository;
import org.generation.vagalume.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioVagalumeController {
	@Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioVagalumeRepository usuarioRepository;
    
    @GetMapping("/all")
    public ResponseEntity <List<UsuarioVagalume>> getAll(){     
        return ResponseEntity.ok(usuarioRepository.findAll());  
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioVagalume> getById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/logar")
    public ResponseEntity<UsuarioVagalumeLogin> login(@RequestBody Optional<UsuarioVagalumeLogin> usuarioLogin) {
        return usuarioService.autenticarUsuario(usuarioLogin)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioVagalume> postUsuario(@Valid @RequestBody UsuarioVagalume usuario) {

        return usuarioService.cadastrarUsuario(usuario)
            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
            .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }

    @PutMapping("/atualizar")
    public ResponseEntity<UsuarioVagalume> putUsuario(@Valid @RequestBody UsuarioVagalume usuario) {
        return usuarioService.atualizarUsuario(usuario)
            .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
