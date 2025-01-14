package dis.ulpgc.kata4.architecture.io;

import dis.ulpgc.kata4.architecture.model.Barchart;

public interface BarchartLoader {
    Barchart load(int id);
}
