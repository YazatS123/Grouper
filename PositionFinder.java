import java.util.*;

public class PositionFinder {
    public static HashMap<String, Double[]> setCoords(String[] categories) {

        // This class will have to be revamped entirely for future versions, because it can only assign coordinates to 3 categories, but for a proof of concept this will do just fine.
        HashMap<String, Double[]> out = new HashMap<>();

        Double[] data = {3.0, 0.0};
        out.put(categories[0], data);
        data[0] = -1.5;
        data[1] = 1.5 * Math.sqrt(3);
        out.put(categories[1], data);
        data[1] *= -1;
        out.put(categories[2], data);

        return out;
    }
    public static HashMap<String, Double[]> plot(HashMap<String, String[]> in, String[] names, String[] categories) {
        HashMap<String, Double[]> df = new HashMap<>(); // Will store names and points at the end
        HashMap<String, Double[]> points = setCoords(categories); // Holds the "points" for the categories
        double[] percentages = new double[categories.length];
        for (int i = 0; i < categories.length; i++) percentages[i] = 1.0 * Math.pow(0.5, i);
        // Percentages should be 0.5, 0.25, 0.125 for POC
        for (String name : names) {

            String[] currentData = in.get(name); // pull the current data
            double x = 0;
            double y = 0;
            for (int i = 0; i < currentData.length; i++) {
                // Needs to be modified for scalability, but for now should work for three categories
                x += percentages[i] * points.get(currentData[i])[0];
                y += percentages[i] * points.get(currentData[i])[1];
            }
            Double[] pos = {x, y}; // Should hold position of student
            df.put(name, pos);
            
        }
        
        
        return df;
    }
}
