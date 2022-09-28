import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;

public class FileReader {
    public static ArrayList<String> readFile(String fileURL) throws IOException {
        // Instantiating the URL class
        URL url = new URL(fileURL);

        // Retrieving the contents of the specified page
        Scanner sc = new Scanner(url.openStream());

        ArrayList<String> wordsList = new ArrayList<>();

        while (sc.hasNext()) {
            String nextWord = sc.next();
            nextWord = nextWord.replaceAll("\\.", "");
            nextWord = nextWord.replaceAll("\\;", "");
            nextWord = nextWord.replaceAll("\\?", "");
            wordsList.add(nextWord);
            // System.out.println(sc.next());
        }
        sc.close();
        return wordsList;

        // Removing the HTML tags
        //result = result.replaceAll("<[^>]*>", "");
    }
}
