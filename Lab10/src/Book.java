import javax.swing.*;
import java.util.Vector;

public class Book {
    private String name;
    private String author;
    private String iconName;

    public Book(String name, String author, String iconName) {
        this.name = name;
        this.author = author;
        this.iconName = iconName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
    public String toString()
    {
        return iconName + name + author;
    }
}

class Prob1 {
    public static void main(String[] args) {
        Book book1 = new Book("Book 1", "author1", "");
        Book book2 = new Book("Book 2", "author2", "");
        Book book3 = new Book("Book 3", "author3", "");
        Book book4 = new Book("Book 4", "author4", "");
        Book book5 = new Book("Book 5", "author5", "");
        Book book6 = new Book("Book 6", "author6", "");
        Book book7 = new Book("Book 7", "author7", "");
        Book book8 = new Book("Book 8", "author8", "");
        Book book9 = new Book("Book 9", "author9", "");
        Book book10 = new Book("Book 10", "author10", "");
        Book book11 = new Book("Book 11", "author11", "");
        Book book12 = new Book("Book 12", "author12", "");
        Book book13 = new Book("Book 13", "author13", "");
        Book book14 = new Book("Book 14", "author14", "");

        Vector<Book> books = new Vector();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);
        books.add(book11);
        books.add(book12);
        books.add(book13);
        books.add(book14);

        JFrame frame = new JFrame("Aplicatie Jlist");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 100);

        JList<Book> bookJList = new JList<>(books);

        bookJList.setCellRenderer((list, book, index, isSelected, cellHasFocus) -> {
            JLabel label = new JLabel(book.getName() + " - " + book.getAuthor());
            label.setOpaque(true);
            return label;
        });

        JScrollPane scrollPane = new JScrollPane(bookJList);

        frame.add(scrollPane);
        frame.setVisible(true);
    }
}