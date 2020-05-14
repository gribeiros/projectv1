package com.v1.project.controller;

import com.v1.project.model.Marca;
import com.v1.project.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @GetMapping(path = "")
    public ResponseEntity findAll() {
        return new ResponseEntity(marcaService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(marcaService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity save(@RequestBody Marca marca) {
        if (marcaService.save(marca)) {
            return new ResponseEntity("Salvo", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity update(@RequestBody Marca marca) {

        if (marcaService.update(marca)) {
            return new ResponseEntity("Atualizado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        if (marcaService.delete(id)) {
            return new ResponseEntity("Deletado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.NOT_FOUND);
        }
    }

}
