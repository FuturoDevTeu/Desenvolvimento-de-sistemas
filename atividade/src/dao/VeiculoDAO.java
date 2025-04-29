package dao;

import java.util.ArrayList;
import java.util.stream.Collectors;
import model.Carro;
import model.Moto;
import model.Veiculo;

public class VeiculoDAO {
    private static ArrayList<Veiculo> lista = new ArrayList<>();

     public void adicionar(Veiculo v) {
        lista.add(v);
    }

    public ArrayList<Veiculo> listarTodos() {
        return lista;
    }

    public ArrayList<Carro> listarCarros() {
        return lista.stream()
                .filter(v -> v instanceof Carro)
                .map(v -> (Carro) v)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Moto> listarMotos() {
        return lista.stream()
                .filter(v -> v instanceof Moto)
                .map(v -> (Moto) v)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public void alterar(int index, Veiculo veiculo){
        lista.set(index, veiculo);
    }
    public void remover(int index){
        lista.remove(index);
    }
}

