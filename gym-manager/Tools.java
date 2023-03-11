package gym;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tools {

    public static void msgBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void openForm(JFrame form) {
        try {
            form.setLocationRelativeTo(null);
            form.setTitle("Salle De Sport Management");
            form.getContentPane().setBackground(Color.white);
            form.setVisible(true);
        } catch (Exception ex) {
            msgBox(ex.getMessage());
        }
    }
}
