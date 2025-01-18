package software.ulpgc.kata4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FromMapBarchartElementBuilder <K> implements BarchartElementBuilder {
    private final Map<K, Integer> data;

    public FromMapBarchartElementBuilder(Map<K, Integer> data) {
        this.data = data;
    }

    @Override
    public List<BarchartElement> build() {
        List<BarchartElement> histogramElements = new ArrayList<>();
        for (K i : data.keySet()) {
            histogramElements.add(new BarchartElement(String.valueOf(i), data.get(i)));
        }
        return histogramElements;
    }
}
