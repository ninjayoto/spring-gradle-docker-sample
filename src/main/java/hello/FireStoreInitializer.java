package hello;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FireStoreInitializer {
    private static final Logger logger = LogManager.getLogger(FireStoreInitializer.class);

    @PostConstruct
    public void intitalize() {
        try {


            FileInputStream serviceAccount =
                    new FileInputStream("firebase.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://MY_FIREBASE.firebaseio.com")
                    .build();

            logger.debug(options.getServiceAccountId());
            logger.debug(options);

            FirebaseApp.initializeApp(options);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



