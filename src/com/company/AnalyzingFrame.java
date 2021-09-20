package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class AnalyzingFrame extends JFrame {

    private JButton analyzeButton = new JButton("");

    AnalyzingFrame(String code){
        Analyzer analyzer = new Analyzer();

        this.setTitle("eliminating the effect of accidentally pressing Caps Lock");
        this.setSize(300,200);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocation(700,350);

        analyzeButton.setText(code.toUpperCase(Locale.ROOT));
        analyzeButton.setSize(250,50);
        analyzeButton.setLocation(20,95);
        analyzeButton.setVisible(true);

        this.add(analyzeButton);

        analyzeButton.addActionListener(e -> {
            try {
                analyzer.analyze();

            }
            catch (IOException ioException) {
                    ioException.printStackTrace();
                }
        });
    }
}
