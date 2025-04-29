package exception;

public class CampoVazioException extends Exception{
    public CampoVazioException(){
        super("Campo vazio");
    }
    public CampoVazioException(String message){
        super(message);
    }
}
