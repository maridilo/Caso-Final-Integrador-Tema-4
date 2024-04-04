import EditordeTextoInteractivo.Editosdetexto;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Editor de Texto Interactivo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setLayout(new BorderLayout());
                frame.add(new Editosdetexto(), BorderLayout.CENTER);
                frame.setVisible(true);
            }
        });
    }
}

