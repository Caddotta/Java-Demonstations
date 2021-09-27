/*
CIS 2168 003 Data Structures
Collin Addotta (tuk59900@temple.edu)

Assignment 4

HiringApp Program
 */
package assign4_template;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import java.util.Scanner;

public class HiringApp {

    private static int current_input = -1;

    public static void main(String[] args) {
        
        //Data lists for applicants, current employees, and past employees.
        Queue<Person> applicantList = new ArrayDeque();
        ArrayDeque<Person> currentEmployee = new ArrayDeque();
        ArrayDeque<Person> pastEmployeeList = new ArrayDeque();
        
        //menu prompt
        System.out.println("(Please make a menu choice)\n" + mainMenu());
        
        while (current_input != 4) {
            try {
                getChoice(); //calls user to input valid entry
                switch (current_input) {
                    //Adds new Person object to applicantList from the called method.
                    case 1:
                        applicantList.add(getApplication());
                        break;
                    //Checks to see if there's any pastEmployees, and then if there's any applicants.
                    //If there's someone in pastEmployeeList, the most recently added person is rehired by popping the list
                    //If there's someone in applicantsList, the first person added is hired.
                    //The name of who was hired was printed if someone was hired, or otherwise a failure message is printed.
                    //
                    case 2: 
                        if (!pastEmployeeList.isEmpty()) {
                            System.out.println("Past Employee:" + pastEmployeeList.peek().getName() + " hired.");

                            currentEmployee.offer(pastEmployeeList.pop());
                        } else if (!applicantList.isEmpty()) {
                            System.out.println("Applicant:" + applicantList.peek().getName() + " hired.");

                            currentEmployee.offer(applicantList.poll());
                        } else {
                            System.out.println("There is nobody available to hire.");
                        }
                        break;
                    //Checks to see if the currentEmployeeList is empty.
                    //If it is not empty, the most recently hired Person is fired, and this Person is pushed into the pastEmployeesList stack.
                    case 3:
                        if (currentEmployee.isEmpty()) {
                            System.out.println("There is nobody available to fire.");
                        } else {
                            System.out.println("Employee: " + currentEmployee.peek() + " fired.");
                            pastEmployeeList.push(currentEmployee.pop());
                        }
                        break;
                    //This is the technically proper input to exit the menu. The program also exits if a non-integer value is entered, but it's indicated something went wrong.
                    case 4:
                        System.out.println("Program Ended.");
                        break;
                    //This is in the event something goes wrong.
                    default:
                        System.out.println("Non 1 - 4 value entered. Please reenter.");
                        break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("There was an error.");
            }
        }
    }
    //User is prompted to enter a number in accordance to the menu.
    //The current_input value is assigned to whatever input was entered.
    //If a non Int value was entered, an exception is catched and the program ends. I couldn't resolve how to prevent an infinite loop, so the program terminates.
    public static int getChoice() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Please enter a number 1 - 4:\t");
            int user = scan.nextInt();
            current_input = user;
            return user;
        } catch (InputMismatchException e) {
            System.out.println("There was a fatal error.");
            current_input = 4;
            return 0;
        }
    }
    //User enters in appropriate data fields. Another method, getSkillList is called.
    //For some reason it would bypass the prompt to input the data for the skill list, and calling a method forced that data to be entered.
    //Returns the new Person with their appropriate data fields.
    public static Person getApplication() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter applicant name:\t");
        String personName = scan.nextLine();

        System.out.println("Enter applicant's primary degree:\t");
        String personDegree = scan.nextLine();

        System.out.println("List the applicant skill amount:\t");
        int skillListSize = scan.nextInt();

        ArrayList<String> personSkillList = getSkillList(skillListSize);

        Person temp = new Person(personName, personDegree, personSkillList);
        System.out.println("Person added");
        return temp;
    }
    
    //Method to input data for a person's skillList
    public static ArrayList getSkillList(int size) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter skill:\t");
            String user_entry = scan.nextLine();
            temp.add(user_entry);
        }
        return temp;
    }
    //Method to print the Main Menu.
    public static String mainMenu() {
        return "1:\tAccept an Application\n"
                + "2:\tHire\n"
                + "3:\tFire\n"
                + "4:\tExit";
    }
}
