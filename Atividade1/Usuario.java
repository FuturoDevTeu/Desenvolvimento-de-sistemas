package Atividade1;
import java.util.Scanner;


public class Usuario {
    private float salario;
    Scanner s = new Scanner(System.in);

    public void pedindoSalario(){
        System.out.print("Insira seu salario: ");
        this.salario = s.nextFloat();
    }

    public void mostrandoInformacao(){
        if(this.salario >=300){
            System.out.println("Voce é rico");
        }
        else{
            System.out.println("Voce é pobre");
        }
    }
}
