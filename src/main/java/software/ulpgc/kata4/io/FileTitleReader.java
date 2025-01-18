package software.ulpgc.kata4.io;

import software.ulpgc.kata4.model.Title;
import software.ulpgc.kata4.model.TitleDeserializer;

import java.io.*;

public class FileTitleReader implements TitleReader {
    private final BufferedReader reader;
    private final TitleDeserializer deserializer;

    public FileTitleReader(File file, TitleDeserializer deserializer) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        this.deserializer = deserializer;
        reader.readLine();
    }

    @Override
    public Title read() throws IOException {
        return deserialize(reader.readLine());
    }

    private Title deserialize(String line) {
        return line != null ? deserializer.deserialize(line) : null;
    }

    @Override
    public void close() throws Exception {
        this.reader.close();
    }
}
