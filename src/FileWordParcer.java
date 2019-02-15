import java.io.BufferedReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileWordParcer
    implements WordParcer{

    private Scanner scanner;

    FileWordParcer(BufferedReader reader){
        Pattern pattern = Pattern.compile("[^а-яА-Яa-zA-Z0-9]+");
        scanner = new Scanner(reader).useDelimiter(pattern);
    }

    @Override
    public String getWord(){
        if(scanner.hasNext()){
            return scanner.next();
        }
        return null;
    }
}