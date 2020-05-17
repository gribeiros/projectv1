package com.v1.project.dao;

import com.v1.project.factory.ConnectionFactory;
import com.v1.project.model.MetodoDePagamento;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MetodoDePagamentoDAO {

    public static boolean save(MetodoDePagamento metodoDePagamento) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO metodo_de_pagamento (pagamento) VALUES(?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, metodoDePagamento.getMetodoPagamento());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static List<MetodoDePagamento> findAll() {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from metodo_de_pagamento";
        List<MetodoDePagamento> metodoDePagamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                MetodoDePagamento metodoDePagamento = new MetodoDePagamento();
                metodoDePagamento.setId(rs.getLong("id"));
                metodoDePagamento.setMetodoPagamento(rs.getString("pagamento"));
                metodoDePagamentos.add(metodoDePagamento);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return metodoDePagamentos.stream()
                .sorted((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .collect(Collectors.toList());
    }

    public static MetodoDePagamento findById(Long id) {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from metodo_de_pagamento where id=?";
        MetodoDePagamento metodoDePagamento = new MetodoDePagamento();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next() && rs != null) {
                metodoDePagamento.setId(rs.getLong("id"));
                metodoDePagamento.setMetodoPagamento(rs.getString("pagamento"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return metodoDePagamento;
    }

    public static boolean update(MetodoDePagamento metodoDePagamento) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE metodo_de_pagamento SET pagamento=? WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, metodoDePagamento.getMetodoPagamento());
            stmt.setLong(2, metodoDePagamento.getId());
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
        String sql = "delete from metodo_de_pagamento where id = ?";
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
