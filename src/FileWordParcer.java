import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWordParcer
    implements WordParcer{

    private BufferedReader reader;
    private List<String> wordsInCurLine;

    FileWordParcer(BufferedReader reader){
        this.reader = reader;
        wordsInCurLine = new LinkedList<>();
    }

    @Override
    public String getWord() throws IOException {
        while(wordsInCurLine.isEmpty()){
            String newLine = reader.readLine();
            while("".equals(newLine)){
                newLine = reader.readLine();
            }
            if(newLine == null){
                return null;
            }
            Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z0-9]+");
            Matcher matcher = pattern.matcher(newLine);
            while(matcher.find()){
                wordsInCurLine.add(matcher.group());
            }
        }
        return wordsInCurLine.remove(0);
    }
}