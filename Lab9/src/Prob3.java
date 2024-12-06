import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class Problema3 extends JFrame implements ItemListener, ActionListener {
    JTextField quiz;
    JCheckBox c1, c2, c3, c4;
    JButton button;

    public Problema3(String fis) {
        super("Problema 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Camp pentru intrebare
        quiz = new JTextField(150);
        quiz.setEditable(false);

        // Casete de bifare pentru raspunsuri
        c1 = new JCheckBox();
        c2 = new JCheckBox();
        c3 = new JCheckBox();
        c4 = new JCheckBox();

        // Adaugam un singur ascultator pentru toate casetele
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        c4.addItemListener(this);

        // Panel pentru casete de bifare
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(4, 1));
        checkBoxPanel.add(c1);
        checkBoxPanel.add(c2);
        checkBoxPanel.add(c3);
        checkBoxPanel.add(c4);

        // Butonul de validare
        button = new JButton("Valideaza");
        button.setEnabled(false);
        button.addActionListener(this);

        // Adaugam componentele in fereastra
        add(quiz, BorderLayout.NORTH);
        add(checkBoxPanel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        // Initializare continut din fisier
        try {
            RandomAccessFile br = new RandomAccessFile(fis, "r");
            quiz.setText(br.readLine());
            c1.setText(br.readLine());
            c2.setText(br.readLine());
            c3.setText(br.readLine());
            c4.setText(br.readLine());
            br.close();
        } catch (IOException ex) {
            System.err.println("Exceptie");
        }

        pack();
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // Activam butonul daca orice caseta este selectata
        button.setEnabled(c1.isSelected() || c2.isSelected() || c3.isSelected() || c4.isSelected());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            // Resetam culorile initiale
            c1.setForeground(Color.black);
            c2.setForeground(Color.black);
            c3.setForeground(Color.black);
            c4.setForeground(Color.black);

            // Aplicam culorile in functie de raspunsurile corecte
            if (c1.isSelected()) {
                c1.setForeground(Color.green);
            } else {
                c1.setForeground(Color.red);
            }

            if (c2.isSelected()) {
                c2.setForeground(Color.red);
            } else {
                c2.setForeground(Color.black);
            }

            if (c3.isSelected()) {
                c3.setForeground(Color.green);
            } else {
                c3.setForeground(Color.red);
            }

            if (c4.isSelected()) {
                c4.setForeground(Color.red);
            } else {
                c4.setForeground(Color.black);
            }

            // Dezactivam butonul dupa validare
            button.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new Problema3("intrebare.txt");
    }
}
