package com.mycompany.service;

import com.mycompany.dao.EletrodomesticoDAO;
import com.mycompany.model.Eletrodomestico;
import java.sql.SQLException;
import java.util.ArrayList;

public class EletrodomesticoService {
    private EletrodomesticoDAO dao = new EletrodomesticoDAO();
    
    public void validarCampos(String nome, String marca, Double voltagem, Double preco)throws IllegalArgumentException{   
        if(nome.trim() == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Campo nome vazio");
        if(marca.trim() == null || marca.trim().isEmpty()) throw new IllegalArgumentException("Campo marca vazio");
        if(voltagem == null) throw new IllegalArgumentException("Campo voltagem vazio");
        if(preco == null) throw new IllegalArgumentException("Campo preco esta vazio");
        
        
    }
    public void validarCampos(Integer id, String nome, String marca, double voltagem, double preco)throws IllegalArgumentException{
        if(id == null) throw new IllegalArgumentException("Campo id vazio");
        if(nome.trim() == null || nome.trim().equals("")) throw new IllegalArgumentException("Campo nome vazio");
        if(marca.trim() == null || marca.trim().equals("")) throw new IllegalArgumentException("Campo marca vazio");
        if(voltagem < 0) throw new IllegalArgumentException("Insira um numero maior que 0 no campo voltagem");
        if(preco < 0) throw new IllegalArgumentException("Insira um numero maior que 0 no campo preco");
    }
    public double transformarEmDouble(String campo, String variavel) throws NumberFormatException{
        try{
            double variavelDouble = Double.parseDouble(variavel);
            return variavelDouble;
        }catch(NumberFormatException e){
            throw new NumberFormatException("Insira um numero no campo "+ campo);
        }
    }
    public void validarLista(ArrayList<Eletrodomestico> lista) throws NullPointerException{
        if(lista.isEmpty()) throw new NullPointerException("Não possui nenhuma informação");
    }
    public void validarIndex(int id) throws SQLException, NullPointerException, IndexOutOfBoundsException{
        ArrayList<Eletrodomestico> lista = listar();
        if(id < 0 || id  > lista.size()) throw new IndexOutOfBoundsException("Eletrodomestico não encontrado");
    }
    public Integer cadastrar(String nome, String marca, String voltagem, String preco) throws SQLException, 
            IllegalArgumentException, NumberFormatException{
        double voltagemDouble = transformarEmDouble("voltagem", voltagem);
        double precoDouble = transformarEmDouble("preco", preco);
        validarCampos(nome, marca, voltagemDouble, precoDouble);
        return dao.cadastrar(new Eletrodomestico(nome, marca, voltagemDouble, precoDouble));
    }
    
    public ArrayList<Eletrodomestico> listar() throws SQLException, NullPointerException{
        ArrayList<Eletrodomestico> lista = dao.listar();
        validarLista(lista);
        return lista;
    }
    
    public void remover(int id) throws SQLException, NullPointerException, IndexOutOfBoundsException{
        dao.remover(id);
    }
    
    public void alterar(int id, String nome, String marca, String voltagem, String preco) throws IllegalArgumentException, SQLException{
        double voltagemDouble = transformarEmDouble("voltagem", voltagem);
        double precoDouble = transformarEmDouble("preco", preco);
        validarCampos(id, nome, marca, voltagemDouble, precoDouble);
        
        dao.alterar(new Eletrodomestico(id, nome, marca, voltagemDouble, precoDouble));
    }
    public ArrayList<Eletrodomestico> buscarPorNome(String nome) throws SQLException{
        return dao.buscarPorNome(nome);
    }
}
