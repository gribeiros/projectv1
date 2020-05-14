package com.v1.project.service;

import com.v1.project.dao.MarcaDAO;
import com.v1.project.model.Marca;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    public List<Marca> findAll() {
        return MarcaDAO.findAll();
    }

    public boolean save(Marca marca) {
        return MarcaDAO.save(marca);
    }

    public Marca findById(Long id) {
        return MarcaDAO.findById(id);
    }

    public boolean update(Marca marca) {
        return MarcaDAO.update(marca);
    }

    public boolean delete(Long id) {
        return MarcaDAO.delete(id);
    }

}
