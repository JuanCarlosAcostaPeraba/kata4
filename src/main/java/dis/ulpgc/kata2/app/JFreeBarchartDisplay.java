package dis.ulpgc.kata2.app;

import dis.ulpgc.kata2.architecture.model.Barchart;
import dis.ulpgc.kata2.architecture.view.BarchartDisplay;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

public class JFreeBarchartDisplay extends JPanel implements BarchartDisplay {
    public JFreeBarchartDisplay() {
        setLayout(new BorderLayout());
    }
    @Override
    public void show(Barchart barchart) {
        removeAll();
        this.add(new ChartPanel(adapt(barchart)));
        revalidate();
    }

    private JFreeChart adapt(Barchart barchart) {
        return JFreeBarchartAdapter.adapt(barchart);
    }
}
