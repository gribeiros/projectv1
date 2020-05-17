package com.v1.project.dao;

import com.v1.project.factory.ConnectionFactory;
import com.v1.project.model.Usuario;
import com.v1.project.view.SaveAndUpdateUsuario;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsuarioDAO {

    public static boolean save(SaveAndUpdateUsuario saveAndUpdateUsuario) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO usuario (login, senha, id_pessoa) VALUES(?,?,?);";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, saveAndUpdateUsuario.getLogin());
            stmt.setString(2, saveAndUpdateUsuario.getSenha());
            stmt.setLong(3, saveAndUpdateUsuario.getPessoa());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static List<Usuario> findAll() {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from usuario";
        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPessoa(PessoaDAO.findById(rs.getLong("id_pessoa")));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios.stream()
                .sorted((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .collect(Collectors.toList());
    }

    public static Usuario findById(Long id) {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from usuario where id=?";
        Usuario usuario = new Usuario();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next() && rs != null) {
                usuario.setId(rs.getLong("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPessoa(PessoaDAO.findById(rs.getLong("id_pessoa")));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuario;
    }

    public static boolean update(SaveAndUpdateUsuario saveAndUpdateUsuario) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE usuario SET login=?, senha=?, id_pessoa=? WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, saveAndUpdateUsuario.getLogin());
            stmt.setString(2, saveAndUpdateUsuario.getSenha());
            stmt.setLong(3, saveAndUpdateUsuario.getPessoa());
            stmt.setLong(4, saveAndUpdateUsuario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static boolean delete(Long id) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "delete from usuario where id = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
