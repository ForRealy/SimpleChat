package org.example;

import com.google.firebase.database.DatabaseReference;

public class ChatCommand {
    private static String nickname = "Anónimo";

    public static void handleCommand(String input, DatabaseReference database) {
        if (input.startsWith("/nick ")) {
            String[] parts = input.split(" ");
            if (parts.length >= 2) {
                nickname = parts[1];
                System.out.println("Ahora eres: " + nickname);
            }
        } else if (!input.isEmpty()) {
            database.push().setValueAsync(nickname + ": " + input);
        }
    }
}
