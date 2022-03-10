package formatters;

import java.util.Map;

public class Stylish {
    private static final String WHITESPACE = " ";
    private static final int AMOUNTOFWHITESPACES = 4;
    private static final int AMOUNTOFWHITESPACESIFKEYSTARTSWITHWHITESPACE = 7;

    public static String formatter(Map<String, Object> sortedMap) {
        StringBuilder builder = new StringBuilder("{\n");

        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            if (!entry.getKey().startsWith(WHITESPACE)) {
                builder.append(WHITESPACE.repeat(AMOUNTOFWHITESPACESIFKEYSTARTSWITHWHITESPACE)
                        + entry.getKey() + ":" + WHITESPACE
                        + entry.getValue() + "\n");
                continue;
            }
            builder.append(WHITESPACE.repeat(AMOUNTOFWHITESPACES) + entry.getKey() + ":" + WHITESPACE
                    + entry.getValue() + "\n");
        }
        builder.append("}");
        return builder.toString();
    }
}
