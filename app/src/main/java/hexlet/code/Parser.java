package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static String generate(String filepath1, String filepath2) throws IOException {
        Map<String, Object> firstFileToMap = getData(filepath1);
        Map<String, Object> secondFileToMap = getData(filepath2);
        return Differ.genDiff(firstFileToMap, secondFileToMap);
    }

    public static Map<String, Object> getData(String filepath) throws IOException {
        ObjectMapper objectMapper = MapperFactory.getMapper(filepath);
        String content = new String(Files.readAllBytes(Paths.get(filepath)));
        Map<String, Object> map = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
        return map;
    }

}