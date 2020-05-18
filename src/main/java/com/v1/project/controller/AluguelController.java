package com.v1.project.controller;

import com.v1.project.service.AluguelService;
import com.v1.project.view.SaveAndUpdateAluguel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    AluguelService aluguelService;

    @GetMapping(path = "")
    public ResponseEntity findAll() {
        return new ResponseEntity(aluguelService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(aluguelService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity save(@RequestBody SaveAndUpdateAluguel saveAndUpdateAluguel) {
        if (aluguelService.save(saveAndUpdateAluguel)) {
            return new ResponseEntity("Salvo", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "")
    public ResponseEntity update(@RequestBody SaveAndUpdateAluguel saveAndUpdateAluguel) {

        if (aluguelService.update(saveAndUpdateAluguel)) {
            return new ResponseEntity("Atualizado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        if (aluguelService.delete(id)) {
            return new ResponseEntity("Deletado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.NOT_FOUND);
        }
    }

}
