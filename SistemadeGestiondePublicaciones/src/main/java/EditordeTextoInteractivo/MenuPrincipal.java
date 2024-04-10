package EditordeTextoInteractivo;
import ComparadoryContadordeContenido.Analisisdetexto;
import EditordeTextoInteractivo.Editosdetexto;
import EditordeTextoInteractivo.MenuPrincipal;
import EditordeTextoInteractivo.NavegacionyListado;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal {
    private JFrame mainFrame;

    public MenuPrincipal(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void mostrarMenuPrincipal() {
        mainFrame.setVisible(true);
    }

    public void abrirEditorDeTexto() {
        Editosdetexto editor = new Editosdetexto(mainFrame, mainFrame);
        new Ventana("Editor de Texto Interactivo", editor);
    }

    public void abrirAnalizadorDeTexto() {
        Analisisdetexto analisis = new Analisisdetexto();
        new Ventana("Analizador de Texto", analisis);
    }

    public void abrirNavegadorDeArchivos() {
        Editosdetexto editor = new Editosdetexto(mainFrame, mainFrame);
        NavegacionyListado navegacion = new NavegacionyListado(editor);
        navegacion.actualizarListaDeArchivos();
        new Ventana("Navegación y Listado de Documentos", navegacion);
    }
}
