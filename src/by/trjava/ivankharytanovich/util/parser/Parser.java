package by.trjava.ivankharytanovich.util.parser;

import by.trjava.ivankharytanovich.entity.TextComponent;
import by.trjava.ivankharytanovich.exception.ActionException;

public abstract class Parser {

    protected Parser nextParser;


    public Parser() {
    }

    public Parser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract TextComponent componentParse(String text) throws ActionException;
}
