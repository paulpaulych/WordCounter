import java.io.IOException;
import java.util.*;

class WordCounter {
    private WordParcer wordParcer;
    private DataWriter dataWriter;

    WordCounter(WordParcer wordParcer, DataWriter dataWriter){
        this.dataWriter = dataWriter;
        this.wordParcer = wordParcer;
    }

    void countWords() throws IOException {
        Map<String, Integer> map = new HashMap<>();
        String word = wordParcer.getWord();
        int totalWords = 0;
        while(word != null){
            totalWords++;
            map.put(word, map.containsKey(word) ? map.get(word) + 1:  1);
            word = wordParcer.getWord();
        }

        List<Map.Entry<String, Integer>> dataList = new ArrayList<>(map.entrySet());
        dataList.sort((o1, o2) -> {
                    if (o2.getValue().equals(o1.getValue()))
                        return o1.getKey().compareTo(o2.getKey());
                    return o2.getValue().compareTo(o1.getValue());
                }
        );

        for(Map.Entry<String, Integer> data: dataList){
            dataWriter.writeData(
                    data.getKey(),
                    data.getValue().toString(),
                    Long.toString(Math.round(data.getValue()/(double)totalWords*100))+'%');
        }
    }
}
