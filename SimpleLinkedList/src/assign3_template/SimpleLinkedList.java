/*
CIS 2168 003 Data Structures
Collin Addotta (tuk59900@temple.edu)

Assignment 3

SimpleLinkedList Program
 */
package assign3_template;

public class SimpleLinkedList {
//This method first assesses if the first item matches the parameter
//Then proceeds onto assessing if such a value exists
    public boolean removeByValue(int item) {
        if (head.data == item) {
            head = head.next;
            return true;
        }
        Node current = head;
        Node temp = null;

        while (current != null && current.data != item) {
            temp = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        temp.next = current.next;
        size--;
        return true;
    }
//First ensures data entered in range
//Then it is assessed if the data is being added to front of list, and then if data is being added somewhere else
    public void add(int index, int item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        size++;
        Node current = new Node(item);
        if (index == 0) {
            current.next = head;
            head = current;
        } else {
            Node newNode = head;
            Node prev = null;
            for (int i = 0; i < index; i++) {
                prev = newNode;
                newNode = newNode.next;
            }
            prev.next = current;
            current.next = newNode;
        }
    }
//First handles exception
//Then runs logic
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        if (index < size - 1) {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            return current.data;
        }
        return Integer.MIN_VALUE;
    }
//Creates a Node referrencing LinkedList's head, and running until item is found or returns false
    public int indexOf(int item) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data == item) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }
//Creates a node referrencing LinkedList's head, then runs until item is found or returns false
    public boolean contains(int item) {

        Node current = head;
        while (current != null) {
            if (current.data == (item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
//Assesses if the list is empty, then proceeds to the method logic
    public int size() {
        int size = 0;
        Node n = head;
        if (n == null) {
            return 0;
        } else {
            while (n.next != null) {
                size++;
                n = n.next;
            }
            return size + 1;
        }
    }

    //-------End of Assign 3 --------/ 
    //Following code were covered in Lec#6. 
    //Don't change them.
    //Nested class Node, enclosing class: SimpleLinkedList
    private static class Node {

        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            next = null;
        }
    }

    //the reference to the first Node in this linked list.
    private Node head;
    //the size of this linked list
    private int size;

    //create an empty linked list
    public SimpleLinkedList() {
        head = null;
        size = 0;
    }

    //append newItem
    public boolean add(int newItem) {
        Node temp = new Node(newItem);
        if (head == null) { //empty list
            head = temp;
        } else { //non-empty list
            //locate last node
            Node current = head;    //start with the first node
            while (current.next != null) {  //check if current node is not the last node
                current = current.next;     //move on to the next node on the list
            }
            current.next = temp;    //append the new node immediately following the current node
        }
        size++;
        return true;
    }

    //return a string that contains all integers (in the original sequence) in the linked list.
    @Override
    public String toString() {
        String result = "";     //result string
        Node current = head;        //start with first Node
        while (current != null) {   //check if there is still nodes remaining
            result += current.data; //add the integer in current Node to the result string
            result += "-->";
            current = current.next; //move on to the next Node
        }
        return result;
    }
}
