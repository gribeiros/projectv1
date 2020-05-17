package com.v1.project.service;

import com.v1.project.dao.PessoaDAO;
import com.v1.project.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    public List<Pessoa> findAll() {
        return PessoaDAO.findAll();
    }

    public boolean save(Pessoa pessoa) {
        return PessoaDAO.save(pessoa);
    }

    public Pessoa findById(Long id) {
        return PessoaDAO.findById(id);
    }

    public boolean update(Pessoa pessoa) {
        return PessoaDAO.update(pessoa);
    }

    public boolean delete(Long id) {
        return PessoaDAO.delete(id);
    }

}
