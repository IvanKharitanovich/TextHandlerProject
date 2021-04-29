package by.trjava.ivankharytanovich.util.reader.impl;

import by.trjava.ivankharytanovich.exception.DataException;
import by.trjava.ivankharytanovich.util.reader.Reader;
import by.trjava.ivankharytanovich.validation.DaoValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReaderForTextFile implements Reader {
    private static final Logger logger = LogManager.getLogger();
    private static final ReaderForTextFile INSTANCE = new ReaderForTextFile();

    private ReaderForTextFile() {
    }

    public static ReaderForTextFile getInstance() {
        return INSTANCE;
    }

    @Override
    public String read(String fileName) throws DataException {
        String defaultDirectoryName = "data";
        Path path = FileSystems.getDefault().getPath(defaultDirectoryName, fileName);
        if (DaoValidation.isEmpty(path)) {
            throw new DataException("FILE NOT FOUND");
        }
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Stream<String> stringStream = Files.lines(path);
            stringStream.forEach(s -> {
                stringBuilder.append(s);
                stringBuilder.append('\n');
            });

        } catch (IOException e) {
            logger.error("FILE NOT READABLE: " + path.toString());
            throw new DataException("FILE NOT READABLE");
        }
        return stringBuilder.toString();
    }
}
