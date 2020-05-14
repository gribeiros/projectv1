package com.v1.project.service;

import com.v1.project.dao.ModeloDAO;
import com.v1.project.model.Modelo;

import java.util.List;

public class ModeloService {

    public List<Modelo> findAll() {
        return ModeloDAO.findAll();
    }

    public boolean save(Modelo modelo) {
        return ModeloDAO.save(modelo);
    }

    public Modelo findById(Long id) {
        return ModeloDAO.findById(id);
    }

    public boolean update(Modelo modelo) {
        return ModeloDAO.update(modelo);
    }

    public boolean delete(Long id) {
        return ModeloDAO.delete(id);
    }

}
