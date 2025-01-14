package dis.ulpgc.kata4.app;

import dis.ulpgc.kata4.architecture.control.ToggleBarchartCommand;
import dis.ulpgc.kata4.architecture.io.FileTitleLoader;
import dis.ulpgc.kata4.architecture.io.MoviesBarchartLoader;
import dis.ulpgc.kata4.architecture.model.FromMapBarchartElementBuilder;
import dis.ulpgc.kata4.architecture.model.Title;
import dis.ulpgc.kata4.architecture.model.TsvTitleDeserializer;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("./title.basics.tsv");
        List<Title> titles = new FileTitleLoader(file, new TsvTitleDeserializer()).load();
        Map<Integer, Integer> titlesPerYearStats = new HashMap<>();
        Map<Title.TitleType, Integer> titlesTypeCountStats = new HashMap<>();
        for (Title title : titles) {
            titlesPerYearStats.put(title.getYear(), titlesPerYearStats.getOrDefault(title.getYear(), 0) + 1);
            titlesTypeCountStats.put(
                    title.getTitleType(),
                    titlesTypeCountStats.getOrDefault(
                            title.getTitleType(), 0) + 1
            );
        }
        MainFrame mainFrame = new MainFrame();
        MoviesBarchartLoader loader = new MoviesBarchartLoader(
                new FromMapBarchartElementBuilder<>(titlesPerYearStats).build(),
                new FromMapBarchartElementBuilder<>(titlesTypeCountStats).build()
        );
        mainFrame.put("toggle", new ToggleBarchartCommand(loader, mainFrame.getDisplay()));
        mainFrame.getDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }
}
