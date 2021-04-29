package by.trjava.ivankharytanovich.util.reader;

import by.trjava.ivankharytanovich.exception.DataException;

public interface Reader {
    String read(String fileName) throws DataException;
}
