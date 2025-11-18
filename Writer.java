import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Writer {
    public static void clear() throws IOException {
        Files.write(Paths.get("write.txt"), new ArrayList<>());
    }

    public static void write(HashMap<String, Double> data) throws IOException {

        Path path = Paths.get("write.txt");
        List<String> writer = Files.readAllLines(path);
        
    }
}