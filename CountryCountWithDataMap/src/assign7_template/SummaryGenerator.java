/*
CIS 2168 003 Data Structures
Collin Addotta (tuk59900@temple.edu)

Assignment 7

SummaryGenerator program

MADE WITH NETBEANS IDE 8.2
 */
//This class generates the data summary based on the data in the file purchases.csv
//and show such summaries. It then counts the reappearance of unique countries.
package assign7_template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

public class SummaryGenerator {

    private final String COMMA_DELIMITER = ",";

    Map<String, Integer> countsByCountryMap; //data field named countsByCountryMap, a Map data structure.

    //no-argument constructor, creates objects for empty data summary map 
    public SummaryGenerator() {
        countsByCountryMap = new HashMap<>();         // HashMap
        //countsByCountryMap = new TreeMap<>();         // TreeMap
    }

    public void createCountsByCountry(BufferedReader br) {
        List<String> purchase = new ArrayList<>();
        try {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(COMMA_DELIMITER);
                purchase = Arrays.asList(fields);
                //System.out.println(purchase);
                String country = (purchase.get(7)); //get the country from the purchase ArrayList
                Integer count = countsByCountryMap.get(country);
                if (count == null) {
                    count = 1; //add the new summary entry: country, 1 into the data summary map: countsByCountry.
                } else {
                    count++; //increase the country's count by 1
                }
                countsByCountryMap.put(country, count); //write the new summary: country, updated-count into countsByCountry.            
            }
        } catch (IOException ioe) {
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        } catch (PatternSyntaxException pse) {
            System.out.println("pattern specification error.");
            pse.printStackTrace();
            System.exit(1);
        }
    }

    //Method that prints out the country's count.
    public void showCountsByCountry() {
        System.out.println("Country\t\tCount");//Header
        printNChars('-', 20);                  //Header underline

        for (Map.Entry<String, Integer> k : countsByCountryMap.entrySet()) { //Parse through each map entry
            System.out.print(k.getKey() + "\t");                             //Print out the key of each map, the country
            printNChars('*', k.getValue());                                  //Call printNChars for the count quantity
        }
    }

    //Prints out a single character for a specific quantity
    private void printNChars(char ch, int count) {                          
        int i = count;
        while (i >= 0) {
            System.out.print(ch);
            i--;
        }
        System.out.println();
    }
}
