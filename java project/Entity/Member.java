package Entity;

public class Member {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String contact;
    private Book[] books;
    private int bookCount;

    public Member(String name, String contact) {
        this.name = name;
        this.contact = contact;
        this.id = ++Member.idCounter;
        this.books = new Book[5]; 
       this.bookCount = 0;
    }

    public int getID()
     {
        return id; 
    }

    public String getName()
     {
        return name;
    }

    public String getContact()
     {
        return contact;
    }

    public void setName(String name)
     {
        this.name = name;
    }

    public void setContact(String contact)
     {
        this.contact = contact;
    }

    public void addBook(Book book)
     {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
        }
    }

    public void removeBook(Book book)
     {
        for (int i = 0; i < bookCount; i++) {
            if (books[i] == book) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[bookCount - 1] = null;
                bookCount--;
                break;
            }
        }
    }
    public Book[] getBooks()
    {
        return books;
    }

    public String getMemberInfoAsString() {
        return name + ";" + contact;
    }
}