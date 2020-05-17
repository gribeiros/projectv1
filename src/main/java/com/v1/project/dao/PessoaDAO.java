package com.v1.project.dao;

import com.v1.project.factory.ConnectionFactory;
import com.v1.project.model.Pessoa;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PessoaDAO {

    public static boolean save(Pessoa pessoa) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO t1.pessoa (cpf, data_nascimento, endereco, nome, telefone) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pessoa.getCpf());
            stmt.setDate(2, pessoa.getData());
            stmt.setString(3, pessoa.getEndereco());
            stmt.setString(4, pessoa.getNome());
            stmt.setString(5, pessoa.getTelefone());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static List<Pessoa> findAll() {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from pessoa";
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getLong("id"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setData(rs.getDate("data_nascimento"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pessoas.stream()
                .sorted((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .collect(Collectors.toList());
    }

    public static Pessoa findById(Long id) {
        final Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from pessoa where id=?";
        Pessoa pessoa = new Pessoa();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next() && rs != null) {
                pessoa.setId(rs.getLong("id"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setData(rs.getDate("data_nascimento"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setTelefone(rs.getString("telefone"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pessoa;
    }

    public static boolean update(Pessoa pessoa) {
        final Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE pessoa SET cpf=?, data_nascimento=?, endereco=?, nome=?, telefone=? WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pessoa.getCpf());
            stmt.setDate(2, pessoa.getData());
            stmt.setString(3, pessoa.getEndereco());
            stmt.setString(4, pessoa.getNome());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setLong(6, pessoa.getId());
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
        String sql = "delete from pessoa where id = ?";
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
