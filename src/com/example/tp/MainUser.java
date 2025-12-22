package com.example.tp;

public class MainUser {
    public static void main(String[] args) {
        User[] users = {
            new User("Alice", 30),
            new User("", 22),
            new User("Bob", 16)
        };

        for (User u : users) {
            try {
                u.validate();
                System.out.println("Utilisateur valide : " + u);
            } catch (InvalidUserException e) {
                LoggerUtil.log("Erreur validation utilisateur", e);
            }
        }
    }
}
