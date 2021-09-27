package assign2_template;

/*
CIS 2168 003 Data Structures
Collin Addotta (tuk59900@temple.edu)

Assignment 2

VideoGame Program
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

//VideoGame Class. Includes datasets, constructors, getters, setters, an overrided toString method, and an Overrided equals method.
public class VideoGame {

    //Data fields for the VideoGame object
    private String title;
    private String developer;    
    private String platforms[];
    private LocalDate releaseDate;
    
    //No Argument Constructor
    public VideoGame() {
    }
    //Data fields constructor
    public VideoGame(String title, String developer, String[] platforms, LocalDate releaseDate){
        this.title = title;
        this.developer = developer;
        this.platforms = platforms;
        this.releaseDate = releaseDate;
    }

    //Getters
    public String getTitle(){
        return title;
    }
    public String getDeveloper(){
        return developer;
    }
    public String[] getPlatforms(){
        return platforms;
    }
    public LocalDate getReleaseDate(){
        return releaseDate;
    }
    
    //Setters
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public void setDeveloper(String newDeveloper){
        this.developer = newDeveloper;
    }
    public void setPlayforms(String[] newPlatforms){
        this.platforms = newPlatforms;
    }
    public void setReleaseDate(LocalDate newReleaseDate){
        this.releaseDate = newReleaseDate;
    }
    
    //Overrided toString. A DateTimeFormatter is declared to format the value returned from getReleaseDeate.
    @Override
    public String toString() {
        DateTimeFormatter monthDayYear = DateTimeFormatter.ofPattern("M/d/yyyy");
        return "Game Title:\t"+getTitle()
                +"\nLead Developer:\t"+getDeveloper()
                +"\nPlatforms:\t"+Arrays.toString(getPlatforms())
                +"\nReleaseDate:\t"+monthDayYear.format(getReleaseDate());
    }
    
    //Overrided equals method. Only assesses equivalency for the titles of this object compared with another object.
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null){
            return false;
        }
        
        if (this == otherObject){
            return true;
        }
        
        if (this.getClass() != otherObject.getClass()){
            return false;
        }
        VideoGame otherVideoGame = (VideoGame) otherObject;
        return this.title.equals(otherVideoGame.title);
    }    
}