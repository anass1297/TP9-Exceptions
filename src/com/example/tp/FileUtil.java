package com.example.tp;

import java.io.*;
import java.util.*;

public class FileUtil {

    public static List<Integer> readNumbers(String path) {
        List<Integer> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    list.add(Integer.parseInt(line));
                }
            }
        } catch (IOException | NumberFormatException e) {
            LoggerUtil.log("Erreur lecture fichier", e);
        }
        return list;
    }
}
