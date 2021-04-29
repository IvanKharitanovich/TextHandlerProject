package by.trjava.ivankharytanovich.action;

import by.trjava.ivankharytanovich.entity.TextComponent;
import by.trjava.ivankharytanovich.exception.ActionException;
import by.trjava.ivankharytanovich.util.comparator.ParagraphComparator;
import by.trjava.ivankharytanovich.validation.TypeValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAction {
    private static final TextAction INSTANCE = new TextAction();

    private TextAction() {
    }

    public static TextAction getInstance() {
        return INSTANCE;
    }

    public void sortParagraphs(TextComponent component) throws ActionException {
        if (TypeValidation.checkIncorrectTypeTXT(component)) {
            throw new ActionException("WRONG TYPE");
        }
        ParagraphComparator comparator = new ParagraphComparator();
        List<TextComponent> paragraphs = component.getComponents();
        paragraphs.sort(comparator);
    }

    public List<TextComponent> obtainSentences(TextComponent component) throws ActionException {
        if (TypeValidation.checkIncorrectTypeTXT(component)) {
            throw new ActionException("WRONG TYPE");
        }
        List<TextComponent> paragraphs = component.getComponents();
        List<TextComponent> sentencesWithMaxWord = new ArrayList<>();
        int maxLength = 0;

        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences;
            sentences = paragraph.getComponents();
            for (TextComponent sentence : sentences) {
                List<TextComponent> words = sentence.getComponents();
                for (TextComponent word : words) {
                    if (word.getComponents().size() > maxLength) {
                        maxLength = word.getComponents().size();
                        sentencesWithMaxWord.clear();
                        sentencesWithMaxWord.add(sentence);
                    } else if (word.getComponents().size() == maxLength) {
                        sentencesWithMaxWord.add(sentence);
                    }
                }
            }
        }
        return sentencesWithMaxWord;
    }

    public void deleteSentences(TextComponent component, int value) throws ActionException {
        if (TypeValidation.checkIncorrectTypeTXT(component)) {
            throw new ActionException("WRONG TYPE");
        }
        List<TextComponent> paragraphs = component.getComponents();

        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getComponents();
            sentences.removeIf(e -> e.getComponents().size() < value);
        }
    }

    public long numberIdenticalWords(TextComponent component) throws ActionException {
        if (TypeValidation.checkIncorrectTypeTXT(component)) {
            throw new ActionException("WRONG TYPE");
        }
        Map<String, Integer> identicalWords = new HashMap<>();
        List<TextComponent> paragraphs = component.getComponents();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getComponents();
            for (TextComponent sentence : sentences) {
                List<TextComponent> words = sentence.getComponents();
                for (TextComponent word : words) {
                    String stringWord;
                    StringBuilder stringBuilder = new StringBuilder();
                    for (TextComponent element : word.getComponents()) {
                        if (TypeValidation.checkIncorrectTypePUNCTUATION(element)) {
                            stringBuilder.append(element);
                        }
                    }
                    stringWord = stringBuilder.toString();

                    if (identicalWords.containsKey(stringWord)) {
                        identicalWords.put(stringWord, identicalWords.get(stringWord) + 1);
                    } else {
                        identicalWords.put(stringWord, 1);
                    }
                }
            }
        }
        return identicalWords.values().stream().filter(a -> a > 1).count();
    }
}
