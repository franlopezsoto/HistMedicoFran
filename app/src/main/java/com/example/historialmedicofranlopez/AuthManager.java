package com.example.historialmedicofranlopez;

import android.app.Activity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthManager {
    private final FirebaseAuth mAuth;

    public AuthManager() {
        mAuth = FirebaseAuth.getInstance();
    }

    public void signInAnonymously(Activity activity) {
        mAuth.signInAnonymously().addOnCompleteListener(activity, task -> {
            if (task.isSuccessful()) {
                Log.d("AuthManager", "Signed in anonymously");
            } else {
                Log.w("AuthManager", "signInAnonymously:failure", task.getException());
            }
        });
    }

    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }
}

}
