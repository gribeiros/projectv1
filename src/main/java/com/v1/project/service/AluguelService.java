package com.v1.project.service;

import com.v1.project.dao.AluguelDAO;
import com.v1.project.model.Aluguel;
import com.v1.project.view.SaveAndUpdateAluguel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {

    public List<Aluguel> findAll() {
        return AluguelDAO.findAll();
    }

    public boolean save(SaveAndUpdateAluguel saveAndUpdateAluguel) {
        return AluguelDAO.save(saveAndUpdateAluguel);
    }

    public Aluguel findById(Long id) {
        return AluguelDAO.findById(id);
    }

    public boolean update(SaveAndUpdateAluguel saveAndUpdateAluguel) {
        return AluguelDAO.update(saveAndUpdateAluguel);
    }

    public boolean delete(Long id) {
        return AluguelDAO.delete(id);
    }

}
