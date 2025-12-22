package com.example.tp;

import java.io.*;
import java.time.LocalDateTime;

public class LoggerUtil {

    private static final String LOG_FILE = "error.log";

    public static void log(String message, Exception e) {
        System.err.println(message + " : " + e.getMessage());

        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("[" + LocalDateTime.now() + "] " + message);
            e.printStackTrace(pw);
            pw.println("----------------------------------");

        } catch (IOException io) {
            System.err.println("Impossible d'écrire dans le fichier log");
        }
    }
}
