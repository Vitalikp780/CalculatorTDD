public class NumberNegativeException extends Exception {
    public NumberNegativeException(){
    }
    public NumberNegativeException(String message){
        super(message);
    }
    public String toString(){
        return ("NumberNegativeException");
    }
}
