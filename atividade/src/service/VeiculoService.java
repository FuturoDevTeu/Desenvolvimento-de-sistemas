package service;

import dao.VeiculoDAO;
import exception.BancoDadosVazioException;
import exception.CampoVazioException;
import exception.IndexIncorretoException;
import exception.NumeroIncorretoException;
import java.util.ArrayList;
import model.Carro;
import model.Moto;
import model.Veiculo;

public class VeiculoService {
     private VeiculoDAO dao = new VeiculoDAO();
    
    private void validarCamposCarro(String marca, String modelo, String numeroPortas) throws CampoVazioException{
        if(marca.trim().isEmpty()) throw new CampoVazioException("Campo marca está vazio");
        if(modelo.trim().isEmpty()) throw new CampoVazioException("Campo modelo está vazio");
        if(numeroPortas.trim().isEmpty()) throw new CampoVazioException("Campo numero portas está vazio");
    }
    private void validarCamposMoto(String marca, String modelo, String cilindrada) throws CampoVazioException{
        if(marca.trim().isEmpty()) throw new CampoVazioException("Campo marca está vazio");
        if(modelo.trim().isEmpty()) throw new CampoVazioException("Campo modelo está vazio");
        if(cilindrada.trim().isEmpty()) throw new CampoVazioException("Campo cilindrada portas está vazio");
    }
    public void validarNumeroMoto(String cilindrada) throws NumeroIncorretoException {
        try {
            int cilindradaInt = Integer.parseInt(cilindrada);
            if (cilindradaInt < 0) {
                throw new NumeroIncorretoException("A cilindrada não pode ser negativa.");
            }
        } catch (NumberFormatException e) {
            throw new NumeroIncorretoException("Insira um número inteiro válido para a quantidade de cilindrada.");
        }
    }
    public void validarNumeroCarro(String numeroPortas) throws NumeroIncorretoException {
        try {
            int cilindradaInt = Integer.parseInt(numeroPortas);
            if (cilindradaInt < 0) {
                throw new NumeroIncorretoException("O numero de portas não pode ser negativa.");
            }
        } catch (NumberFormatException e) {
            throw new NumeroIncorretoException("Insira um número inteiro válido para a quantidade de portas.");
        }
    }
    public void validarIndex(int index) throws IndexIncorretoException{
        if(index < 0 || index > dao.listarTodos().size()) throw new IndexIncorretoException("Não foi possivel encontrar esse veiculo");
    }
    public void validarIndexMoto(int index) throws IndexIncorretoException{
        if(index < 0 || index > dao.listarMotos().size()) throw new IndexIncorretoException("Não foi possivel encontrar essa moto");
    }
    public void validarIndexCarro(int index) throws IndexIncorretoException{
        if(index < 0 || index > dao.listarCarros().size()) throw new IndexIncorretoException("Não foi possivel encontrar essa carro");
    }
    
    public void cadastrarCarro(String marca, String modelo, String numeroPortas) throws CampoVazioException, NumeroIncorretoException{
        validarCamposCarro(marca, modelo, numeroPortas);
        validarNumeroCarro(numeroPortas);
        dao.adicionar(new Carro(marca, modelo, numeroPortas));
    }
    
    public void cadastrarMoto(String marca, String modelo, String cilindrada) throws CampoVazioException, NumeroIncorretoException{
        validarCamposMoto(marca, modelo, cilindrada);
        validarNumeroMoto(cilindrada);
        dao.adicionar(new Moto(marca, modelo, cilindrada));
    }
    public void alterarCarro(int index, String marca, String modelo, String numeroPortas) throws CampoVazioException, 
            NumeroIncorretoException, IndexIncorretoException, BancoDadosVazioException{
        validarCamposCarro(marca, modelo, numeroPortas);
        validarNumeroCarro(numeroPortas);
        validarIndexCarro(index);
        Carro carroSelecionado = listarCarros().get(index);
        int indexCarro = listarTodos().indexOf(carroSelecionado);
        dao.alterar(indexCarro, new Carro(marca, modelo, numeroPortas));
    }
    public void alterarMoto(int index, String marca, String modelo, String cilindrada) throws CampoVazioException,
            NumeroIncorretoException, IndexIncorretoException, BancoDadosVazioException{
        validarCamposMoto(marca, modelo, cilindrada);
        validarNumeroMoto(cilindrada);
        validarIndexMoto(index);
        Moto motoSelecionada = listarMotos().get(index);  
        int indexMoto = listarTodos().indexOf(motoSelecionada);
        dao.alterar(indexMoto, new Moto(marca, modelo, cilindrada));
    }
    public void remover(int index) throws IndexIncorretoException{
        validarIndex(index);
        dao.remover(index);
    }
    public void removerMoto(int index) throws IndexIncorretoException, BancoDadosVazioException{
        validarIndexMoto(index);
        Moto MotoSelecionada = listarMotos().get(index);
        int indexMoto = listarTodos().indexOf(MotoSelecionada);
        dao.remover(indexMoto);
    }
    public void removerCarro(int index) throws IndexIncorretoException, BancoDadosVazioException{
        validarIndexCarro(index);
        Carro carroSelecionada = listarCarros().get(index);
        int indexCarro = listarTodos().indexOf(carroSelecionada);
        dao.remover(indexCarro);
    }
    
    public ArrayList<Veiculo> listarTodos() throws BancoDadosVazioException{
        if(dao.listarTodos() == null || dao.listarTodos().isEmpty()) throw new BancoDadosVazioException("Não possui veiculos no sistema");
        return dao.listarTodos();
    }
    public ArrayList<Carro> listarCarros() throws BancoDadosVazioException{
        if(dao.listarCarros()== null || dao.listarCarros().isEmpty()) throw new BancoDadosVazioException("Não possui carros no sistema");
        return dao.listarCarros();
    }
    public ArrayList<Moto> listarMotos() throws BancoDadosVazioException{
        if(dao.listarMotos() == null || dao.listarMotos().isEmpty()) throw new BancoDadosVazioException("Não possui motos no sistema");
        return dao.listarMotos();
    }
    public Veiculo buscarIndex(int index) throws IndexIncorretoException{
        validarIndex(index);
        return dao.listarTodos().get(index);
    }
}
