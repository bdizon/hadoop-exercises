import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util. *;
public class TourneyCount {
    public static void main(String[] args){
        String csvFile = "wta_matches_2018.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // create My HashTable Dictionary
            Hashtable<String, String> myDict = new Hashtable<String, String>();
            // get rid of first column
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] tourney = line.split(csvSplitBy);
                if(tourney[1].equals("Brisbane") || tourney[1].equals("Wimbledon") || tourney[1].equals("Sydney") || tourney[1].equals("Australian Open")){
                    // if dictionary doesn't have tournament then add
                    if(!myDict.containsKey(tourney[1])){
                        myDict.put(tourney[1], "1");
                    } else { 
                        // increment value in dictionary for tournament
                        String valueStr = myDict.get(tourney[1]);
                        int valueInt = Integer.parseInt(valueStr);
                        valueInt = valueInt + 1;
                        valueStr = String.valueOf(valueInt);
                        myDict.replace(tourney[1], valueStr);
                    }
                }
                
            }
            System.out.print("Number of matches per tournament: " + myDict);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}