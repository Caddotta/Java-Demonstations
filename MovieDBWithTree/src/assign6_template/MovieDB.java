/*
CIS 2168 003 Data Structures
Collin Addotta (tuk59900@temple.edu)

Assignment 6

MovieDB Program

MADE WITH NETBEANS IDE 8.2
 */
package assign6_template;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MovieDB {

    private List<Movie> movieDB;

    private static final int INITIAL_CAPACITY = 20;

    private static final int STARTER_MOVIEDB_SIZE = 15;

    //Create the titleIndex data field to be used for indexes
    TreeSet<Object> newSet = new TreeSet();
    Set<IndexEntry> titleIndex = new TreeSet();

    //Constructor
    public MovieDB() {
        movieDB = new ArrayList<Movie>();
        titleIndex = new TreeSet<IndexEntry>();
    }

   public void createStartMovieDB() {
        Random randNumGenerator = new Random();
        HashSet<Integer> h = new HashSet<Integer>();
        while (h.size() != STARTER_MOVIEDB_SIZE) {
            int rand = randNumGenerator.nextInt(STARTER_MOVIEDB_SIZE);
            if (h.add(rand)) {
                int year = (randNumGenerator.nextInt(30) + 31); // Variable for randomized years between 1990 and 2021
                // Added because the assignment called for randomized values
                // But not sure if necessary
                Movie temp = new Movie("Title" + rand, "Director" + rand, year);
                movieDB.add(temp);
            }
        }
    }

    public void showMovieDB() {
        System.out.println("Movie Database:\n"
                + "Title\t\tDirector\tYear\n"
                + "-------------------------------------");
        for (Movie mov : movieDB) {
            System.out.println(String.format("%s\t\t %s\t %d", mov.getTitle(), mov.getDirector(), mov.getYear()));
        }
        System.out.println();
    }

    public void createIndex() {
        int index = 0;
        for (Movie m : movieDB) {
            IndexEntry temp = new IndexEntry(m.getTitle(), index);
            titleIndex.add(temp);
            index++;
        }
    }

    //Print a header, and then print the properly formatted information for each IndexEntry object
    public void showIndex() {
        System.out.println("Title Index:\n"
                + "Title\t\tTitle Location\n"
                + "--------------------------------");
        for (IndexEntry ie : titleIndex) {

            System.out.println(
                    String.format("%s\t\t %d", ie.getTitle(), ie.getLocation()));
        }
    }

    public static void main(String[] args) {
        //create a random number generator
        Random randNumGenerator = new Random();
        //get a random integer between 0 (inclusive) and 200 (exclusive)
        int randNumber = randNumGenerator.nextInt(200);
        System.out.println(randNumber);

        randNumber = randNumGenerator.nextInt(200);
        System.out.println(randNumber);
    }
}
