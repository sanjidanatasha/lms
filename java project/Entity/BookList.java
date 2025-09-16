package Entity;

public class BookList {
    private Book[] books;
    private int bookCount;


    public BookList(int maxCount) {
        this.books = new Book[maxCount];
        this.bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Book added successfully: " + book.getName());
        } else {
            System.out.println("Cannot add book. Book list is full!");
        }
    }

    public void removeBook(int bookId) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getID() == bookId) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[bookCount - 1] = null;
                bookCount--;
                found = true;
                System.out.println("Book with ID " + bookId + " removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    public void IssueBook(Member member, Book book) {
        boolean bookExists = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getID() == book.getID()) {
                bookExists = true;
                break;
            }
        }
        
        if (!bookExists) {
            System.out.println("Book not available in the library.");
            return;
        }
        
        
        member.addBook(book);
        removeBook(book.getID());
        System.out.println("Book '" + book.getName() + "' issued to " + member.getName());
    }

    public void ReturnBook(Member member, Book book) 
    {
        boolean hasBook = false;
        Book[] memberBooks = member.getBooks();
        for (Book b : memberBooks) {
            if (b != null && b.getID() == book.getID()) {
                hasBook = true;
                break;
            }
        }
        
        if (!hasBook) {
            System.out.println(member.getName() + " does not have this book.");
            return;
        }
        
        
        member.removeBook(book);
        addBook(book);
        System.out.println("Book '" + book.getName() + "' returned by " + member.getName());
    }

    public Book findBookById(int bookId) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getID() == bookId) {
                return books[i];
            }
        }
        return null;
    }

    public Book findBookByName(String bookName) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getName().equalsIgnoreCase(bookName)) {
                return books[i];
            }
        }
        return null;
    }

    public void displayAllBooks() {
        if (bookCount == 0) {
            System.out.println("No books available in the library.");
            return;
        }
        
        System.out.println("\n=== Library Books ===");
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            System.out.println("ID: " + book.getID() + 
                             ", Title: " + book.getName() + 
                             ", Author: " + book.getAuthor());
        }
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getMaxCapacity() {
        return books.length;
    }

    public boolean isFull() {
        return bookCount >= books.length;
    }

    public boolean isEmpty() {
        return bookCount == 0;
        
    }
}