//File: IndexEntry.java
//You don't need to change this class.
//The class for an index entry in the index tree for the Movie Database.

package assign6_template;

public class IndexEntry implements Comparable<IndexEntry> {
    
    @Override
    public int compareTo(IndexEntry other) {
        return title.compareTo(other.title);
    }

    private String title;
    private int location; //index in the list

    public String getTitle() {
        return title;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public IndexEntry(String title, int location) {
        this.title = title;
        this.location = location;
    }

    @Override
    public String toString() {
        return "IndexEntry{" + "title=" + title + ", location=" + location + '}';
    }

    
}
