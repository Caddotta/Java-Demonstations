/*
CIS 2168 003 Data Structures
Collin Addotta (tuk59900@temple.edu)

Assignment 5

ReadBinaryTreeTest Program

This program was made in NetBeans Version 8.0
 */


package assign5_template;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadBinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<String> binaryTree1 = new BinaryTree<>();
        BinaryTree<String> binaryTree2 = new BinaryTree<>();

        try {
            Scanner s = new Scanner(new File("WordBT_Data.txt"));

            binaryTree2 = BinaryTree.readBinaryTree(s);

            System.out.println(binaryTree2); //Print the binary tree for WordBT_Data.txt
            System.out.println("Preorder: \n"+binaryTree2.preOrderTraverse()+"\n"); //Print the preorder
            System.out.println("Postorder: \n"+binaryTree2.postOrderTraverse()+"\n"); //Print the postorder
            System.out.println("Inorder: \n"+binaryTree2.inOrderTraverse()+"\n"); //Print the inorder
            System.out.println("This tree's size: "+binaryTree2.size()); //Print this tree's size
            System.out.println("This tree's height: "+binaryTree2.height()); //Print this tree's height
            //---Assign 5 End -------//
                       
            
            //the code below was given in the lectures and will be helpful for you.
            
            
            //create a Scanner object that is associated with the file Fig_6_12.txt.
            Scanner input = new Scanner(new File("Fig_6_12.txt"));
            //call the static method readBinaryTree1 to read data in Fig_6_12.txt
            //   and construct the corresponding binary tree
            //   and assign the reference to this tree to binaryTree1.
            binaryTree1 = BinaryTree.readBinaryTree(input);
            //close the scanner object.
            input.close();
            //print the string, which is the preorder traversal sequence of data stored in binaryTree1.
            //System.out.println(binaryTree1);
        } catch (FileNotFoundException e) { //handle the case when Fig_6_12.txt is not found.
            e.printStackTrace();    //Print the error stack: this exception, and its backtrace for the cause of this exception.
            System.exit(1);         //terminate this program with the status code 1, indicating abnormal termination.
        }
    }

}


/*----Your output for the BT read from WordBT_Data.txt:
house
  dog
    cat
      null
      null
    null
  kiss
    null
    man
      null
      null

Preorder traversal:   house  dog  cat  kiss  man
Inorder traversal:   cat  dog  house  kiss  man
postorder traversal:   cat  dog  man  kiss  house
size: 5
height: 3

*/