//package app;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
//import hexlet.code.Differ;
//import hexlet.code.Parser;
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.io.IOException;
//import java.util.Map;
//
//class AppTest {
//    @Test
//    void testGenDiffJSON() throws IOException {
//        Map<String, Object> firstJsonFile = Parser.getData(
//                "/home/wtffka/java-project-lvl2/app/src/test/resources/file1.json");
//        Map<String, Object> secondJsonFile = Parser.getData(
//                "/home/wtffka/java-project-lvl2/app/src/test/resources/file2.json");
//        String expectedString = "{\n"
//                + "\t - follow: false\n"
//                + "\t   host: hexlet.io\n"
//                + "\t - proxy: 123.234.53.22\n"
//                + "\t - timeout: 50\n"
//                + "\t + timeout: 20\n"
//                + "\t + verbose: true\n"
//                + "}";
//        String result = Differ.genDiff(firstJsonFile, secondJsonFile);
//        assertThat(expectedString).isEqualTo(result);
//
//    }
//
//    @Test
//    void testGenDiffYAML() throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
//
//        Map<String, Object> map1 = Parser.getData(
//                "/home/wtffka/java-project-lvl2/app/src/test/resources/file1.yml");
//        Map<String, Object> map2 = Parser.getData(
//                "/home/wtffka/java-project-lvl2/app/src/test/resources/file2.yml");
//
//
//        String expectedString = "{\n"
//                + "\t - follow: false\n"
//                + "\t   host: hexlet.io\n"
//                + "\t - proxy: 123.234.53.22\n"
//                + "\t - timeout: 50\n"
//                + "\t + timeout: 20\n"
//                + "\t + verbose: true\n"
//                + "}";
//
//        String result = Differ.genDiff(map1, map2);
//        assertThat(expectedString).isEqualTo(result);
//
//    }
//
//}
