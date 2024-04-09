package EditordeTextoInteractivo;
import ComparadoryContadordeContenido.Analisisdetexto;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal {
    public void abrirEditorDeTexto() {
        Editosdetexto editor = new Editosdetexto();
        new Ventana("Editor de Texto Interactivo", editor);
    }

    public void abrirAnalizadorDeTexto() {
        Analisisdetexto analisis = new Analisisdetexto();
        new Ventana("Analizador de Texto", analisis);
    }

    public void abrirNavegadorDeArchivos() {
        Editosdetexto editor = new Editosdetexto();
        NavegacionyListado navegacion = new NavegacionyListado(editor);
        navegacion.actualizarListaDeArchivos();
        new Ventana("Navegación y Listado de Documentos", navegacion);
    }
}
