package FileIO;

import java.io.*;
import java.util.Scanner;

import Classes.Book;
import Classes.BookList;
import Classes.MemberList;

public class FileIO {

    private static String BookFilePath = "./Files/books.txt";
    private static String MemberFilePath = "./Files/members.txt";

    public static void loadBooksFromFile(BookList bookList) {
        try {
            Scanner sc = new Scanner(new File(FileIO.BookFilePath));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");

                String bookName = data[1];
                String bookAuthorName = data[2];
                String bookType = data[3];
                int copy = Integer.parseInt(data[4]);
                String image = data[5];

                Book b = new Book(bookName, bookAuthorName);
                bookList.addBook(b);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Cannot Read the File");
            e.printStackTrace();
        }
    }

    public static void saveBooksInFile(BookList bookList) {
        try {
            FileWriter writer = new FileWriter(FileIO.BookFilePath);
            Book books[] = bookList.books;

            for (int i = 0; i < books.length; i++) {
                if (books[i] != null) {
                    writer.write(books[i].getBookInfoAsString() + "\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Cannot Write in File");
        }
    }

    public static void loadMembersFromFile(MemberList memberList) {
        try {
            Scanner sc = new Scanner(new File(FileIO.MemberFilePath));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");

                String bookName = data[1];
                String bookAuthorName = data[2];
                String bookType = data[3];
                int copy = Integer.parseInt(data[4]);
                String image = data[5];

                Book b = new Book(bookName, bookAuthorName);
                memberList.addMember(b);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Cannot Read the File");
            e.printStackTrace();
        }
    }

    public static void saveBooksInFile(BookList bookList) {
        try {
            FileWriter writer = new FileWriter(FileIO.BookFilePath);
            Book books[] = bookList.books;

            for (int i = 0; i < books.length; i++) {
                if (books[i] != null) {
                    writer.write(books[i].getBookInfoAsString() + "\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Cannot Write in File");
        }
    }
}
