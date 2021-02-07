import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class WordCount {
    public static void main(String[] args){
        String csvFile = "players.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int sumWords = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(csvSplitBy);
                //  find length of array
                int numWordsLine = country.length;
                // sum up all words to file
                sumWords = sumWords + numWordsLine;
            }
            System.out.print("Total of words in file is " + sumWords);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}