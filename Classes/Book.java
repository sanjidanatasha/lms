package Classes;

public class Book {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.id = ++Book.idCounter;
    }

    // public int getID(){

    // }

    // public String getName(){

    // }

    // public String getAuthor(){

    // }

    // public void setName(String name){

    // }

    // public void setAuthor(String contact){

    // }

    public String getBookInfoAsString() {
        return name + ";" + author;
    }

}
