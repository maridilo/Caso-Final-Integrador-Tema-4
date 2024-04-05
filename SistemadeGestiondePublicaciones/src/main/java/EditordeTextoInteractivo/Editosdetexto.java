package EditordeTextoInteractivo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;

public class Editosdetexto extends JPanel {
    private final JTextArea textArea;
    private final JButton saveButton;
    private final JButton openButton;
    private final JButton newButton;

    public Editosdetexto() {
        textArea = new JTextArea();
        saveButton = new JButton("Save");
        openButton = new JButton("Open");
        newButton = new JButton("New");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(newButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);

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
                textArea.setText("");
            }
        });

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
