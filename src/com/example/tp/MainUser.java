package com.example.tp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


public class MainUser {

    private static final String LOG_FILE = "error.log";

    public static void main(String[] args) {

        User[] users = {
            new User("Alice", 30),
            new User("", 25),
            new User("Bob", 16)
        };

        for (User u : users) {
            try {
                u.validate();
                System.out.println("Utilisateur validé : " + u);

            } catch (InvalidUserException e) {

                //Journalisation dans error.log
                try (FileWriter fw = new FileWriter(LOG_FILE, true);
                     PrintWriter pw = new PrintWriter(fw)) {

                    pw.println("[" + LocalDateTime.now() + "] Validation échouée");
                    pw.println("Utilisateur : " + u);
                    pw.println("Message : " + e.getMessage());
                    pw.println("------------------------------------");

                } catch (IOException io) {
                    // dernier recours (erreur critique)
                    io.printStackTrace();
                }
            }
        }
    }
}
