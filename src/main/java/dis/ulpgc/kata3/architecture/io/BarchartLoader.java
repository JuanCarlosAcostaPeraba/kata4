package dis.ulpgc.kata3.architecture.io;

import dis.ulpgc.kata3.architecture.model.Barchart;

public interface BarchartLoader {
    Barchart load(int id);
}
