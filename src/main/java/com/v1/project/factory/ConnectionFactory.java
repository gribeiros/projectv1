package com.v1.project.factory;

import java.sql.*;


public class ConnectionFactory {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://us-cdbr-iron-east-01.cleardb.net/heroku_e3ebfe37e75d7b8?serverTimezone=UTC&useLegacyDatetimeCode=false";
    private static String USER = "b46a01d2f2f4c8";
    private static String PASS = "7b50bc98";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão:", ex);
        }
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro pra fechar:", ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro pra fechar:", ex);
            }
        }
        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro pra fechar:", ex);
            }
        }
        closeConnection(con, stmt);
    }

}
