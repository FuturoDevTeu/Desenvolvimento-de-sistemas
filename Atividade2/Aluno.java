package Atividade2;
import java.util.Scanner;

public class Aluno {
    private int nota;
    Scanner s = new Scanner(System.in);


    public void pedindoNota(){
        System.out.println("Insira a nota do aluno: ");
        this.nota = s.nextInt();
    }

    public void mostrandoNota(){
        if(this.nota >=7){
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }
    }

    



}
