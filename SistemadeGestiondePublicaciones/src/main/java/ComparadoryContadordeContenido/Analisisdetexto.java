package ComparadoryContadordeContenido;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;

public class Analisisdetexto extends JPanel {
    private final JTextArea textArea;
    private final JTextArea resultArea;

    public Analisisdetexto() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);
        JButton analizarButton = new JButton("Analizar");
        analizarButton.addActionListener(e -> analizarTexto(new File("ruta/al/archivo 1.txt")));
        add(analizarButton, BorderLayout.NORTH);
    }

    public void analizarTexto(File file) {
        try {
            Map<String, Integer> wordCount = wordCount(file);
            textArea.setText("Conteo de palabras: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public void analizarTexto(File file, String[] palabrasExcluidas) {
        try {
            Map<String, Integer> wordCount = wordCount(file, palabrasExcluidas);
            textArea.setText("Conteo de palabras: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public boolean compararArchivos(File file1, File file2) {
        try {
            boolean sonIguales = compararContenido(file1, file2);
            textArea.setText("Los archivos son iguales: " + sonIguales);
            return sonIguales;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean compararContenido(File file1, File file2) throws IOException {
        String contenido1 = new String(Files.readAllBytes(file1.toPath()));
        String contenido2 = new String(Files.readAllBytes(file2.toPath()));
        return contenido1.equals(contenido2);
    }

    public Map<String, Integer> wordCount(File file) throws IOException {
        String contenido = new String(Files.readAllBytes(file.toPath()));
        String[] palabras = contenido.split("\\s+");
        Map<String, Integer> estadisticas = new HashMap<>();
        for (String palabra : palabras) {
            estadisticas.put(palabra, estadisticas.getOrDefault(palabra, 0) + 1);
        }
        return estadisticas;
    }

    public Map<String, Integer> wordCount(File file, String[] palabrasExcluidas) throws IOException {
        String contenido = new String(Files.readAllBytes(file.toPath()));
        String[] palabras = contenido.split("\\s+");
        List<String> palabrasExcluidasList = Arrays.asList(palabrasExcluidas);
        Map<String, Integer> estadisticas = new HashMap<>();
        for (String palabra : palabras) {
            if (!palabrasExcluidasList.contains(palabra)) {
                estadisticas.put(palabra, estadisticas.getOrDefault(palabra, 0) + 1);
            }
        }
        return estadisticas;
    }
    private void mostrarResultados(String resultado) {
        resultArea.setText(resultado);
    }
}
