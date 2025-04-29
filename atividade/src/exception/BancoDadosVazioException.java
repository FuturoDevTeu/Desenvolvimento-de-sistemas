package exception;

public class BancoDadosVazioException extends Exception{
    public BancoDadosVazioException(){
        super("Não possui dados");
    }
    public BancoDadosVazioException(String message){
        super(message);
    }
}
