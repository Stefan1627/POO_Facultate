import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class FileReaderWindow extends JFrame implements ActionListener {
    private JTextField pathField;
    private JTextArea textArea;
    private JButton button;
    private JScrollPane scrollPane;

    public FileReaderWindow() {
        super("File Reader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(400, 300);

        JPanel panel = new JPanel();
        JLabel pathLabel = new JLabel("Path: ");
        pathField = new JTextField();
        button = new JButton("Read");
        button.addActionListener(this);

        panel.add(pathLabel, BorderLayout.WEST);
        panel.add(pathField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.EAST);

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVisible(false);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String path = pathField.getText().trim();
        System.out.println(path);
        File file = new File("C:\\Users\\stefa\\OneDrive\\Desktop\\restore\\fisier.txt");

        if (file.exists() && !file.isDirectory()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                scrollPane.setVisible(true);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("File dont exists");
            textArea.setText("");
            scrollPane.setVisible(false);
        }

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new FileReaderWindow();
    }
}
