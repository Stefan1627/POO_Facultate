import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prob3 {
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

        DefaultListModel<Book> books = new DefaultListModel<>();
        books.addElement(book1);
        books.addElement(book2);
        books.addElement(book3);
        books.addElement(book4);
        books.addElement(book5);
        books.addElement(book6);
        books.addElement(book7);
        books.addElement(book8);
        books.addElement(book9);
        books.addElement(book10);
        books.addElement(book11);
        books.addElement(book12);
        books.addElement(book13);
        books.addElement(book14);

        JList<Book> bookJList = new JList<>(books);

        bookJList.setCellRenderer((list, book, index, isSelected, cellHasFocus) -> {
            JLabel label = new JLabel(book.getName() + " - " + book.getAuthor());
            label.setOpaque(true);
            return label;
        });

        JTextField nameField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JLabel authorLabel = new JLabel("Author");
        JLabel nameLabel = new JLabel("Name");

        bookJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    Book selectedBook = bookJList.getSelectedValue();
                    if (selectedBook != null) {
                        nameField.setText(selectedBook.getName());
                        System.out.println(selectedBook.getName());
                        authorField.setText(selectedBook.getAuthor());
                    }
                }
            }
        });

        JButton removeBtn = new JButton("Remove");
        removeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = bookJList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    books.removeElementAt(selectedIndex);
                    nameField.setText("");
                    authorField.setText("");
                }
            }
        });

        JFrame frame = new JFrame("Aplicatie JList");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel detailsPanel = new JPanel(new GridLayout(2, 2));
        detailsPanel.getPreferredSize();

        detailsPanel.add(nameLabel);
        detailsPanel.add(nameField);
        detailsPanel.add(authorLabel);
        detailsPanel.add(authorField);

        JScrollPane scrollPane = new JScrollPane(bookJList);
        mainPanel.add(scrollPane, BorderLayout.WEST);
        mainPanel.add(detailsPanel, BorderLayout.NORTH);
        mainPanel.add(removeBtn, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
