package Entity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Book extends BookName {
    private int id;
    private String author;
    private File file;
    private FileWriter fwriter;

    public Book(int id, String name, String author) {
        super(name);
        this.author = author;
        this.id = id;
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

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setAuthor(String author) {
        this.author = author;
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

            // LocalDateTime myDateObj = LocalDateTime.now();
            // DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a,
            // dd/MM/yyyy");
            // String timeAndDate = myDateObj.format(myFormatObj);

            fwriter = new FileWriter(file, isAppend);
            fwriter.write(this.id + "," + this.name + "," + this.author);

            fwriter.flush();
            fwriter.close();
        }

        catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to file!");
        }
    }
}
