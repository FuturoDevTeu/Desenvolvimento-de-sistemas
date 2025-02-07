package Atividade6;
import java.util.ArrayList;
import java.util.Scanner;


public class Nota {
    private ArrayList<Integer> notas = new ArrayList<>();
    private int contador;
    Scanner s = new Scanner(System.in);

    public void pedindoNotas(){
        do{
            System.out.print("Insira o "+ (contador+ 1) + "° numero: ");
            notas.add(s.nextInt());

            if(notas.get(contador) == 0){
                notas.remove(contador);
                return ;
            }
            contador +=1 ;
        }while(true);
    }
    
    public void mostrarNotas(){
        int soma = 0;
        for(int nota : notas){
            soma = soma + nota;
        }

        float media = soma / notas.size();

        System.out.println("Sua media foi: "+ media);

        for (Integer i : notas) {
            System.out.println(i);
        }


    }

    
}
