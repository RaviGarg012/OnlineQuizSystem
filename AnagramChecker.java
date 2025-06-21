import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class AnagramChecker extends JFrame {

    private JTextField input1;
    private JTextField input2;
    private JButton checkButton;
    private JLabel resultLabel;

    public AnagramChecker() {
        setTitle("Anagram Checker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(new GridLayout(5, 1, 10, 10));

        input1 = new JTextField();
        input2 = new JTextField();
        checkButton = new JButton("Check Anagram");
        resultLabel = new JLabel("", JLabel.CENTER);

        add(new JLabel("Enter First String:", JLabel.CENTER));
        add(input1);
        add(new JLabel("Enter Second String:", JLabel.CENTER));
        add(input2);
        add(checkButton);
        add(resultLabel);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnagram();
            }
        });

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void checkAnagram() {
        String str1 = input1.getText().trim();
        String str2 = input2.getText().trim();

        try {
            if (str1.isEmpty() || str2.isEmpty()) {
                throw new IllegalArgumentException("Both input fields must be filled.");
            }

            boolean isAnagram = areAnagrams(str1, str2);
            resultLabel.setText(isAnagram ? "✅ Result: Anagram" : "❌ Result: Not Anagram");

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean areAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null) return false;

        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        if (s1.length() != s2.length()) return false;

        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

        return Arrays.equals(a1, a2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AnagramChecker());
    }
}
