package exception;

public class MyArrayDataException extends Exception{
    public MyArrayDataException (String message) {
        super("Неверные данные в ячейке "+message);
    }
}
