package com.jbn.study.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * FileOperation
 */
public class FileOperation {
    public static boolean readFileWordToArray(String filename, ArrayList<String> words) {
        if (filename == null || words == null) {
            System.out.println("filename is null words is null");
            return false;
        }

        Scanner scanner;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fileInputStream), StandardCharsets.UTF_8);
                scanner.useLocale(Locale.ENGLISH);
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println("Can not open " + filename);
            return false;
        }

        if (scanner.hasNextLine()) {
            // \A The beginning of the input
            // All contents of file
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length();) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i);
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i++;
                }
            }
        }

        scanner.close();

        return true;
    }

    private static int firstCharacterIndex(String s, int start) {
        for (int j = start; j < s.length(); j++) {
            if (Character.isLetter(s.charAt(j))) {
                return j;
            }
        }
        return s.length();
    }
}