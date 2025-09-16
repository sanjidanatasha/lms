package Frame;

import Entity.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.io.IOException;

public class FrameSample extends JFrame implements MouseListener, ActionListener {
    private Font f1, f2;
    private Color c1, c2;
    private JPanel panel;
    private JLabel label1, label2, label3, label4, label5, label6;
    private JTextField tf1, tf2, tf3, tf4, tf5;
    private JButton bt1, bt2, bt3, bt4;
    private JComboBox<String> jb1;
    private JTextArea ta1;
    private BookList bookList;

    public FrameSample() {
        super("LIBRARY MANAGEMENT SYSTEM");
        super.setBounds(500, 100, 900, 980);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bookList = new BookList(100);

        panel = new JPanel();
        panel.setLayout(null);
        c2 = new Color(204, 255, 204);
        panel.setBackground(c2);

        f1 = new Font("Cambria", Font.BOLD, 30);
        f2 = new Font("Cambria", Font.BOLD, 20);
        c1 = new Color(255, 0, 0);

        label1 = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        label1.setBounds(250, 0, 500, 40);
        label1.setFont(f1);
        label1.setForeground(c1);
        panel.add(label1);

        label2 = new JLabel("Book's Name:");
        label2.setBounds(20, 50, 150, 30);
        label2.setFont(f2);
        panel.add(label2);

        tf1 = new JTextField();
        tf1.setBounds(220, 50, 150, 30);
        tf1.setFont(f2);
        panel.add(tf1);

        label3 = new JLabel("Book's ID:");
        label3.setBounds(20, 90, 200, 30);
        label3.setFont(f2);
        panel.add(label3);

        tf2 = new JTextField();
        tf2.setBounds(220, 90, 150, 30);
        tf2.setFont(f2);
        panel.add(tf2);

        label4 = new JLabel("Genre:");
        label4.setBounds(20, 130, 150, 30);
        label4.setFont(f2);
        panel.add(label4);

        String Genres[] = new String[] { "", "Fiction", "Thriller", "Romantic", "Horror", "ScI-FIC" };
        jb1 = new JComboBox(Genres);
        jb1.setBounds(220, 130, 150, 30);
        jb1.setFont(f2);
        panel.add(jb1);

        label5 = new JLabel("Author:");
        label5.setBounds(20, 170, 150, 30);
        label5.setFont(f2);
        panel.add(label5);

        tf3 = new JTextField();
        tf3.setBounds(220, 170, 270, 100);
        tf3.setFont(f2);
        panel.add(tf3);

        // label6 = new JLabel("issue by name");
        // label6.setBounds(20, 210, 150, 30);
        // label6.setFont(f2);
        // panel.add(label6);

        // tf4 = new JTextField();
        // tf4.setBounds(220, 210, 270, 100);
        // tf4.setFont(f2);
        // panel.add(tf4);

        bt1 = new JButton("Delete by ID");
        bt1.setBounds(350, 700, 150, 30);
        bt1.setFont(f2);
        bt1.setBackground(Color.GREEN);
        bt1.addMouseListener(this);
        bt1.addActionListener(this);
        panel.add(bt1);

        // tf5 = new JTextField();
        // tf5.setBounds(220, 250, 270, 100);
        // tf5.setFont(f2);
        // panel.add(tf5);

        bt2 = new JButton("Update");
        bt2.setBounds(350, 750, 150, 30);
        bt2.setFont(f2);
        bt2.setBackground(Color.GREEN);
        bt2.addMouseListener(this);
        bt2.addActionListener(this);
        panel.add(bt2);

        bt3 = new JButton("Add book");
        bt3.setBounds(350, 800, 150, 30);
        bt3.setFont(f2);
        bt3.setBackground(Color.GREEN);
        bt3.addMouseListener(this);
        bt3.addActionListener(this);
        panel.add(bt3);

        bt4 = new JButton("Exit");
        bt4.setBounds(350, 850, 150, 30);
        bt4.setFont(f2);
        bt4.setBackground(Color.GREEN);
        bt4.addMouseListener(this);
        bt4.addActionListener(this);
        panel.add(bt4);

        ta1 = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(ta1);
        scrollPane.setBounds(20, 300, 845, 300);
        ta1.setFont(f2);
        panel.add(scrollPane);
        super.add(panel);
        readFromFile();
        super.setVisible(true);

    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseClicked(MouseEvent me) {

    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == bt1) {
            bt1.setBackground(Color.DARK_GRAY);
        } else if (me.getSource() == bt2) {
            bt2.setBackground(new Color(0, 150, 0));
        } else if (me.getSource() == bt3) {
            bt3.setBackground(new Color(200, 0, 0));
        } else if (me.getSource() == bt4) {
            bt4.setBackground(new Color(200, 0, 0));
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == bt1) {
            bt1.setBackground(Color.BLUE);
        } else if (me.getSource() == bt2) {
            bt2.setBackground(Color.GREEN);
        } else if (me.getSource() == bt3) {
            bt3.setBackground(Color.RED);
        } else if (me.getSource() == bt4) {
            bt4.setBackground(Color.RED);
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bt4) {
            System.exit(0);
        }
        if (ae.getSource() == bt3) {
            String name = tf1.getText();
            String author = tf3.getText();
            String id = tf2.getText();

            String Genres = (String) jb1.getSelectedItem();

            String issues = ta1.getText();

            if (name.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill up all information!");
            } else {
                Book book = new Book(Integer.parseInt(id), name, author, Genres);

                bookList.addBook(book);
                book.insertInfo();

                JOptionPane.showMessageDialog(this, "Book added successfully saved!");
                ta1.setText(bookList.displayAllBooks());
                // displayBooks();
            }
        }

        if (ae.getSource() == bt1) {
            String idToDelete = tf2.getText().trim();
            if (idToDelete.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a id to delete!");
            } else {
                try {
                    int id = Integer.parseInt(idToDelete);
                    bookList.removeBook(id);
                    JOptionPane.showMessageDialog(this, "Book with ID " + id + " deleted!");
                    removeDataAndWriteToFile();
                    ta1.setText(bookList.displayAllBooks());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID!");
                }

            }
        }

    }

    public void removeDataAndWriteToFile() {
        try {
            File file = new File(".\\userdata.txt");

            if (file.exists()) {
                file.delete();
            }

            for (int i = 0; i < bookList.getBookCount(); i++) {
                Book book = bookList.getBooks()[i];
                book.insertInfo();
            }

        }

        catch (Exception ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to file!");
        }
    }

    private void readFromFile() {
        try {
            //
            String str = "";
            File file = new File(".\\userdata.txt");

            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] items = line.split(",");
                    Book book = new Book(Integer.parseInt(items[0]), items[1], items[2], items[3]);
                    bookList.addBook(book);
                }
                br.close();
            }

            ta1.setText(bookList.displayAllBooks());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
