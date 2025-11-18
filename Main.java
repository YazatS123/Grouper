import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // Get values from names.txt and save them to the HashMap
        HashMap<String, String[]> df = new HashMap<>();
        String[] names = new String[0];
        Scanner scanner = new Scanner(new File("names.txt"));
        int categoryNum = scanner.nextInt();
        String[] categories = new String[0];
        HashSet<String> catCheck = new HashSet<>();
        while (scanner.hasNext()) {
            // Read data on a line
            String name = scanner.next();
            names = Arrays.copyOf(names, names.length + 1);
            names[names.length - 1] = name;
            String[] data = new String[categoryNum];
            for (int i = 0; i < categoryNum; i++) {
                data[i] = scanner.next();
                // Fill the categories list
                if (!catCheck.contains(data[i])) {
                    categories = Arrays.copyOf(categories, categories.length + 1);
                    categories[categories.length - 1] = data[i];
                    catCheck.add(data[i]);
                }
            }
            df.put(name, data);
        }
        
        
        // Test output
        for (String name : names) {
            System.out.println(name + ": " + df.get(name)[0] + " " + df.get(name)[1] + " " + df.get(name)[2]);
        }
        HashMap<String, Double[]> positions = PositionFinder.plot(df, names, categories);
        Writer.clear();
        System.out.println("does ts ever show");
    }
}
