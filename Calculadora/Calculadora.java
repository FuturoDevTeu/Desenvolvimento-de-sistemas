import java.util.ArrayList;

public class Calculadora{

    public Integer somar(ArrayList<Integer> numeros){
        Integer soma = 0;
        for (Integer numero : numeros) {
            soma = soma + numero;
        }
        return soma;
    }

    public  Integer subtrair(ArrayList<Integer> numeros){
        Integer subtrair = numeros.get(0);
        for(int i = 1; i < numeros.size(); i++){
            subtrair -= numeros.get(i);
        }
        return subtrair;
    }

    public Integer multiplicar(ArrayList<Integer> numeros){
        Integer multiplicar = numeros.get(0);
        for(int i = 1; i <numeros.size(); i++){
            multiplicar *= numeros.get(i);
        }
        return multiplicar;
    }
    public Double dividir(ArrayList<Integer> numeros){
        ArrayList<Double> numerosD;
        numerosD = new ArrayList<>();

        for(Integer integer : numeros){
            numerosD.add(integer.doubleValue());
        }
        Double dividir = numerosD.get(0);
        for(int i = 1; i < numeros.size(); i++){
            dividir /= numerosD.get(i);
        }
        return dividir;
    }



}
