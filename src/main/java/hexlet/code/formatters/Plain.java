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
                diffBuilder.append("Property '")
                    .append(key)
                    .append("' was removed")
                    .append("\n");
            }
            if (changesType.equals("added")) {
                diffBuilder.append("Property '")
                    .append(key)
                    .append("' was added with value: ")
                    .append(value2)
                    .append("\n");
            }
            if (changesType.equals("changed")) {
                diffBuilder.append("Property '")
                    .append(key)
                    .append("' was updated. ")
                    .append("From ")
                    .append(value1)
                    .append(" to ")
                    .append(value2)
                    .append("\n");
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
