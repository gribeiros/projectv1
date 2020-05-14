package com.v1.project.dao;

import com.v1.project.factory.ConnectionFactory;
import com.v1.project.model.Marca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarcaDAO {

    public static boolean save(Marca marca) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "insert into marca(name) values(?);";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, marca.getName());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static List<Marca> findAll() {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from marca";
        List<Marca> marcas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId(rs.getLong("id"));
                marca.setName(rs.getString("nome"));
                marcas.add(marca);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return marcas.stream()
                .sorted((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .collect(Collectors.toList());
    }

    public static Marca findById(Long id) {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from marca where id=?;";
        Marca marca = new Marca();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next() && rs != null) {
                marca.setId(rs.getLong("id"));
                marca.setName(rs.getString("nome"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return marca;
    }

    public static boolean update(Marca marca) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE marca SET nome=? WHERE id=?;";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, marca.getName());
            stmt.setLong(2, marca.getId());
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
        String sql = "delete from marca where id = ?;";
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
