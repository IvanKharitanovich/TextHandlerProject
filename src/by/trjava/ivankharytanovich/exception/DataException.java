package by.trjava.ivankharytanovich.exception;

public class DataException extends Exception {
    public DataException() {
        super();
    }

    public DataException(String message) {
        super(message);
    }

    public DataException(Exception e) {
        super(e);
    }

    public DataException(String message, Exception e) {
        super(message, e);
    }
}
