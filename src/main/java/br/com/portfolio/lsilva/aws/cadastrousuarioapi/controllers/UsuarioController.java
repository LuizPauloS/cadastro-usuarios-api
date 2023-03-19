package br.com.portfolio.lsilva.aws.cadastrousuarioapi.controllers;

import br.com.portfolio.lsilva.aws.cadastrousuarioapi.domains.dtos.UsuarioDTO;
import br.com.portfolio.lsilva.aws.cadastrousuarioapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(service.save(usuarioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(service.update(id, usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
