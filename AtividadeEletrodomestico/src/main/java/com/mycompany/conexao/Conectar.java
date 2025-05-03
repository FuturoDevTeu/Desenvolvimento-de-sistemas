package com.mycompany.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    private static String url = "jdbc:mysql://localhost:3306/review";
    private static String user = "root";
    private static String password = "";
    
    public static Connection getConexao() throws SQLException{
        try{
            return DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
            throw new SQLException("Não foi possivel conectar se com o banco de dados");
        }
    }
}
