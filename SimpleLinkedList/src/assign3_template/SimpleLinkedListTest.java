/*
CIS 2168 003 Data Structures
Collin Addotta (tuk59900@temple.edu)

Assignment 3

SimpleLinkedListTest Program
 */
package assign3_template;

public class SimpleLinkedListTest {

    public static void main(String[] args) {

        SimpleLinkedList numbers = new SimpleLinkedList();

        System.out.println(numbers.size()); // 0

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println(numbers);

        numbers.add(0, 30);
        numbers.add(1, 50);

        System.out.println(numbers);//30 and 50 added to start of 

        System.out.println(numbers.size()); // 5

        System.out.println(numbers.contains(20)); // true
        System.out.println(numbers.contains(21)); // false

        System.out.println(numbers.indexOf(20)); // 1
        System.out.println(numbers.indexOf(21)); // -1

        System.out.println(numbers.get(3));
        //System.out.println(numbers.get(100)); Throws Exception

        numbers.removeByValue(30);

        System.out.println(numbers);//First instance of 30 removed from list
    }

}
