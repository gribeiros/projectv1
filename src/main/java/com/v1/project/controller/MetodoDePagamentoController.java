package com.v1.project.controller;

import com.v1.project.model.MetodoDePagamento;
import com.v1.project.service.MetodoDePagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metodo-de-pagamento")
public class MetodoDePagamentoController {

    @Autowired
    MetodoDePagamentoService metodoDePagamentoService;

    @GetMapping(path = "")
    public ResponseEntity findAll() {
        return new ResponseEntity(metodoDePagamentoService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(metodoDePagamentoService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity save(@RequestBody MetodoDePagamento metodoDePagamento) {
        if (metodoDePagamentoService.save(metodoDePagamento)) {
            return new ResponseEntity("Salvo", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "")
    public ResponseEntity update(@RequestBody MetodoDePagamento metodoDePagamento) {

        if (metodoDePagamentoService.update(metodoDePagamento)) {
            return new ResponseEntity("Atualizado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        if (metodoDePagamentoService.delete(id)) {
            return new ResponseEntity("Deletado", HttpStatus.OK);
        } else {
            return new ResponseEntity("Erro", HttpStatus.NOT_FOUND);
        }
    }

}
