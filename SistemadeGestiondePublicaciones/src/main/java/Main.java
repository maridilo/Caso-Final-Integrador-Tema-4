import ComparadoryContadordeContenido.Analisisdetexto;
import EditordeTextoInteractivo.Editosdetexto;
import EditordeTextoInteractivo.NavegacionyListado;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void abrirMenuPrincipal() {

    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Object[] options = {"Editar texto", "Analizar texto","Navegar y listar archivos",};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Qué te gustaría hacer?",
                        "Editor de Texto Interactivo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (n == 0) {
                    // Codigo para abrir el editor de texto
                JFrame frame = new JFrame("Editor de Texto Interactivo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setLayout(new BorderLayout());
                frame.add(new Editosdetexto(), BorderLayout.CENTER);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setResizable(true);
                Editosdetexto editor = new Editosdetexto();
                frame.add(editor, BorderLayout.CENTER);
                    // Agregar el botón de "Volver atrás"
                    JButton backButton = new JButton("Volver atrás");
                    editor.getButtonPanel().add(backButton);
                    backButton.addActionListener(e -> {
                        // Cerrar la ventana actual y volver al menú principal
                        frame.dispose(); // Cierra la ventana actual
                        abrirMenuPrincipal(); // Vuelve al menú principal
                    });

                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(true);

            } else if (n == 1) {
                    // Codigo para abrir el analizador de texto
                    JFrame frame = new JFrame("Analizador de Texto");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 600);
                    frame.setLayout(new BorderLayout());
                    Analisisdetexto analisis = new Analisisdetexto();
                    frame.add(analisis, BorderLayout.CENTER);
                    File file1 = new File("ruta/al/archivo 1.txt");
                    File file2 = new File("ruta/al/archivo 2.txt");
                    boolean sonIguales = analisis.compararArchivos(file1, file2);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(true);
                    analisis.compararArchivos(file1, file2);
                    } else if (n == 2) {
                    // Codigo para abrir el navegador y listado de archivos
                    JFrame frame = new JFrame("Navegación y Listado de Documentos");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 600);
                    frame.setLayout(new BorderLayout());
                    Editosdetexto editor = new Editosdetexto();
                    NavegacionyListado navegacion = new NavegacionyListado(editor);
                    navegacion.actualizarListaDeArchivos(); // Actualiza la lista al abrir el navegador
                    frame.add(navegacion, BorderLayout.CENTER);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(true);
                }
                }
        });

    }
}




