import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util. *;
public class PlayerCount {
    public static void main(String[] args){
        String csvFile = "players.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // create My HashTable Dictionary
            Hashtable<String, String> myDict = new Hashtable<String, String>();
            // get rid of first column
            line = br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(csvSplitBy);
                
                // not all rows have all 6 values 
                String unknownCountry = "UNKNOWN COUNTRY";
                if(country.length == 6){
                    
                    // if dictionary doesn't have country then add
                    if(!myDict.containsKey(country[5])){
                        myDict.put(country[5], "1");
                    } else {
                        // increment value in dictionary for country
                        String valueStr = myDict.get(country[5]);
                        int valueInt = Integer.parseInt(valueStr);
                        valueInt = valueInt + 1;
                        valueStr = String.valueOf(valueInt);
                        myDict.replace(country[5], valueStr);
                    }
                } else { // country column not available
                    if(!myDict.containsKey(unknownCountry)){
                        myDict.put(unknownCountry, "1");
                    } else {
                        // increment value in dictionary for country
                        String valueStr = myDict.get(unknownCountry);
                        int valueInt = Integer.parseInt(valueStr);
                        valueInt = valueInt + 1;
                        valueStr = String.valueOf(valueInt);
                        myDict.replace(unknownCountry, valueStr);
                    }
                }

            }
            System.out.print("The players per country: " + myDict);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}