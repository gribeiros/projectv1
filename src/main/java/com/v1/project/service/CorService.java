package com.v1.project.service;

import com.v1.project.dao.CorDAO;
import com.v1.project.model.Cor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorService {
    public List<Cor> findAll() {
        return CorDAO.findAll();
    }

    public boolean save(Cor Cor) {
        return CorDAO.save(Cor);
    }

    public Cor findById(Long id) {
        return CorDAO.findById(id);
    }

    public boolean update(Cor cor) {
        return CorDAO.update(cor);
    }

    public boolean delete(Long id) {
        return CorDAO.delete(id);
    }
}
