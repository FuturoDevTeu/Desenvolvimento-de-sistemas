package Atividade3;
import java.util.Scanner;

public class Sistema {
    private String senhaS, senhaU;
    Scanner s = new Scanner(System.in);

    public Sistema(String senhaS){
        this.senhaS = senhaS;
    }

    public void pedindoSenha(){
        System.out.println("Digite a senha: ");
        senhaU = s.next();
    }

    public void verificandoSenha(){
        if(senhaU.contains(senhaS)){
            System.out.println("Acesso permitido");
        }else{
            System.out.println("Acesso negado");
        }
    }




    
}
