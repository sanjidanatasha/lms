package Classes;

public class Member {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String contact;
    private Book[] books;

    public Member(String name, String contact) {
        this.name = name;
        this.contact = contact;
        this.id = ++Member.idCounter;
    }

    // public int getID(){

    // }

    // public String getName(){

    // }

    // public String getContact(){

    // }

    // public void setName(String name){

    // }

    // public void setContact(String contact){

    // }

    // addBook(Book book)){

    // }

    // removeBook(Book book){

    // }
    public String getMemberInfoAsString() {
        return name + ";" + contact;
    }

}
