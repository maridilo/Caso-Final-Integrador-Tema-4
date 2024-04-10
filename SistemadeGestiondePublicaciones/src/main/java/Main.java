import ComparadoryContadordeContenido.Analisisdetexto;
import EditordeTextoInteractivo.Editosdetexto;
import EditordeTextoInteractivo.MenuPrincipal;
import EditordeTextoInteractivo.NavegacionyListado;
import EditordeTextoInteractivo.Ventana;
import EditordeTextoInteractivo.MenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
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
                JFrame mainframe = new JFrame("Editor de Texto Interactivo");
                MenuPrincipal menu = new MenuPrincipal(mainframe);
                mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainframe.setSize(800, 600);
                mainframe.setLayout(new BorderLayout());
                mainframe.add(new Editosdetexto(mainframe, mainframe), BorderLayout.CENTER);
                mainframe.setVisible(true);
                mainframe.setLocationRelativeTo(null);
                mainframe.setResizable(true);
                menu.abrirEditorDeTexto();
                mainframe.setVisible(true);

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
                    Editosdetexto editor = new Editosdetexto(frame, frame);
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




