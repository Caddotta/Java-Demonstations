/*
CIS 2168 003 Data Structures
Collin Addotta (tuk59900@temple.edu)

Assignment 4

Person Program
 */
package assign4_template;

import java.util.ArrayList;

public class Person {
    //data fields
    private String name;
    private String degree;
    private ArrayList<String> skillList;
    public Person(){
    }
    //argument constructor
    public Person(String name, String degree, ArrayList<String> skillList){
        this.name = name;
        this.degree = degree;
        this.skillList = skillList;
    }
    //getters
    public String getName(){
        return this.name;
    }
    public String getDegree(){
        return this.degree;
    }
    public ArrayList<String> getSkillList(){
        return this.skillList;
    }
    //setters
    public void setName(String newName){
        this.name = newName;
    }
    public void setDegree(String newDegree){
        this.degree = newDegree;
    }
    public void setSkillList(ArrayList<String> newSkillList){
        this.skillList = newSkillList;
    }
    //Overrided toString method.
    @Override
    public String toString(){
        return "Name:\t"      +name
            +"\nDegree:\t"    +degree
            +"\nSkills:\t"    +skillList;
    }
}