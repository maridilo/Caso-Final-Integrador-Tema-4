import ComparadoryContadordeContenido.Analisisdetexto;
import EditordeTextoInteractivo.Editosdetexto;
import EditordeTextoInteractivo.NavegacionyListado;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
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
                JFrame frame = new JFrame("Editor de Texto Interactivo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setLayout(new BorderLayout());
                frame.add(new Editosdetexto(), BorderLayout.CENTER);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setResizable(true);
            } else if (n == 1) {
                    JFrame frame = new JFrame("Analizador de Texto");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 600);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(true);
                    Analisisdetexto analisis = new Analisisdetexto();
                    File file1 = new File("ruta/al/archivo 1.txt");
                    try {
                        Map<String, Integer> wordCount = analisis.wordCount(file1);
                        System.out.println("Conteo de palabras: " + wordCount);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    } else if (n == 2) {
                    JFrame frame = new JFrame("Navegación y Listado de Documentos");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 600);
                    frame.setLayout(new BorderLayout());
                    Editosdetexto editor = new Editosdetexto();
                    frame.add(new NavegacionyListado(editor), BorderLayout.CENTER);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(true);
                }
                }
        });

        Analisisdetexto analisis = new Analisisdetexto();
        File file1 = new File("ruta/al/archivo 1.txt");
        File file2 = new File("ruta/al/archivo 2.txt");
        try {
            boolean sonIguales = analisis.compararArchivos(file1, file2);
            System.out.println("Los archivos son iguales: " + sonIguales);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("ruta/al/archivo.txt");
        try {
            Map<String, Integer> wordCount = analisis.wordCount(file);
            System.out.println("Conteo de palabras: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] palabrasExcluidas = {"a", "de", "el", "la", "los", "las"};
        try {
            Map<String, Integer> wordCount = analisis.wordCount(file, palabrasExcluidas);
            System.out.println("Conteo de palabras excluyendo palabras comunes: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        public static void mostrarDialogoInicial() {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    // El código del diálogo inicial va aquí...
                }
            });
        }

    // ...
}




