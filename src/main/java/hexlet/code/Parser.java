package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getData(String stringFromFile, String formatName) throws IOException {
        ObjectMapper objectMapper;
        if (formatName.equalsIgnoreCase("json")) {
            objectMapper = new ObjectMapper();
        } else {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        return objectMapper.readValue(stringFromFile, new TypeReference<>() {
        });
    }

}
