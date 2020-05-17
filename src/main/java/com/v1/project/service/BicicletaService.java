package com.v1.project.service;

import com.v1.project.dao.BicicletaDAO;
import com.v1.project.model.Bicicleta;
import com.v1.project.view.SaveAndUpdateBicicleta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicicletaService {

    public List<Bicicleta> findAll() {
        return BicicletaDAO.findAll();
    }

    public boolean save(SaveAndUpdateBicicleta saveAndUpdateBicicleta) {
        return BicicletaDAO.save(saveAndUpdateBicicleta);
    }

    public Bicicleta findById(Long id) {
        return BicicletaDAO.findById(id);
    }

    public boolean update(SaveAndUpdateBicicleta saveAndUpdateBicicleta) {
        return BicicletaDAO.update(saveAndUpdateBicicleta);
    }

    public boolean delete(Long id) {
        return BicicletaDAO.delete(id);
    }

}
