package by.trjava.ivankharytanovich.util.parser.impl;

import by.trjava.ivankharytanovich.entity.ComponentType;
import by.trjava.ivankharytanovich.entity.TextComponent;
import by.trjava.ivankharytanovich.entity.TextComposite;
import by.trjava.ivankharytanovich.exception.ActionException;
import by.trjava.ivankharytanovich.util.parser.Parser;

public class ParagraphParser extends Parser {

    private final static String PARAGRAPH_SPLITTER = "\n\t";

    public ParagraphParser() {
        super(new SentenceParser());
    }

    @Override
    public TextComponent componentParse(String text) throws ActionException {
        TextComponent componentText = new TextComposite(ComponentType.TEXT);

        String[] paragraphs = text.split(PARAGRAPH_SPLITTER);

        for (String paragraph : paragraphs) {
            TextComponent componentSentence = nextParser.componentParse(paragraph);
            componentText.add(componentSentence);
        }
        return componentText;
    }
}