package by.trjava.ivankharytanovich.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private final static String PARAGRAPH_SPLITTER = "\n\t";
    private final static String WORD_SPLITTER = " ";

    private List<TextComponent> componentList = new ArrayList<>();
    private ComponentType componentType;

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public void add(TextComponent component) {
        componentList.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        componentList.remove(component);
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getComponents() {
        return componentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (componentList != null ? !componentList.equals(that.componentList) : that.componentList != null)
            return false;
        return componentType == that.componentType;
    }

    @Override
    public int hashCode() {
        int result = componentList != null ? componentList.hashCode() : 0;
        result = 31 * result + (componentType != null ? componentType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent textComponent : componentList) {
            switch (textComponent.getType()) {

                case PARAGRAPH:
                    stringBuilder.append(PARAGRAPH_SPLITTER);
                    break;

                case WORD:
                    stringBuilder.append(WORD_SPLITTER);
                    break;

            }
            stringBuilder.append(textComponent.toString());
        }
        return stringBuilder.toString();
    }
}
