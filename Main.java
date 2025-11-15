import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // Get values from names.txt and save them to the HashMap
        HashMap<String, Integer[]> df = new HashMap<String, Integer[]>();
        String[] names = new String[0];
        Scanner scanner = new Scanner(new File("names.txt"));
        while (scanner.hasNext()) {
            // Read data on a line
            String name = scanner.next();
            names = Arrays.copyOf(names, names.length + 1);
            names[names.length - 1] = name;
            Integer[] data = new Integer[3];
            data[0] = scanner.nextInt();
            data[1] = scanner.nextInt();
            data[2] = scanner.nextInt();
            df.put(name, data);
        }
        
        // Test output
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + df.get(names[i])[0] + " " + df.get(names[i])[1] + " " + df.get(names[i])[2]);
        }
    }
}
