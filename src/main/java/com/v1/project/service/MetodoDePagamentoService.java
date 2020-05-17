package com.v1.project.service;

import com.v1.project.dao.MetodoDePagamentoDAO;
import com.v1.project.model.MetodoDePagamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoDePagamentoService {

    public List<MetodoDePagamento> findAll() {
        return MetodoDePagamentoDAO.findAll();
    }

    public boolean save(MetodoDePagamento metodoDePagamento) {
        return MetodoDePagamentoDAO.save(metodoDePagamento);
    }

    public MetodoDePagamento findById(Long id) {
        return MetodoDePagamentoDAO.findById(id);
    }

    public boolean update(MetodoDePagamento metodoDePagamento) {
        return MetodoDePagamentoDAO.update(metodoDePagamento);
    }

    public boolean delete(Long id) {
        return MetodoDePagamentoDAO.delete(id);
    }

}
