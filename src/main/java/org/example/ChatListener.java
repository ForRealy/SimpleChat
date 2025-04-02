package org.example;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;

public class ChatListener {
    public static void setupMessageListener(DatabaseReference database) {
        Query lastMessagesQuery = database.limitToLast(10);
        lastMessagesQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("\n--- Historial de mensajes (últimos 10) ---");
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    String message = messageSnapshot.getValue(String.class);
                    System.out.println(message);
                }
                System.out.print("> ");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println("Error en Firebase: " + error.getMessage());
            }
        });
    }
}
