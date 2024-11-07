package dis.ulpgc.kata2;

import java.util.List;

public class HistogramStatsDisplayer implements StatsDisplayer {
    private final List<HistogramElement> histogramElements;

    public HistogramStatsDisplayer(HistogramElementBuilder histogramElementsBuilder) {
        this.histogramElements = histogramElementsBuilder.build();
    }

    @Override
    public void displayStats() {
        for (HistogramElement histogramElement : histogramElements) {
            System.out.println(histogramElement.getField() + " " + "|".repeat(histogramElement.getValue()/1000));
        }
        System.out.println("The end.");
    }
}
