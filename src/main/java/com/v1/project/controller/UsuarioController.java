package com.v1.project.controller;

import com.v1.project.service.UsuarioService;
import com.v1.project.view.SaveAndUpdateUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path = "")
    public ResponseEntity findAll() {
        return new ResponseEntity(usuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(usuarioService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity save(@RequestBody SaveAndUpdateUsuario saveAndUpdateUsuario) {
        if (usuarioService.save(saveAndUpdateUsuario)) {
            return new ResponseEntity("Salvo", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "")
    public ResponseEntity update(@RequestBody SaveAndUpdateUsuario saveAndUpdateUsuario) {

        if (usuarioService.update(saveAndUpdateUsuario)) {
            return new ResponseEntity("Atualizado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        if (usuarioService.delete(id)) {
            return new ResponseEntity("Deletado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.NOT_FOUND);
        }
    }

}
