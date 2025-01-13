package dis.ulpgc.kata2.architecture.io;

import dis.ulpgc.kata2.architecture.model.Barchart;

public interface BarchartLoader {
    Barchart load(int id);
}
