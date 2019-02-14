import java.io.IOException;

public interface DataWriter {
    void writeData(String... dataToWrite) throws IOException;
}
