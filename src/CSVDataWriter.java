import java.io.BufferedWriter;
import java.io.IOException;

public class CSVDataWriter
    implements DataWriter{
    private BufferedWriter writer;

    CSVDataWriter(BufferedWriter writer){
        this.writer = writer;
    }
    @Override
    public void writeData(String...dataToWrite) throws IOException {
        StringBuilder newLine = new StringBuilder();
        for(String data: dataToWrite){
            newLine.append(data + ", ");
        }
        newLine.delete(newLine.length() - 2, newLine.length());
        newLine.append('%');
        writer.write(newLine.toString(), 0, newLine.length()) ;
        writer.newLine();
    }
}
