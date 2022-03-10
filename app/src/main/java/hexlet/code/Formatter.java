package hexlet.code;

import formatters.JSON;
import formatters.Plain;
import formatters.Stylish;


import java.util.Arrays;
import java.util.Map;

public class Formatter {

    public static String chooseFormat(Map<String, Object> mapToFormat, String... formatName) {
        if (Arrays.toString(formatName).contains("plain")) {
            return Plain.formatter(mapToFormat);
        } else if (Arrays.toString(formatName).contains("json")) {
            return JSON.formatter(mapToFormat);
        }
        return Stylish.formatter(mapToFormat);
    }
}
