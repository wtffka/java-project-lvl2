package hexlet.code.formatters;

import hexlet.code.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String plainFormatter(List<Tree> treeDiff) {

        StringBuilder diffBuilder = new StringBuilder();

        for (Tree pair : treeDiff) {
            diffBuilder.append(createPlainString(pair));
        }
        return diffBuilder.toString().trim();
    }

    private static String createPlainString(Tree pair) {
        String key = pair.getKey();
        Object value1 = modifyIfStringOrArrayListOrMapValues(pair.getStartingValue());
        Object value2 = modifyIfStringOrArrayListOrMapValues(pair.getFinalValue());
        String changesType = pair.getTypeOfChange();

        if (changesType.equals("removed")) {
            return "Property '" + key + "' was removed" + "\n";
        }
        if (changesType.equals("added")) {
            return "Property '" + key + "' was added with value: " + value2 + "\n";
        }
        if (changesType.equals("changed")) {
            return "Property '" + key + "' was updated. From " + value1 + " to " + value2 + "\n";
        }
        return "";
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
