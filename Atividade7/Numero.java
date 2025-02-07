package Atividade7;
import java.util.Scanner;

public class Numero {
    private int n;
    Scanner s = new Scanner(System.in);

    public void pedindoNumero(){
        System.out.println("Informe um numero: ");
        this.n = s.nextInt();
    }

    public void mostrandoNumero(){
        if(this.n == 0){
            System.out.println("O numero é nulo");
        }else if(this.n > 0){
            System.out.println("O numero é positivo");
        }else{
            System.out.println("O numero é negativo");
        }
    }
    
}
