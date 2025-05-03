package com.mycompany.dao;

import com.mycompany.conexao.Conectar;
import com.mycompany.model.Eletrodomestico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EletrodomesticoDAO {
    private ArrayList<Eletrodomestico> lista = new ArrayList<>();
    
    public Integer cadastrar(Eletrodomestico eletrodomestico) throws SQLException{
        try (Connection con = Conectar.getConexao()) {
            String sql = "INSERT INTO Eletrodomestico (nome, marca, voltagem, preco) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, eletrodomestico.getNome());
            ps.setString(2, eletrodomestico.getMarca());
            ps.setDouble(3, eletrodomestico.getVoltagem());
            ps.setDouble(4, eletrodomestico.getPreco());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
            throw new SQLException("Erro ao tentar obter o id gerado");
        }
    }
    
    public ArrayList<Eletrodomestico> listar() throws SQLException{
        try(Connection con = Conectar.getConexao()){
            String sql = "SELECT * FROM Eletrodomestico";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Eletrodomestico e = new Eletrodomestico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("marca"),
                    rs.getDouble("voltagem"),
                    rs.getDouble("preco")
                );
                lista.add(e);
            }
        }
        return lista;
    }
    
    public void remover(Eletrodomestico e) throws SQLException{
        try(Connection con = Conectar.getConexao()){
            String sql = "DELETE FROM Eletrodomestico WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
        }
    }
    public void remover(int id) throws SQLException{
        try(Connection con = Conectar.getConexao()){
            String sql = "DELETE FROM Eletrodomestico WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    public void alterar(Eletrodomestico e ) throws SQLException{
        try(Connection con = Conectar.getConexao()){
            String sql = "UPDATE Eletrodomestico SET nome = ?, marca = ?, voltagem = ?, preco = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNome());
            ps.setString(2, e.getMarca());
            ps.setDouble(3, e.getVoltagem());
            ps.setDouble(4, e.getPreco());
            ps.setInt(5, e.getId());
            ps.executeUpdate();
        }
    }
    
    public ArrayList<Eletrodomestico> buscarPorNome(String nome) throws SQLException{
        try(Connection con = Conectar.getConexao()){
            String sql = "SELECT * FROM Eletrodomestico WHERE nome LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Eletrodomestico e = new Eletrodomestico(rs.getInt("id"), rs.getString("nome"),
                rs.getString("marca"), rs.getDouble("voltagem"), rs.getDouble("preco"));
                lista.add(e);
            }
            return lista;
        }
    }
    
    
}
