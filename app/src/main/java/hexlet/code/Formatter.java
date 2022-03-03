package hexlet.code;

import formatters.Plain;
import formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String chooseFormat(String formatName, Map<String, Object> mapToFormat) {
        if (formatName.equals("plain")) {
            return Plain.formatter(mapToFormat);
        }
        return Stylish.formatter(mapToFormat);
    }
}
