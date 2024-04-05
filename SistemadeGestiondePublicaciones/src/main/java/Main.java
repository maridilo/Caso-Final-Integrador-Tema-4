import ComparadoryContadordeContenido.Analisisdetexto;
import EditordeTextoInteractivo.Editosdetexto;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

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
                frame.setLocationRelativeTo(null);
                frame.setResizable(true);
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

    }


