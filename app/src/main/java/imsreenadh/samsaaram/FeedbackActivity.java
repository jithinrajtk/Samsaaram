package imsreenadh.samsaaram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rey.material.widget.Button;
import com.rey.material.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    private Button btn_feedback;
    private EditText et_email;
    private EditText et_feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.btnFeedback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                et_email = (EditText) findViewById(R.id.email);
                et_feedback = (EditText) findViewById(R.id.feedbackText);

                if (et_email.getText().toString() == "" && et_feedback.getText().toString() == "") {
                    sendFeedback(et_email.getText().toString(), et_feedback.getText().toString());
                    toaster("ഫീഡ്ബാക്ക് അയയ്ക്കുന്നതിന് ദയവായി നിങ്ങളുടെ ഇ-മെയിൽ ക്ലയന്റ് തിരഞ്ഞെടുക്കുക!", Toast.LENGTH_LONG);
                } else {
                    toaster("ഫീൽഡുകൾ ശൂന്യമാക്കിയിടാൻ പാടില്ല. ഫീഡ്ബാക്ക് അയയ്ക്കുന്നതിന് ദയവായി വിശദാംശങ്ങൾ ടൈപ്പ് ചെയ്യുക!", Toast.LENGTH_LONG);
                }
            }
        });
    }


    private void toaster(String message, int duration) {
        Toast.makeText(getApplicationContext(), message, duration).show();
    }
    //Start a new activity for sending a feedback email

    private void sendFeedback(String senderEmailAddress, String feedbackContent) {
        final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/email")
                .putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"jithinrajtk@gmail.com"})
                .putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.app_name) + "[User Feedback]")
                .putExtra(android.content.Intent.EXTRA_TEXT, "Hi,\nReply To: " + senderEmailAddress + "\nContent:\n" + feedbackContent);
        startActivity(Intent.createChooser(intent, "Feedback"));
    }

}
