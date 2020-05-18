package com.v1.project.dao;

import com.v1.project.factory.ConnectionFactory;
import com.v1.project.model.Aluguel;
import com.v1.project.view.SaveAndUpdateAluguel;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AluguelDAO {

    public static boolean save(SaveAndUpdateAluguel saveAndUpdateAluguel) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO aluguel (tempo, id_bicicleta, id_metodo_de_pagamento, id_multa, id_status, id_usuario) VALUES(?,?,?,?,?,?);";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, saveAndUpdateAluguel.getData());
            stmt.setLong(2, saveAndUpdateAluguel.getBicicleta());
            stmt.setLong(3, saveAndUpdateAluguel.getMetodoDePagamento());
            if (saveAndUpdateAluguel.getMulta() == null)
                stmt.setNull(4, Types.NULL);
            else
                stmt.setLong(4, saveAndUpdateAluguel.getMulta());
            stmt.setLong(5, saveAndUpdateAluguel.getStatus());
            stmt.setLong(6, saveAndUpdateAluguel.getUsuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static List<Aluguel> findAll() {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from aluguel";
        List<Aluguel> aluguels = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluguel aluguel = new Aluguel();
                aluguel.setId(rs.getLong("id"));
                aluguel.setData(rs.getDate("tempo"));
                aluguel.setBicicleta(BicicletaDAO.findById(rs.getLong("id_bicicleta")));
                aluguel.setMetodoDePagamento(MetodoDePagamentoDAO.findById(rs.getLong("id_metodo_de_pagamento")));
                aluguel.setMulta(MultaDAO.findById(rs.getLong("id_multa")));
                aluguel.setStatus(StatusDAO.findById(rs.getLong("id_status")));
                aluguel.setUsuario(UsuarioDAO.findById(rs.getLong("id_usuario")));
                aluguels.add(aluguel);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return aluguels.stream()
                .sorted((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .collect(Collectors.toList());
    }

    public static Aluguel findById(Long id) {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from aluguel where id=?";
        Aluguel aluguel = new Aluguel();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next() && rs != null) {

                aluguel.setId(rs.getLong("id"));
                aluguel.setData(rs.getDate("tempo"));
                aluguel.setBicicleta(BicicletaDAO.findById(rs.getLong("id_bicicleta")));
                aluguel.setMetodoDePagamento(MetodoDePagamentoDAO.findById(rs.getLong("id_metodo_de_pagamento")));
                aluguel.setMulta(MultaDAO.findById(rs.getLong("id_multa")));
                aluguel.setStatus(StatusDAO.findById(rs.getLong("id_status")));
                aluguel.setUsuario(UsuarioDAO.findById(rs.getLong("id_usuario")));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return aluguel;
    }

    public static boolean update(SaveAndUpdateAluguel saveAndUpdateAluguel) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE aluguel SET tempo=?, id_bicicleta=?, id_metodo_de_pagamento=?, id_multa=?, id_status=?, id_usuario=? WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, saveAndUpdateAluguel.getData());
            stmt.setLong(2, saveAndUpdateAluguel.getBicicleta());
            stmt.setLong(3, saveAndUpdateAluguel.getMetodoDePagamento());
            if (saveAndUpdateAluguel.getMulta() == null)
                stmt.setNull(4, Types.NULL);
            else
                stmt.setLong(4, saveAndUpdateAluguel.getMulta());
            stmt.setLong(5, saveAndUpdateAluguel.getStatus());
            stmt.setLong(6, saveAndUpdateAluguel.getUsuario());
            stmt.setLong(7, saveAndUpdateAluguel.getId());
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
        String sql = "delete from aluguel where id = ?";
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
