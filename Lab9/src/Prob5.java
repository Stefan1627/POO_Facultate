import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class ColorButtonApp extends JFrame implements ActionListener {
    private JButton colorButton;
    private Color[] colors = {Color.BLUE, Color.RED, Color.green, Color.yellow, Color.orange};
    private int index = 0;

    public ColorButtonApp() {
        super("Color");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(100, 100);
        setLayout(new FlowLayout());

        colorButton = new JButton("Color");
        colorButton.setMnemonic(KeyEvent.VK_C);
        colorButton.addActionListener(this);
        colorButton.setBackground(colors[index]);
        colorButton.setForeground(Color.BLACK);

        add(colorButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index = (index + 1) % colors.length;
        colorButton.setBackground(colors[index]);
        colorButton.setForeground(Color.BLACK);
    }

    public static void main(String[] args) {
        new ColorButtonApp();
    }
}
