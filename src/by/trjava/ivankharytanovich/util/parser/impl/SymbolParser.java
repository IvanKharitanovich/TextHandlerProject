package by.trjava.ivankharytanovich.util.parser.impl;

import by.trjava.ivankharytanovich.entity.ComponentType;
import by.trjava.ivankharytanovich.entity.Symbol;
import by.trjava.ivankharytanovich.entity.TextComponent;
import by.trjava.ivankharytanovich.entity.TextComposite;
import by.trjava.ivankharytanovich.exception.ActionException;
import by.trjava.ivankharytanovich.util.parser.Parser;

import java.util.regex.Pattern;

public class SymbolParser extends Parser {

    private static final String LETTER_SPLITTER = "";
    private static final String PUNCTUATION_SPLITTER = "[\\.!?,']";
    private static final int SYMBOL_START_POSITION = 0;
    private static final int PUNCTUATION_START_POSITION = 0;

    public SymbolParser() {
        super(null);
    }

    @Override
    public TextComponent componentParse(String text) throws ActionException {
        TextComponent componentWord = new TextComposite(ComponentType.WORD);
        String[] symbols = text.split(LETTER_SPLITTER);

        for (String symbol : symbols) {
            TextComponent textComponent;
            if (Pattern.matches(PUNCTUATION_SPLITTER, symbol)) {
                textComponent = new Symbol(symbol.charAt(PUNCTUATION_START_POSITION), ComponentType.PUNCTUATION);
            } else {
                textComponent = new Symbol(symbol.charAt(SYMBOL_START_POSITION), ComponentType.SYMBOL);
            }
            componentWord.add(textComponent);
        }
        return componentWord;
    }
}
