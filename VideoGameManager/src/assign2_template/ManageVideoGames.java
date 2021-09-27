package assign2_template;

/*
CIS 2168 003 Data Structures
Collin Addotta (tuk59900@temple.edu)

Assignment 2

ManageVideoGames Program
 */
import java.time.LocalDate;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

/*
This class includes a main method, a method that returns a Menu, a method that returns a VideoGame object based on inputs, 
a method that removes a VideoGame object based based on the input of a title, a method that prints all VideoGame objects within a linked list,
and a method that returns the VideoGame object with the most recent releaseDate data field.
 */
public class ManageVideoGames {

    /*
    Main method. A new LinkedList is constructed for VideoGame objects. 
    The mainMenu method is called, printing the input options available to the user, and then the user is prompted to enter a value.
    A while loop parses until the input value is 5, the input entered to end the program. The loop runs through conditional statements to assess if 
    the value is either out of range or a of 1 through 4.
    
    Every valid value calls to a different method for the task specified on the printed menu.
     */
    public static void main(String[] args) {

        List<VideoGame> gamesLList = new LinkedList<>(); // Newly constructed LinkedList for VideoGame type objects.

        Scanner s = new Scanner(System.in);

        System.out.println(mainMenu() + "\nPlease make a choice:\t");
        int user = s.nextInt();

        while (user != 5) {
            if (user > 5 || user < 1) {
                System.out.println("Input out of range.\nPlease Enter a new Input:\t");
            } else if (user == 1) {
                gamesLList.add(choice1()); //Adds the returned value of method choice1 to the LinkedList.
            } else if (user == 2) {
                gamesLList = (choice2(gamesLList)); //Reassigns the value of the LinkedList to the returned value of method choice2, using the LinkedList as its parameter.
            } else if (user == 3) {
                choice3(gamesLList); //Calls to the method of choice3, using the LinkedList as its parameter.
            } else if (user == 4) {
                System.out.println(choice4(gamesLList)); //Calls to the method of choice4, using the LinkedList as its parameter.
            }
            user = s.nextInt(); //Prompts for another input once the method is completed
        }
        System.out.println("You have exited the program."); //Only prints once the user enters 5 and only 5.
    }

    //Method to display all input options to the user.
    public static String mainMenu() { 
        return "*****Welcome to Video Game Management Tool!*****\n"
                + "1.\tAdd a new game\n"
                + "2.\tRemove an existing game\n"
                + "3.\tDisplay the game in the order they were inserted\n"
                + "4.\tFind games with latest release\n"
                + "5.\tExit";
    }

    //Takes in all values through a locally constructed scanner.
    //Variables are assigned to the user's input, and then passed into a newly constructed VideoGame object.
    //The finalized VideoGame object is returned.
    public static VideoGame choice1() {
        System.out.println("Option 1 Selected: Add New Game");
        Scanner s = new Scanner(System.in);
        int i = 0;

        System.out.println("Enter Game Title:\t");
        String gameTitle = s.nextLine();

        System.out.println("Enter Game Developer:\t");
        String gameDeveloper = s.nextLine();

        System.out.println("Enter amount of publishers supported: ");
        int publisherLength = s.nextInt();

        String[] gamePublisher = new String[publisherLength];

        //Prompts the user for each publisher to be assigned in this VideoGame object's array.
        for (String user_entry : gamePublisher) {
            System.out.println("Enter publisher #" + (i + 1) + ":\t");
            user_entry = s.next();
            gamePublisher[i] = user_entry;
            i++;
        }

        //First takes in all values of the LocalDate separately, and then assigns them to a variable to be passed into this VideoGame object's releaseDate datafield.
        System.out.println("Enter release date year:\t");
        int year = s.nextInt();
        System.out.println("Enter release date month:\t");
        int month = s.nextInt();
        System.out.println("Enter release date day:\t");
        int day = s.nextInt();
        LocalDate releaseDate = LocalDate.of(year, month, day);

        //Newly constructed VideoGame object with all datafields being assigned by user input.
        VideoGame temp = new VideoGame(gameTitle, gameDeveloper, gamePublisher, releaseDate);
        System.out.println("Task Completed. Please select another menu option:\t"); //Confirmation to the user that the task is finished.
        return temp; //Returned value to be used in the main method.
    }

    //Takes in a VideoGame type LinkedList, and then Constructs a temporary VideoGame object.
    //Prompts a user for the title of the VideoGame object they want to remove,
    //and compares that input to all VideoGame objects in the LinkList passed in the paramter.
    public static List<VideoGame> choice2(List<VideoGame> tempList) {
        Scanner s = new Scanner(System.in);
        int i = 0;

        System.out.println("Option 2 Selected: Remove a VideoGame");
        System.out.println("To remove the videogame, please Enter the videogame's title:\t");

        String user = s.next();
        VideoGame temp = new VideoGame(user, null, null, null);
        
        //Removes the specified videogame under the condition it matches the user's case sensitive input.
        for (VideoGame v : tempList) {
            if (temp.getTitle().equals(v.getTitle())) {
                tempList.remove(v);
                System.out.println("Videogame found");
            } else {
                System.out.println("Videogame not found");
            }
        }
        System.out.println("Task Completed. Please select another menu option:\t");
        return tempList;
    }

    //Passed the LinkedList as a parameter, and then prints the toString method of each object in the list.
    public static void choice3(List<VideoGame> tempList) {
        for (VideoGame i : tempList) {
            System.out.println("VideoGame No. " + ((tempList.indexOf(i)) + 1)
                    + "\n--------------------------------"
                    + "\n" + i.toString()
                    + "\n--------------------------------");
        }
    }

    //Constructs a temporary VideoGame with no datafields, and then assigns variable temp to the first value LinkedList 0 under the condition the list
    //is not empty. Temp is compared with all VideoGame objects' release dates within the list until a newer releaseDate data field is found. Temp is
    //then reassigned to the VideoGame object of the newer release date. The videoGame object of the newest releaseDate data field is returned.
    public static String choice4(List<VideoGame> tempList) {

        VideoGame temp = new VideoGame();
        if (tempList.get(0) != null){
            temp = tempList.get(0);
        } else {
            return temp.toString();
        }
        for (VideoGame v : tempList) {
            if (v.getReleaseDate().isAfter(temp.getReleaseDate())) {
                System.out.println("Earlier date detected."
                        + "\n" + temp.getTitle() + " will be replaced by:\t" + v.getTitle());
                temp = v;
            }
        }
        return temp.toString();
    }
}
