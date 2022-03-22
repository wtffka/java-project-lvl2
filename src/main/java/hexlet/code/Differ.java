package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class Differ {

    public static String generate(String filepath1, String filepath2, String formatName) throws IOException {
        Map<String, Object> firstFileToMap = Parser.getData(getStringFromFile(filepath1), formatName);
        Map<String, Object> secondFileToMap = Parser.getData(getStringFromFile(filepath2), formatName);

        List<Tree> diffTree = Tree.buildDiff(firstFileToMap, secondFileToMap);

        return Formatter.format(diffTree, formatName);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }

    private static String getStringFromFile(String filepath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }
}
