package model;

public class Carro extends Veiculo{
    private String numeroPortas;

    public Carro() {
        super();
    }

    public Carro(String marca, String modelo, String numeroPortas) {
        super(marca, modelo);
        this.numeroPortas = numeroPortas;
    }

    public String getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(String numeroPortas) {
        this.numeroPortas = numeroPortas;
    }
    
    
    
    
}
