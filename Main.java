import Classes.BookList;
import Classes.MemberList;
import Gui.Library;

public class Main {
    public static void main(String[] args) {
        BookList books = new BookList(100);
        MemberList members = new MemberList(100);

        // Create DB class to Save Read books from file

        new Library(books, members);
    }
}
// jdhdkfhfjfjfb