package com.v1.project.service;

import com.v1.project.dao.UsuarioDAO;
import com.v1.project.model.Usuario;
import com.v1.project.view.SaveAndUpdateUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    public List<Usuario> findAll() {
        return UsuarioDAO.findAll();
    }

    public boolean save(SaveAndUpdateUsuario saveAndUpdateUsuario) {
        return UsuarioDAO.save(saveAndUpdateUsuario);
    }

    public Usuario findById(Long id) {
        return UsuarioDAO.findById(id);
    }

    public boolean update(SaveAndUpdateUsuario saveAndUpdateUsuario) {
        return UsuarioDAO.update(saveAndUpdateUsuario);
    }

    public boolean delete(Long id) {
        return UsuarioDAO.delete(id);
    }

}
