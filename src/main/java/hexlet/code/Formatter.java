package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JSON;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Arrays;
import java.util.List;

public class Formatter {

    public static String chooseFormat(List<Tree> diffTree, String... formatName) throws JsonProcessingException {
        if (Arrays.toString(formatName).contains("plain")) {
            return Plain.plainFormatter(diffTree);
        } else if (Arrays.toString(formatName).contains("json")) {
            return JSON.jsonFormatter(diffTree);
        }
        return Stylish.formatter(diffTree);
    }
}
