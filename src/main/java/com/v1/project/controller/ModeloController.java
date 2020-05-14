package com.v1.project.controller;

import com.v1.project.model.Modelo;
import com.v1.project.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    ModeloService modeloService;

    @GetMapping(path = "")
    public ResponseEntity findAll() {
        return new ResponseEntity(modeloService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(modeloService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity save(@RequestBody Modelo modelo) {
        if (modeloService.save(modelo)) {
            return new ResponseEntity("Salvo", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity update(@RequestBody Modelo modelo) {

        if (modeloService.update(modelo)) {
            return new ResponseEntity("Atualizado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        if (modeloService.delete(id)) {
            return new ResponseEntity("Deletado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.NOT_FOUND);
        }
    }


}
