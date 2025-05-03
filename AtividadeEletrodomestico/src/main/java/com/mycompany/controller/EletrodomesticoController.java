package com.mycompany.controller;

import com.mycompany.service.EletrodomesticoService;
import com.mycompany.model.Eletrodomestico;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EletrodomesticoController {
    private EletrodomesticoService service = new EletrodomesticoService();

    public Integer cadastrar(String nome, String marca, String voltagem, String preco){
        try{
            return service.cadastrar(nome, marca, voltagem, preco);
            
        }catch(SQLException | IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                                         JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public ArrayList<Eletrodomestico> listar(){
        try{
            return service.listar();
        }catch(SQLException | IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                                         JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public boolean remover(int id){
        try{
            service.remover(id);
            return true;
        }catch(SQLException | NullPointerException | IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                                         JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean alterar(int id, String nome, String marca, String voltagem, String preco){
        try{
            service.alterar(id, nome, marca, voltagem, preco);
            return true;
        }catch(SQLException | IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                                         JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
    }
    public ArrayList<Eletrodomestico> buscarPorNome(String nome){
        try{
            return service.buscarPorNome(nome);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                                         JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
    }
}
    


