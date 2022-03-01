package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.Differ;
import hexlet.code.Parser;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Map;

class AppTest {
    @Test
    void testGenDiffJSON() throws IOException {
        Map<String, Object> firstJsonFile = Parser.getData(
                "/home/wtffka/java-project-lvl2/app/src/test/resources/file1.json");
        Map<String, Object> secondJsonFile = Parser.getData(
                "/home/wtffka/java-project-lvl2/app/src/test/resources/file2.json");
        String expectedString = "{\n"
                + "\t   chars1: [a, b, c]\n"
                + "\t - chars2: [d, e, f]\n"
                + "\t + chars2: false\n"
                + "\t - checked: false\n"
                + "\t + checked: true\n"
                + "\t - default: null\n"
                + "\t + default: [value1, value2]\n"
                + "\t - id: 45\n"
                + "\t + id: null\n"
                + "\t - key1: value1\n"
                + "\t + key2: value2\n"
                + "\t   numbers1: [1, 2, 3, 4]\n"
                + "\t - numbers2: [2, 3, 4, 5]\n"
                + "\t + numbers2: [22, 33, 44, 55]\n"
                + "\t - numbers3: [3, 4, 5]\n"
                + "\t + numbers4: [4, 5, 6]\n"
                + "\t + obj1: {nestedKey=value, isNested=true}\n"
                + "\t - setting1: Some value\n"
                + "\t + setting1: Another value\n"
                + "\t - setting2: 200\n"
                + "\t + setting2: 300\n"
                + "\t - setting3: true\n"
                + "\t + setting3: none\n"
                + "}";
        String result = Differ.genDiff(firstJsonFile, secondJsonFile);
        assertThat(result).isEqualTo(expectedString);

    }

    @Test
    void testGenDiffYAML() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        Map<String, Object> map1 = Parser.getData(
                "/home/wtffka/java-project-lvl2/app/src/test/resources/file1.yml");
        Map<String, Object> map2 = Parser.getData(
                "/home/wtffka/java-project-lvl2/app/src/test/resources/file2.yml");


        String expectedString = "{\n"
                + "\t - follow: false\n"
                + "\t   host: hexlet.io\n"
                + "\t - proxy: 123.234.53.22\n"
                + "\t - timeout: 50\n"
                + "\t + timeout: 20\n"
                + "\t + verbose: true\n"
                + "}";

        String result = Differ.genDiff(map1, map2);
        assertThat(result).isEqualTo(expectedString);

    }

}
