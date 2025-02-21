import java.util.ArrayList;
import java.util.Scanner;

public class App{
    static Scanner s;
    public static void main(String[] args) {
        while(true){
            ArrayList<Integer> numeros = pedindoNumero();
            String opcao = menu();
            if(!verificandoOpcao(opcao, numeros)){
                break;
            }
        }
    }

    public static ArrayList<Integer> pedindoNumero(){
        s = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        int c = 0;
        System.out.println("Insira o numero 0 para parar!!");
        while (true) { 
            System.out.print("Digite o "+ (c+1) +"° numero: ");
            int n = s.nextInt();
            if(n != 0 ){
                numeros.add(n);
                c++;
            }else{
                return numeros;
            }
        }
        
    }

    public static String menu(){
        s = new Scanner(System.in);
        System.out.println("1 \tSomar");
        System.out.println("2 \tSubtrair");
        System.out.println("3 \tMultiplicar");
        System.out.println("4 \tDividir");
        System.out.println("0 \tSair");
        System.out.println("Digite o tipo de calculo que deseja fazer");
        String opcao = s.next();
        System.out.println("");

        return opcao;
    }
    public static boolean verificandoOpcao(String opcao, ArrayList<Integer> numeros){
        Calculadora c = new Calculadora(); 
        switch (opcao) {
            case "1":
                System.out.println(c.somar(numeros));
                return true;
        
            case "2":
                System.out.println(c.subtrair(numeros));
                return true;

            case "3":   
                System.out.println(c.multiplicar(numeros));
                return true;
            case "4":   
                System.out.println(c.dividir(numeros));
                return true;

            case "0":
                System.out.println("Finalizando...");
                return false;
            default:
                System.out.println("Alternativa invalida");
                return true;
                
        }
    }

}