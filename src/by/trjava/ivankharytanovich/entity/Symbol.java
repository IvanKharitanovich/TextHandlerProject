package by.trjava.ivankharytanovich.entity;

import java.util.List;

public class Symbol implements TextComponent{

    private char symbol;
    private ComponentType type;

    public Symbol(char symbol, ComponentType type) {
        this.symbol = symbol;
        this.type=type;
    }

    @Override
    public void add(TextComponent component) {

    }

    @Override
    public void remove(TextComponent component) {

    }

    @Override
    public ComponentType getType() {
        return null;
    }

    @Override
    public List<TextComponent> getComponents() {
        return null;
    }
}
