import java.io.*;

public class Main {

    public static void main(String[] args) {

        ArgResolver argResolver = new ArgResolver(args);

        try (BufferedReader reader = argResolver.getReader();
             BufferedWriter writer = argResolver.getWriter()){

            WordParcer parcer = new FileWordParcer(reader);
            DataWriter dataWriter = new CSVDataWriter(writer);
            WordCounter wordCounter = new WordCounter(parcer, dataWriter);
            wordCounter.countWords();

        }catch(IOException exc){
            System.err.println(exc.getMessage());
        }
    }
}