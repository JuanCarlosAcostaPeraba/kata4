package dis.ulpgc.kata2.architecture.control;

import dis.ulpgc.kata2.architecture.view.BarchartDisplay;
import dis.ulpgc.kata2.architecture.io.BarchartLoader;

public class ToggleBarchartCommand implements Command {
    private final BarchartLoader loader;
    private final BarchartDisplay display;
    private int i = 1;

    public ToggleBarchartCommand(BarchartLoader loader, BarchartDisplay display) {
        this.loader = loader;
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(loader.load(i++ % 2));
    }
}
