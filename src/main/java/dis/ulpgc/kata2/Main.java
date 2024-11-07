package dis.ulpgc.kata2;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> histogram = new HashMap<>();
        File file = new File("./title.basics.tsv");
        List<Title> titles = new FileTitleLoader(file, new TsvTitleDeserializer()).load();
        for (Title title : titles) {
            histogram.put(title.getYear(), histogram.getOrDefault(title.getYear(), 0) + 1);
        }
        HistogramStatsDisplayer histogramStatsDisplayer = new HistogramStatsDisplayer(
                new FromMapHistogramElementBuilder(histogram)
        );
        histogramStatsDisplayer.displayStats();
    }
}
