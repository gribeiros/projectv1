package com.v1.project.controller;

import com.v1.project.model.Marca;
import com.v1.project.service.BicicletaService;
import com.v1.project.service.MarcaService;
import com.v1.project.view.SaveAndUpdateBicicleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bicicleta")
public class BicicletaController {

    @Autowired
    BicicletaService bicicletaService;

    @GetMapping(path = "")
    public ResponseEntity findAll() {
        return new ResponseEntity(bicicletaService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(bicicletaService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity save(@RequestBody SaveAndUpdateBicicleta saveAndUpdateBicicleta) {
        if (bicicletaService.save(saveAndUpdateBicicleta)) {
            return new ResponseEntity("Salvo", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "")
    public ResponseEntity update(@RequestBody SaveAndUpdateBicicleta saveAndUpdateBicicleta) {

        if (bicicletaService.update(saveAndUpdateBicicleta)) {
            return new ResponseEntity("Atualizado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        if (bicicletaService.delete(id)) {
            return new ResponseEntity("Deletado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.NOT_FOUND);
        }
    }

}
