package dis.ulpgc.kata2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> histogram = new HashMap<>();
        System.out.println("Reading file...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("./title.basics.tsv")));
            reader.readLine();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                String[] fields = line.split("\t");
                histogram.putIfAbsent(fields[1], 0);
                histogram.computeIfPresent(fields[1], (k, v) -> v + 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File already read");
        System.out.println("Title types' histogram:");
        for (Map.Entry<String, Integer> stringIntegerEntry : histogram.entrySet()) {
            System.out.println(stringIntegerEntry);
        }
    }
}
