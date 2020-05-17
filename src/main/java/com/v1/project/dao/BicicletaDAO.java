package com.v1.project.dao;

import com.v1.project.factory.ConnectionFactory;
import com.v1.project.model.Bicicleta;
import com.v1.project.view.SaveAndUpdateBicicleta;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BicicletaDAO {

    public static boolean save(SaveAndUpdateBicicleta saveAndUpdateBicicleta) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO bicicleta (id_cor, id_marca, id_modelo) VALUES(?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, saveAndUpdateBicicleta.getCor());
            stmt.setLong(2, saveAndUpdateBicicleta.getMarca());
            stmt.setLong(3, saveAndUpdateBicicleta.getModelo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static List<Bicicleta> findAll() {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from bicicleta";
        List<Bicicleta> bicicletas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Bicicleta bicicleta = new Bicicleta();
                bicicleta.setId(rs.getLong("id"));
                bicicleta.setCor(CorDAO.findById(rs.getLong("id_cor")));
                bicicleta.setMarca(MarcaDAO.findById(rs.getLong("id_marca")));
                bicicleta.setModelo(ModeloDAO.findById(rs.getLong("id_modelo")));
                bicicletas.add(bicicleta);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return bicicletas.stream()
                .sorted((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .collect(Collectors.toList());
    }

    public static Bicicleta findById(Long id) {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from bicicleta where id=?";
        Bicicleta bicicleta = new Bicicleta();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next() && rs != null) {
                bicicleta.setId(rs.getLong("id"));
                bicicleta.setCor(CorDAO.findById(rs.getLong("id_cor")));
                bicicleta.setMarca(MarcaDAO.findById(rs.getLong("id_marca")));
                bicicleta.setModelo(ModeloDAO.findById(rs.getLong("id_modelo")));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return bicicleta;
    }

    public static boolean update(SaveAndUpdateBicicleta saveAndUpdateBicicleta) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE bicicleta SET id_cor=?, id_marca=?, id_modelo=? WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, saveAndUpdateBicicleta.getCor());
            stmt.setLong(2, saveAndUpdateBicicleta.getMarca());
            stmt.setLong(3, saveAndUpdateBicicleta.getModelo());
            stmt.setLong(4, saveAndUpdateBicicleta.getId());
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
        String sql = "delete from bicicleta where id = ?";
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
