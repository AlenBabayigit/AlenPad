import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 * The final version of AlenPad. (First 2 versions created in Python, using PyQt5 Framework)
 * @author Alen Babayigit
 * @version 3.0.2
 */
public class AlenPad extends javax.swing.JFrame {
    // --------------------------------------- Instance Variables Declaration --------------------------------------- \\
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem arial;
    private javax.swing.JMenuItem calibri;
    private javax.swing.JMenuItem color;
    private javax.swing.JMenuItem consolas;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenuItem delete;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu font;
    private String fontName;
    private Integer fontSize;
    private javax.swing.JMenu formatMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem paste;
    private javax.swing.JMenuItem redo;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JMenuItem selectAll;
    private javax.swing.JTextArea textArea;
    private javax.swing.JMenuItem timesNewRoman;
    private javax.swing.JMenuItem undo;
    private javax.swing.undo.UndoManager undoManager;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JMenu zoom;
    private javax.swing.JMenuItem zoomIn;
    private javax.swing.JMenuItem zoomOut;
    private javax.swing.JMenuItem zoomRestore;
    // ---------------------------------------- End Of Variables Declaration ---------------------------------------- \\

    /** Constructor Method for AlenPad */
    public AlenPad() {
        initComponents();
    }

    private void initComponents() {
        // ----------------------------------- Initalizing The Instance Variables ----------------------------------- \\
        fontSize = 14;
        fontName = "Arial";
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        undo = new javax.swing.JMenuItem();
        redo = new javax.swing.JMenuItem();
        cut = new javax.swing.JMenuItem();
        copy = new javax.swing.JMenuItem();
        paste = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();
        selectAll = new javax.swing.JMenuItem();
        formatMenu = new javax.swing.JMenu();
        font = new javax.swing.JMenu();
        arial = new javax.swing.JMenuItem();
        calibri = new javax.swing.JMenuItem();
        consolas = new javax.swing.JMenuItem();
        timesNewRoman = new javax.swing.JMenuItem();
        color = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        zoom = new javax.swing.JMenu();
        zoomIn = new javax.swing.JMenuItem();
        zoomOut = new javax.swing.JMenuItem();
        zoomRestore = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();
        // ---------------------------------------------------------------------------------------------------------- \\

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AlenPad 3.0");
        setBounds(500, 200, 500, 650);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("alenpad.png")));
        setIconImage(icon.getImage());

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font(fontName, Font.PLAIN, fontSize)); // NOI18N
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        fileMenu.setText("File");

        newFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newFile.setText("New");
        newFile.addActionListener(this::newFileActionPerformed);
        fileMenu.add(newFile);

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openFile.setText("Open");
        openFile.addActionListener(this::openFileActionPerformed);
        fileMenu.add(openFile);

        saveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveFile.setText("Save");
        saveFile.addActionListener(this::saveFileActionPerformed);
        fileMenu.add(saveFile);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exit.setText("Exit");
        exit.addActionListener(this::exitActionPerformed);
        fileMenu.add(exit);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        undoManager = new UndoManager();
        Document doc = textArea.getDocument();
        doc.addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));

        undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        undo.setText("Undo");
        undo.addActionListener(this::undoActionPerformed);
        editMenu.add(undo);

        redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        redo.setText("Redo");
        redo.addActionListener(this::redoActionPerformed);
        editMenu.add(redo);

        cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cut.setText("Cut");
        cut.addActionListener(this::cutActionPerformed);
        editMenu.add(cut);

        copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copy.setText("Copy");
        copy.addActionListener(this::copyActionPerformed);
        editMenu.add(copy);

        paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        paste.setText("Paste");
        paste.addActionListener(this::pasteActionPerformed);
        editMenu.add(paste);

        delete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        delete.setText("Delete");
        delete.addActionListener(this::deleteActionPerformed);
        editMenu.add(delete);

        selectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        selectAll.setText("Select All");
        selectAll.addActionListener(this::selectAllActionPerformed);
        editMenu.add(selectAll);

        menuBar.add(editMenu);

        formatMenu.setText("Format");

        font.setText("Font");

        arial.setText("Arial");
        arial.addActionListener(this::arialActionPerformed);
        font.add(arial);

        calibri.setText("Calibri");
        calibri.addActionListener(this::calibriActionPerformed);
        font.add(calibri);

        consolas.setText("Consolas");
        consolas.addActionListener(this::consolasActionPerformed);
        font.add(consolas);

        timesNewRoman.setText("Times New Roman");
        timesNewRoman.addActionListener(this::timesNewRomanActionPerformed);
        font.add(timesNewRoman);

        formatMenu.add(font);

        color.setText("Change Color");
        color.addActionListener(this::colorActionPerformed);
        formatMenu.add(color);

        menuBar.add(formatMenu);

        viewMenu.setText("View");

        zoom.setText("Zoom");

        zoomIn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ADD, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        zoomIn.setText("Zoom In");
        zoomIn.addActionListener(this::zoomInActionPerformed);
        zoom.add(zoomIn);

        zoomOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SUBTRACT, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        zoomOut.setText("Zoom Out");
        zoomOut.addActionListener(this::zoomOutActionPerformed);
        zoom.add(zoomOut);

        zoomRestore.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        zoomRestore.setText("Restore Default Zoom");
        zoomRestore.addActionListener(this::zoomRestoreActionPerformed);
        zoom.add(zoomRestore);

        viewMenu.add(zoom);

        menuBar.add(viewMenu);

        helpMenu.setText("Help");

        about.setText("About AlenPad 3.0");
        about.addActionListener(this::aboutActionPerformed);
        helpMenu.add(about);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
        );

        pack();
    }

    // ---------------------------------- Action Performed Methods for 'File' Menu ---------------------------------- \\

    /**
     * Clears the textArea.
     * Will ask if the user wants to save if textArea is not empty.
     */
    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {
        if (!textArea.getText().equals("")) {
            int save = JOptionPane.showConfirmDialog(this, "Do you want to save changes?", "Save",
                    JOptionPane.YES_NO_OPTION);
            if (save == JOptionPane.YES_NO_OPTION) {
                saveFile();
            }
        }
        this.textArea.setText("");
    }

    /**
     * Opens a file from the user's computer by using JFileChooser and Scanner, Buffered Reader and FileReader classes.
     */
    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fc = new JFileChooser();

        int approve = fc.showOpenDialog(this);

        if (approve == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
                StringBuilder content = new StringBuilder();
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append("\n");
                }
                textArea.setText(content.toString());
            }
            catch (FileNotFoundException ex) {
                System.out.println("File couldn't found.");
                System.out.println("Terminating the program...");
                System.exit(0);
            }
        }
    }

    /**
     * Saves the file.
     */
    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {
        saveFile();
    }

    /**
     * Exits from the application.
     * Will ask if the user wants to save if textArea is not empty.
     */
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        if (!textArea.getText().equals("")) {
            int save = JOptionPane.showConfirmDialog(this, "Do you want to save changes?", "Save",
                    JOptionPane.YES_NO_OPTION);
            if (save == JOptionPane.YES_NO_OPTION) {
                saveFile();
            }
        }
        System.exit(0);
    }

    /**
     * Saves the file by using JFileChooser and FileWriter.
     */
    private void saveFile() {
        JFileChooser fc = new JFileChooser();
        int approve = fc.showSaveDialog(this);
        if (approve == JFileChooser.APPROVE_OPTION) {
            String filePath = fc.getSelectedFile().getPath();
            try ( FileWriter writer = new FileWriter(filePath)) {
                writer.write(textArea.getText());
            }
            catch (IOException ex) {
                System.out.println("An error occured while saving the file.");
                System.out.println("Terminating the program...");
                System.exit(0);
            }
        }
    }

    // ---------------------------------- Action Performed Methods for 'Edit' Menu ---------------------------------- \\

    /**
     * Undoes the last changes.
     */
    private void undoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (undoManager.canUndo())
                undoManager.undo();
        }
        catch (CannotUndoException e) {
            e.printStackTrace();
        }
    }

    /**
     * Redoes the last changes.
     */
    private void redoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (undoManager.canRedo())
                undoManager.redo();
        }
        catch (CannotUndoException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cuts the selected text.
     */
    private void cutActionPerformed(java.awt.event.ActionEvent evt) {
        this.textArea.cut();
    }

    /**
     * Copies the selected text.
     */
    private void copyActionPerformed(java.awt.event.ActionEvent evt) {
        this.textArea.copy();
    }

    /**
     * Pastes the copied or cut text.
     */
    private void pasteActionPerformed(java.awt.event.ActionEvent evt) {
        this.textArea.paste();
    }

    /**
     * Deletes the selected text.
     */
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        this.textArea.replaceSelection("");
    }

    /**
     * Selects all text.
     */
    private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {
        this.textArea.selectAll();
    }

    // --------------------------------- Action Performed Methods for 'Format' Menu --------------------------------- \\

    /**
     * Updates the font to Arial.
     */
    private void arialActionPerformed(java.awt.event.ActionEvent evt) {
        this.fontName = "Arial";
        updateFont();
    }

    /**
     * Updates the font to Calibri.
     */
    private void calibriActionPerformed(java.awt.event.ActionEvent evt) {
        this.fontName = "Calibri";
        updateFont();
    }

    /**
     * Updates the font to Consolas.
     */
    private void consolasActionPerformed(java.awt.event.ActionEvent evt) {
        this.fontName = "Consolas";
        updateFont();
    }

    /**
     * Updates the font to Times New Roman.
     */
    private void timesNewRomanActionPerformed(java.awt.event.ActionEvent evt) {
        this.fontName = "Times New Roman";
        updateFont();
    }

    /**
     * Changes the font color via JColorChooser.
     */
    private void colorActionPerformed(java.awt.event.ActionEvent evt) {
        Color color = JColorChooser.showDialog(this, "Choose a color", Color.RED);
        this.textArea.setForeground(color);
    }

    /**
     * Uses the textArea's .setFont() method, makes it easier to change font or font size.
     */
    private void updateFont() {
        this.textArea.setFont(new Font(fontName, Font.PLAIN, fontSize));
    }

    // ---------------------------------- Action Performed Methods for 'View' Menu ---------------------------------- \\

    /**
     * Enlarges the font size by 2.
     */
    private void zoomInActionPerformed(java.awt.event.ActionEvent evt) {
        fontSize += 2;
        updateFont();
    }

    /**
     * Decreases the font size by 2.
     */
    private void zoomOutActionPerformed(java.awt.event.ActionEvent evt) {
        fontSize -= 2;
        updateFont();
    }

    /**
     * Resets the zoom.
     */
    private void zoomRestoreActionPerformed(java.awt.event.ActionEvent evt) {
        fontSize = 14;
        updateFont();
    }

    // ---------------------------------- Action Performed Methods for 'Help' Menu ---------------------------------- \\

    /**
     * Shows a JOptionPane Message Dialog about the application.
     */
    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {
        String message = """
                                                                                               AlenPad
                                                        Version 3.0 (Created with Java 17 & Swing GUI Framework)
                         © 2001-2022 Alen Babayigit Computer Engineering Services™ Company. All rights reserved.
                         """;

        JOptionPane.showMessageDialog(this, message, "About AlenPad 3.0", JOptionPane.INFORMATION_MESSAGE);
    }

    // -------------------------------------------------------------------------------------------------------------- \\

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(
                () -> new AlenPad().setVisible(true)
        );
    }
    /*
     * Please note: AlenPad.form created in NetBeans IDE. It may not be compatible with IntelliJ IDEA.
     * Source codes edited in IntelliJ IDEA Ultimate 2021.3.2
     */
}
