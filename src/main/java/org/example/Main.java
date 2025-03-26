package org.example;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    private static DatabaseReference database;
    private static String nickname = "Anónimo";

    public static void main(String[] args) throws Exception {
        // Inicializar Firebase
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/simplechat-5f219-firebase-adminsdk-fbsvc-047f6f8083.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(
                        "https://simplechat-5f219-default-rtdb.europe-west1.firebasedatabase.app/")
                .build();
        FirebaseApp.initializeApp(options);

        database = FirebaseDatabase.getInstance().getReference("messages");
        setupMessageListener();

        // Leer comandos del usuario
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            handleCommand(input);
        }
    }

    private static void setupMessageListener() {
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    String message = messageSnapshot.getValue(String.class);
                    System.out.println("\n" + message);
                    System.out.print("> "); // Para mantener el prompt visible
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println("Error en Firebase: " + error.getMessage());
            }
        });
    }

    private static void handleCommand(String input) {
        if (input.startsWith("/nick ")) {
            nickname = input.split(" ")[1];
            System.out.println("Ahora eres: " + nickname);
        } else if (!input.isEmpty()) {
            database.push().setValueAsync(nickname + ": " + input);
        }
    }
}