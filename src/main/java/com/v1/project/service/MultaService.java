package com.v1.project.service;

import com.v1.project.dao.MultaDAO;
import com.v1.project.model.Multa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultaService {

    public List<Multa> findAll() {
        return MultaDAO.findAll();
    }

    public boolean save(Multa multa) {
        return MultaDAO.save(multa);
    }

    public Multa findById(Long id) {
        return MultaDAO.findById(id);
    }

    public boolean update(Multa multa) {
        return MultaDAO.update(multa);
    }

    public boolean delete(Long id) {
        return MultaDAO.delete(id);
    }

}
