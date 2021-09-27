package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Analyzer {
    public void analyze() throws IOException {
        StringBuilder inputBuilder = new StringBuilder("");
        StringBuilder outputBuilder = new StringBuilder();

        Scanner scanner = new Scanner(new File("D:\\mss\\lab1\\src\\input.txt"));
        String delimeter = " ";
        while(scanner.hasNextLine()){
            inputBuilder.append(scanner.nextLine());
            inputBuilder.append("\n");
        }

        String st = inputBuilder.toString();
        String[] y = st.split(delimeter);
        for (String o : y){
            outputBuilder.append(correction(o) + " ");
        }

        FileWriter fileWriter = new FileWriter("D:\\mss\\lab1\\src\\output.txt");
        fileWriter.write(outputBuilder.toString());

        fileWriter.flush();
    }

    public String correction(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                count++;
            }
        }
        if (count > str.length() - count) {

            return stringBuilder.toString().toUpperCase(Locale.ROOT);
        } else if (count < str.length() - count) {

            if(Character.isUpperCase(stringBuilder.charAt(0))){
               return stringBuilder.toString().substring(0,1) + stringBuilder.toString().substring(1).toLowerCase(Locale.ROOT);
            }
            return stringBuilder.toString().toLowerCase(Locale.ROOT);
        }

        return stringBuilder.toString();
    }
}
