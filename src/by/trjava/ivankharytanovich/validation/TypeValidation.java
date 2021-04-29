package by.trjava.ivankharytanovich.validation;

import by.trjava.ivankharytanovich.entity.ComponentType;
import by.trjava.ivankharytanovich.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TypeValidation {
    private static final Logger logger = LogManager.getLogger();

    public static boolean checkIncorrectTypeTXT(TextComponent component){
        boolean status = false;
        if(component.getType() != ComponentType.TEXT){
            logger.error("WRONG TYPE");
            status = true;
        }
        return status;
    }

    public static boolean checkIncorrectTypePUNCTUATION(TextComponent component){
        boolean status = false;
        if(component.getType() != ComponentType.PUNCTUATION){
            logger.error("WRONG TYPE");
            status = true;
        }
        return status;
    }
}
