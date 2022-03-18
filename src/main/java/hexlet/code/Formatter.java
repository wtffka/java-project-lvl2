package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JSON;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {

    public static String format(List<Tree> diffTree, String formatName) throws JsonProcessingException {
        if (formatName.equals("plain")) {
            return Plain.plainFormatter(diffTree);
        } else if (formatName.equals("json")) {
            return JSON.jsonFormatter(diffTree);
        }
        return Stylish.formatter(diffTree);
    }
}
