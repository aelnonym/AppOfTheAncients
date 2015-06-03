package bota.cla.appoftheancients.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.digits.sdk.android.ContactsUploadResult;
import com.digits.sdk.android.ContactsUploadService;

/**
 * Created by Andrey on 03/06/2015.
 */
public class ContactsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ContactsUploadService.UPLOAD_COMPLETE.equals(intent.getAction())) {
            ContactsUploadResult result = intent
                    .getParcelableExtra(ContactsUploadService.UPLOAD_COMPLETE_EXTRA);

            Log.d("Result", result.toString());
        } else {
            Log.d("Result", "FAIL");
        }
    }
}