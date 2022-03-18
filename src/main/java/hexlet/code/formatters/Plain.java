package hexlet.code.formatters;

import hexlet.code.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String plainFormatter(List<Tree> treeDiff) {

        StringBuilder diffBuilder = new StringBuilder();

        for (Tree pair : treeDiff) {
            String key = pair.getKey();
            Object value1 = modifyIfStringOrArrayListOrMapValues(pair.getStartingValue());
            Object value2 = modifyIfStringOrArrayListOrMapValues(pair.getFinalValue());
            String changesType = pair.getTypeOfChange();

            if (changesType.equals("removed")) {
                diffBuilder.append("Property '" + key + "' was removed" + "\n");
            }
            if (changesType.equals("added")) {
                diffBuilder.append("Property '" + key + "' was added with value: " + value2 + "\n");
            }
            if (changesType.equals("changed")) {
                diffBuilder.append("Property '" + key + "' was updated. From " + value1 + " to " + value2 + "\n");
            }
        }
        return diffBuilder.toString().trim();
    }

    private static Object modifyIfStringOrArrayListOrMapValues(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof ArrayList || value instanceof Map) {
            return "[complex value]";
        }

        return value.toString();
    }
}
