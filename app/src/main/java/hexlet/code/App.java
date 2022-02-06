package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import hexlet.code.Differ;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

class App implements Callable<Integer> {

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        String filePath1 = "";
        String filePath2 = "";
        System.out.println("Hello MIHA!!!!!!!!!!!!!!!!!!!");
        String diff = Differ.generate(filePath1, filePath2);
        System.out.println(diff);
        return 0;
    }
}