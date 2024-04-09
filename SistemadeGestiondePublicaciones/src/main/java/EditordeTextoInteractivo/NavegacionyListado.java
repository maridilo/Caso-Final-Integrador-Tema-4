package EditordeTextoInteractivo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Paths;

public class NavegacionyListado extends JPanel {
    private static final String DOCUMENTOS = "ruta/a/tus/documentos";
    private JList<String> fileList;
    private DefaultListModel<String> listModel;
    private Editosdetexto editor;



    public NavegacionyListado(Editosdetexto editor) {
            this.editor = editor;
            setLayout(new BorderLayout());

            listModel = new DefaultListModel<>();
            fileList = new JList<>(listModel);
            fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            fileList.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    if (evt.getClickCount() == 2) {
                        String filename = fileList.getSelectedValue();
                        File file = Paths.get("ruta/a/tus/documentos", filename).toFile();
                        editor.abrirArchivo(file);
                    }
                }
            });
            JScrollPane scrollPane = new JScrollPane(fileList);
            add(scrollPane, BorderLayout.CENTER);

            actualizarListaDeArchivos();
    }
    public void actualizarListaDeArchivos() {
            File folder = new File(DOCUMENTOS );
            File[] files = folder.listFiles();
            listModel.clear();
            for (File file : files) {
                if (file.isFile()) {
                    listModel.addElement(file.getName());
                }
            }
        }
}

