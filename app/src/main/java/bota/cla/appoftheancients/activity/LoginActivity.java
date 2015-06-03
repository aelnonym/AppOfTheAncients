package bota.cla.appoftheancients.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;

import bota.cla.appoftheancients.R;

/**
 * Created by Andrey on 03/06/2015.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DigitsAuthButton digitsButton =
                (DigitsAuthButton) findViewById(R.id.auth_button);
        digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session,
                                String phoneNumber) {
                Toast.makeText(LoginActivity.this, "Logged-in: Asking for contacts.", Toast.LENGTH_SHORT).show();
                Digits.getInstance().getContactsClient().startContactsUpload();
            }

            @Override
            public void failure(DigitsException exception) {
                Toast.makeText(LoginActivity.this, "Could not log-in", Toast.LENGTH_SHORT).show();
            }
        });
        
    }




}
