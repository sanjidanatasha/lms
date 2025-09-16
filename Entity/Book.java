package Entity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Book extends BookName {
    private int id;
    private String author;
    private String genre;
    private File file;
    private FileWriter fwriter;

    public Book(int id, String name, String author, String genre) {
        super(name);
        this.author = author;
        this.id = id;
        this.genre = genre;
    }

    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBookInfoAsString() {
        return getName() + ";" + author;
    }

    public void insertInfo() {
        insertInfo(true);
    }

    public void insertInfo(boolean isAppend) {
        try {
            file = new File(".\\userdata.txt");

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            fwriter = new FileWriter(file, isAppend);
            fwriter.write(this.id + "," + this.name + "," + this.author + "," + this.genre + '\n');

            fwriter.flush();
            fwriter.close();
        }

        catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to file!");
        }
    }
}
