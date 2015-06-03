package bota.cla.appoftheancients.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.digits.sdk.android.Contacts;
import com.digits.sdk.android.ContactsCallback;
import com.digits.sdk.android.Digits;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;

import bota.cla.appoftheancients.R;

/**
 * Created by Andrey on 03/06/2015.
 */
public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        Button contactsButton = ((Button) findViewById(R.id.button_contacts));

        contactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showContacts();
            }
        });
    }

    private void showContacts(){
        Digits.getInstance().getContactsClient().lookupContactMatches(null, null,
                new ContactsCallback<Contacts>() {

                    @Override
                    public void success(Result<Contacts> result) {
                        if (result.data.users != null) {
                            Log.d("Result", result.toString());
                        }
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        Log.d("Result", exception.toString());
                    }
                });
    }

}
