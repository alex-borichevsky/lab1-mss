package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MainWindow extends JFrame {

    public MainWindow(){

        this.setTitle("Eliminating the effect of accidentally pressing Caps Lock");
        this.setSize(700,500);
        this.setLocation(500,200);

        fileChooser.setCurrentDirectory(new File("D:\\mss\\lab1\\src"));

        fileMenu.add(open);
        fileMenu.add(save);

        fileTextArea.setLocation(10,10);
        fileTextArea.setSize(700,500);
        fileTextArea.setLineWrap(true);
        fileTextArea.setVisible(true);

        this.add(fileTextArea);

        menuBar.add(fileMenu);
        analyzeMenu.add(textAnalyze);
        menuBar.add(analyzeMenu);

        this.setJMenuBar(menuBar);

        textAnalyze.addActionListener(e -> {
            AnalyzingFrame codeFrame = new AnalyzingFrame("analyze text");
            codeFrame.setLayout(null);
            codeFrame.setVisible(true);
        });

        open.addActionListener(e -> {
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();

                Scanner scan = null;
                try {
                    scan = new Scanner(selectedFile);

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                String document = "";

                while(scan.hasNextLine()) {
                    document += scan.nextLine();
                    document += "\n";
                }

                fileTextArea.setText(document);
            }
        });
        save.addActionListener(e -> {
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(selectedFile);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    fileWriter.write(fileTextArea.getText());
                    fileWriter.flush();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        this.setLayout(null);
        this.setVisible(true);
    }

    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();

    private JMenu fileMenu = new JMenu("File");
    private JMenu analyzeMenu = new JMenu("Analyze");

    private JMenuItem open = new JMenuItem("Open file");
    private JMenuItem save = new JMenuItem("Save file");
    private JMenuItem textAnalyze = new JMenuItem("Assaying");

    public static JTextArea fileTextArea = new JTextArea("some text");

}
