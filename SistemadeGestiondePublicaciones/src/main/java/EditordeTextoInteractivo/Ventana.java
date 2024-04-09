package EditordeTextoInteractivo;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;


public class Ventana extends JFrame {
    public Ventana(String titulo, JPanel panel) {
        super(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
    }
}
