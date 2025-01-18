package software.ulpgc.kata4.io;

import software.ulpgc.kata4.model.Title;

import java.io.IOException;
import java.util.List;

public interface TitlesReader {
    List<Title> read() throws IOException;
}