package org.example;

import com.google.firebase.database.DatabaseReference;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseReference database = FirebaseConfig.getDatabaseReference();
        ChatListener.setupMessageListener(database);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            ChatCommand.handleCommand(input, database);
        }
    }
}
