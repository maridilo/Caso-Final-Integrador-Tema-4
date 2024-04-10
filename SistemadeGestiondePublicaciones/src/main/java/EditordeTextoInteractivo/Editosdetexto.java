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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Editosdetexto extends JPanel {
    private final JTextArea textArea;
    private final JButton saveButton;
    private final JButton openButton;
    private final JButton newButton;
    private final JButton backButton;

    private JFrame frame;
    private JPanel buttonPanel;

    public Editosdetexto(JFrame frame, JFrame mainFrame) {
        this.frame = frame;
        textArea = new JTextArea();
        saveButton = new JButton("Save");
        openButton = new JButton("Open");
        newButton = new JButton("New");
        backButton = new JButton("Back");

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(true);
            }
        });

        buttonPanel = new JPanel();
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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                mainFrame.setVisible(true);
            }
        });

        add(backButton, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save File");
                guardarArchivo();
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
                cargarArchivo();
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
                int option = JOptionPane.showConfirmDialog(Editosdetexto.this, "Quieres guardar el archivo actual?");
                if (option == JOptionPane.YES_OPTION) {
                    saveButton.doClick();
                }
                textArea.setText("");
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
