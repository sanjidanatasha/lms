package Entity;

public class BookList {
    private Book[] books;
    private int bookCount;

    public BookList(int maxCount) {
        this.books = new Book[maxCount];
        this.bookCount = 0;
    }

    public Book[] getBooks() {
        return books;
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

    public String displayAllBooks() {
        String printString = "";
        if (bookCount == 0) {
            System.out.println("No books available in the library.");
            printString += "No books available in the library.";
            return printString;
        }

        System.out.println("\n=== Library Books ===");
        printString += "\n=== Library Books ===\n";
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            System.out.println("ID: " + book.getID() +
                    ", Title: " + book.getName() +
                    ", Author: " + book.getAuthor() +
                    ", Genre: " + book.getGenre());
            printString += "ID: " + book.getID() +
                    ", Title: " + book.getName() +
                    ", Author: " + book.getAuthor() +
                    ", Genre: " + book.getGenre() + "\n";
        }
        return printString;
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