package by.trjava.ivankharytanovich.util.parser.impl;

import by.trjava.ivankharytanovich.entity.ComponentType;
import by.trjava.ivankharytanovich.entity.TextComponent;
import by.trjava.ivankharytanovich.entity.TextComposite;
import by.trjava.ivankharytanovich.exception.ActionException;
import by.trjava.ivankharytanovich.util.parser.Parser;

public class WordParser extends Parser {

    private static String WORD_SPLITTER = " ";

    public WordParser() {
        super(new SymbolParser());
    }

    @Override
    public TextComponent componentParse(String text) throws ActionException {
        TextComponent componentSentence = new TextComposite(ComponentType.SENTENCE);
        String[] words = text.split(WORD_SPLITTER);

        for (String word : words) {
            TextComponent componentWord = nextParser.componentParse(word);
            componentSentence.add(componentWord);
        }
        return componentSentence;
    }

}
