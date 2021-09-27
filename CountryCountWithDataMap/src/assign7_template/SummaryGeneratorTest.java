/*
CIS 2168 003 Data Structures
Collin Addotta (tuk59900@temple.edu)

Assignment 7

SummaryGeneratorTest program

MADE WITH NETBEANS IDE 8.2
 */
//This class tests the implementation of the SummaryGenerator class
package assign7_template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SummaryGeneratorTest {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("purchases.csv")); //create a BufferedReader to read from file purchases.csv

            SummaryGenerator sg1 = new SummaryGenerator(); //  create an object of SummaryGenerator

            sg1.createCountsByCountry(br); //call createCountsByCountry method and pass BufferedReader object br to this method

            sg1.showCountsByCountry(); //call showCountsByCountry  method, which displays the summary        

        } catch (IOException ioe) {
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        }
    }

}
