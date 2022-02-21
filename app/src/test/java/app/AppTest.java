package app;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Map;

class AppTest {
    @Test
    void testGenDiff() throws IOException {
        String pathToFirstFile = Differ.readUsingFiles(
                "/home/wtffka/java-project-lvl2/app/src/test/resources/file1.json");
        String pathToSecondFile = Differ.readUsingFiles(
                "/home/wtffka/java-project-lvl2/app/src/test/resources/file2.json");
        Map<String, Object> firstJsonFile = Differ.getData(pathToFirstFile);
        Map<String, Object> secondJsonFile = Differ.getData(pathToSecondFile);
        String expectedString = "{\n"
                + "\t - follow: false\n"
                + "\t   host: hexlet.io\n"
                + "\t - proxy: 123.234.53.22\n"
                + "\t - timeout: 50\n"
                + "\t + timeout: 20\n"
                + "\t + verbose: true\n"
                + "}";
        String result = Differ.genDiff(firstJsonFile, secondJsonFile);
        assertThat(expectedString).isEqualTo(result);

    }

}
