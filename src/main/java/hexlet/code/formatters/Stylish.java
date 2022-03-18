package hexlet.code.formatters;

import hexlet.code.Tree;

import java.util.List;

public class Stylish {

    private static final String WHITESPACE = " ";
    private static final int AMOUNTOFWHITESPACESIFTYPEOFCHANGEISNOTHING = 4;

    public static String formatter(List<Tree> diffTree) {
        StringBuilder diffBuilder = new StringBuilder("{\n");

        for (Tree pair : diffTree) {
            String key = pair.getKey();
            Object startingValue = pair.getStartingValue();
            Object finalValue = pair.getFinalValue();
            String typeOfChange = pair.getTypeOfChange();

            if (typeOfChange.equals("removed")) {
                diffBuilder.append(WHITESPACE.repeat(2))
                        .append("-")
                        .append(WHITESPACE)
                        .append(key)
                        .append(":")
                        .append(WHITESPACE)
                        .append(startingValue)
                        .append("\n");
            }
            if (typeOfChange.equals("added")) {
                diffBuilder.append(WHITESPACE.repeat(2))
                        .append("+")
                        .append(WHITESPACE)
                        .append(key)
                        .append(":")
                        .append(WHITESPACE)
                        .append(finalValue)
                        .append("\n");
            }
            if (typeOfChange.equals("unchanged")) {
                diffBuilder.append(WHITESPACE.repeat(AMOUNTOFWHITESPACESIFTYPEOFCHANGEISNOTHING))
                        .append(key)
                        .append(":")
                        .append(WHITESPACE)
                        .append(startingValue)
                        .append("\n");
            }
            if (typeOfChange.equals("changed")) {
                diffBuilder.append(WHITESPACE.repeat(2))
                        .append("-")
                        .append(WHITESPACE)
                        .append(key)
                        .append(":")
                        .append(WHITESPACE)
                        .append(startingValue)
                        .append("\n")

                        .append(WHITESPACE.repeat(2))
                        .append("+")
                        .append(WHITESPACE)
                        .append(key)
                        .append(":")
                        .append(WHITESPACE)
                        .append(finalValue)
                        .append("\n");
            }
        }

        diffBuilder.append("}");
        return diffBuilder.toString();
    }
}
