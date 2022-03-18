package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getData(String filepath) throws IOException {
        ObjectMapper objectMapper = MapperFactory.getMapper(filepath);
        String content = Differ.getStringFromFile(filepath);
        return objectMapper.readValue(content, new TypeReference<>() {
        });
    }

}
