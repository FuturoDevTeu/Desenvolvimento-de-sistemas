package Atividade4;
import java.util.Scanner;


public class POI{
    private int numero;
    Scanner s = new Scanner(System.in);

    public void pedindoNumero(){
        System.out.println("Insira um numero: ");
        this.numero =  s.nextInt();
    }

    public void mostrandoPOI(){
        if(this.numero % 2 ==0){
            System.out.println("Par");
        } else {
            System.out.println("Impar");
        }
    }

}
