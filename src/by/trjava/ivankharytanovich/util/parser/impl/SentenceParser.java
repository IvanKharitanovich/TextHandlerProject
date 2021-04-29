package by.trjava.ivankharytanovich.util.parser.impl;

import by.trjava.ivankharytanovich.entity.ComponentType;
import by.trjava.ivankharytanovich.entity.TextComponent;
import by.trjava.ivankharytanovich.entity.TextComposite;
import by.trjava.ivankharytanovich.exception.ActionException;
import by.trjava.ivankharytanovich.util.parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parser {

    private static final String SENTENCE_SPLITTER = ".+?([.]{3}|[.!?])";

    public SentenceParser() {
        super(new WordParser());
    }

    @Override
    public TextComponent componentParse(String text) throws ActionException {
        TextComponent componentParagraph = new TextComposite(ComponentType.PARAGRAPH);

        Pattern patternSentence = Pattern.compile(SENTENCE_SPLITTER);
        Matcher matcher = patternSentence.matcher(text);

        while (matcher.find()) {
            String sentence = text.substring(matcher.start(), matcher.end());
            String trimSentence = sentence.trim();

            TextComponent componentSentence = nextParser.componentParse(trimSentence);
            componentParagraph.add(componentSentence);
        }
        return componentParagraph;
    }
}
