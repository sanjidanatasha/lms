package Classes;

public class Book {

    private String bookNamee;  
    private String bookAuthor;
    private String bookId;
    private String bookType;
         private static int bookCounter = 0;

    public Book(String bookId, String bookName, String bookAuthor, String bookType) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookId = bookId;
        this.bookType = bookType;
    
        bookCounter++;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }


    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookType() {
        return bookType;
    }

    
    public void showBookInfo() {
        System.out.println("Book Name : " + bookName);
        System.out.println("Book Author : " + bookAuthor);
        System.out.println("Book Id : " + bookId);
        System.out.println("Book Type : " + bookType);
        
    }

    

    public static void totalNumberOfUniqueBooks() {
        System.out.println("Total Number Of Unique Books : " + bookCounter);
    }

    public String getBookInfoAsString() {
        return bookId + ";" + bookName + ";" + bookAuthor + ";" + bookType;
    }

}
