package exception;

public class IndexIncorretoException extends Exception{
    public IndexIncorretoException(){
        super("Index invalido");
    }
    public IndexIncorretoException(String message){
        super(message);
    }
}
