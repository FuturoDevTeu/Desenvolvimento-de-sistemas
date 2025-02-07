package Atividade5;
import java.util.Scanner;

public class Pessoa {
    private int idade;
    Scanner s = new Scanner(System.in);

    public void pedindoIdade(){
        System.out.println("Insira sua idade: ");
        this.idade = s.nextInt();
    }

    public void mostrarIdade(){
        if(this.idade >=18){
            System.out.println("Maior de idade");
        } else {
            System.out.println("Menor de idade");
        }
    }
    
}