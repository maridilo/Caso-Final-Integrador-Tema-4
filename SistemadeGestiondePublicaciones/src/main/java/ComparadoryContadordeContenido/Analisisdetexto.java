package ComparadoryContadordeContenido;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;

public class Analisisdetexto {
    public boolean compararArchivos(File file1, File file2) throws IOException {
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
}
