import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class ColorSliderApp extends JFrame implements ChangeListener {
    private JSlider redSlider, greenSlider, blueSlider;
    private JTextField colorDisplay;

    public ColorSliderApp() {
        super("Color Slider App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Slider pentru Red
        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        redSlider.setMajorTickSpacing(50);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);
        redSlider.addChangeListener(this);

        // Slider pentru Green
        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenSlider.setMajorTickSpacing(50);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);
        greenSlider.addChangeListener(this);

        // Slider pentru Blue
        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueSlider.setMajorTickSpacing(50);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);
        blueSlider.addChangeListener(this);

        // Panou pentru slidere
        JPanel slidersPanel = new JPanel();
        slidersPanel.setLayout(new GridLayout(3, 1));
        slidersPanel.add(createLabeledPanel("Red", redSlider));
        slidersPanel.add(createLabeledPanel("Green", greenSlider));
        slidersPanel.add(createLabeledPanel("Blue", blueSlider));

        // Camp text pentru afisarea culorii
        colorDisplay = new JTextField();
        colorDisplay.setEditable(false);
        colorDisplay.setHorizontalAlignment(JTextField.CENTER);
        colorDisplay.setFont(new Font("Arial", Font.BOLD, 20));

        // Adaugam componentele in fereastra
        add(slidersPanel, BorderLayout.CENTER);
        add(colorDisplay, BorderLayout.SOUTH);

        updateColorDisplay();

        pack();
        setVisible(true);
    }

    private JPanel createLabeledPanel(String labelText, JSlider slider) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText, JLabel.CENTER);
        panel.add(label, BorderLayout.NORTH);
        panel.add(slider, BorderLayout.CENTER);
        return panel;
    }

    private void updateColorDisplay() {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();
        Color color = new Color(red, green, blue);
        colorDisplay.setBackground(color);
        colorDisplay.setText(String.format("RGB(%d, %d, %d)", red, green, blue));
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        updateColorDisplay();
    }

    public static void main(String[] args) {
        new ColorSliderApp();
    }
}
