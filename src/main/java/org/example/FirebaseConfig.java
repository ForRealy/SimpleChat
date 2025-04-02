package org.example;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseConfig {
    private static final String DB_URL = "https://simplechat-5f219-default-rtdb.europe-west1.firebasedatabase.app/";
    private static final String SERVICE_ACCOUNT_PATH = "src/main/resources/simplechat-5f219-firebase-adminsdk-fbsvc-1ab4ce8f81.json";
    private static DatabaseReference database;

    public static DatabaseReference getDatabaseReference() {
        if (database == null) {
            try {
                FileInputStream serviceAccount = new FileInputStream(SERVICE_ACCOUNT_PATH);
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl(DB_URL)
                        .build();
                FirebaseApp.initializeApp(options);
                database = FirebaseDatabase.getInstance().getReference("messages");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return database;
    }
}
