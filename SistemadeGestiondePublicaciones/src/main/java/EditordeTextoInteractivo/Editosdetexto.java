package EditordeTextoInteractivo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Editosdetexto extends JPanel {
    private final JTextArea textArea;
    private final JButton saveButton;
    private final JButton openButton;
    private final JButton newButton;
    private final JButton backButton;

    private JFrame frame;
    private JPanel buttonPanel;

    public Editosdetexto() {
        this.frame = frame;
        textArea = new JTextArea();
        saveButton = new JButton("Save");
        openButton = new JButton("Open");
        newButton = new JButton("New");
        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(newButton);
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.setPreferredSize(new Dimension(100, 100));

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
        add(backButton, BorderLayout.SOUTH);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.abrirEditorDeTexto();
            }
        });
        add(backButton, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save File");
                int userSelection = fileChooser.showSaveDialog(Editosdetexto.this);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (file != null) {
                        try {
                            FileWriter fileWriter = new FileWriter(file);
                            fileWriter.write(textArea.getText());
                            fileWriter.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Open File");
                int userSelection = fileChooser.showOpenDialog(Editosdetexto.this);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (file != null) {
                        try {
                            textArea.setText("");
                            textArea.append(new String(Files.readAllBytes(file.toPath())));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });



        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(Editosdetexto.this, "Do you want to save the current file?");
                if (option == JOptionPane.YES_OPTION) {
                    saveButton.doClick();
                }
                textArea.setText("");
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarArchivo();
            }
        });

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarArchivo();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.abrirEditorDeTexto();
            }
        });
    }

    private void guardarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter fileWriter = new FileWriter(fileToSave)) {
                fileWriter.write(textArea.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void cargarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Abrir archivo");
        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            try {
                String content = new String(Files.readAllBytes(fileToOpen.toPath()));
                textArea.setText(content);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void abrirArchivo(File file) {
        try {
            textArea.setText("");
            textArea.append(new String(Files.readAllBytes(file.toPath())));
        } catch (IOException ex) {
            ex.printStackTrace();
    }

    }
}
