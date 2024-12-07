package com.example.shoescenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etMessage = findViewById(R.id.etMessage);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String message = etMessage.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !message.isEmpty()) {
                    // Create the email intent
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("message/rfc822");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ghadachnini17@gmail.com"}); // Receiver's email
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Message from " + name); // Subject of the email
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\nEmail: " + email + "\nMessage: " + message); // Message body

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                        Toast.makeText(ContactActivity.this, "Message envoyé!", Toast.LENGTH_SHORT).show();
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(ContactActivity.this, "No email client found.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ContactActivity.this, "Veuillez remplir tous les champs!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
