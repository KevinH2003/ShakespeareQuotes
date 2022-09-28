import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ShakespeareQuotes {
    public static void main(String[] args) throws IOException{
        ArrayList<String> wordsList = FileReader.readFile("https://www.gutenberg.org/files/100/100-0.txt");
        ArrayList<ArrayList<String>> validQuotes = new ArrayList<>();

        returnQuotes(wordsList, validQuotes);
        for (ArrayList<String> a : validQuotes){
            for (String s : a){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void returnQuotes(List<String> wordsList, List<ArrayList<String>> returnedQuotes){
        ArrayList<String> ongoing = new ArrayList<>();
        int[] stringLengths = {4, 5, 7, 6, 6, 6};
        int quoteLength = stringLengths.length;

        for (int i = 0; i < quoteLength; i++){
            ongoing.add(wordsList.get(i));
        }
        for (int i = quoteLength; i < wordsList.size(); i++){
            boolean matches = true;
            for (int j = 0; j < stringLengths.length; j++){
                if (ongoing.get(j).length() != stringLengths[j]){
                    matches = false;
                    break;
                }
            }
            if (matches == true){
                returnedQuotes.add(new ArrayList<String>(ongoing));
            }
            ongoing.remove(0);
            ongoing.add(wordsList.get(i));
        }
    }
}
