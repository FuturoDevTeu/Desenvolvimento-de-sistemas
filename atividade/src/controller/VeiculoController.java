package controller;

import exception.BancoDadosVazioException;
import exception.CampoVazioException;
import exception.IndexIncorretoException;
import exception.NumeroIncorretoException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Carro;
import model.Moto;
import model.Veiculo;
import service.VeiculoService;

public class VeiculoController {
    private VeiculoService service = new VeiculoService();
    
    public boolean cadastrarCarro(String marca, String modelo, String numeroPortas){
        try{
            service.cadastrarCarro(marca, modelo, numeroPortas);
            return true;
        }catch(CampoVazioException | NumeroIncorretoException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean cadastrarMoto(String marca, String modelo, String cilindrada){
        try{
            service.cadastrarMoto(marca, modelo, cilindrada);
            return true;
        }catch(CampoVazioException | NumeroIncorretoException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public ArrayList<Veiculo> listarTodos(){
        try{
            return service.listarTodos();
        }catch(BancoDadosVazioException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public ArrayList<Carro> listarCarros(){
        try{
            return service.listarCarros();
        }catch(BancoDadosVazioException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public ArrayList<Moto> listarMotos(){
        try{
            return service.listarMotos();
        }catch(BancoDadosVazioException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public boolean remover(int index){
        try{
            service.remover(index);
            return true;
        }catch(IndexIncorretoException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean removerMoto(int index){
        try{
            service.removerMoto(index);
            return true;
        }catch(IndexIncorretoException | BancoDadosVazioException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean removerCarro(int index){
        try{
            service.removerCarro(index);
            return true;
        }catch(IndexIncorretoException | BancoDadosVazioException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean alterar(int index, String marca, String modelo, String tipo){
        try{
            Veiculo atual = service.buscarIndex(index);
            if(tipo.equals("Carro") && atual instanceof Carro carroAtual){    
                service.alterarCarro(index, marca, modelo, carroAtual.getNumeroPortas());
                return true;
            }else if(tipo.equals("Moto") && atual instanceof Moto motoAtual){
                service.alterarMoto(index, marca, modelo, motoAtual.getCilindrada());
                return true;
            }
        }catch(CampoVazioException | NumeroIncorretoException | IndexIncorretoException | BancoDadosVazioException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    public boolean alterarMoto(int index, String marca, String modelo, String cilindrada){
        try{
            service.alterarMoto(index, marca, modelo, cilindrada);
            return true;
        }catch(CampoVazioException | NumeroIncorretoException | IndexIncorretoException | BancoDadosVazioException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean alterarCarro(int index, String marca, String modelo, String numeroPortas){
        try{
            service.alterarCarro(index, marca, modelo, numeroPortas);
            return true;
        }catch(CampoVazioException | NumeroIncorretoException | IndexIncorretoException | BancoDadosVazioException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
}
