package com.example.lab2sebastiansalazar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayMessageActivity extends AppCompatActivity {
    TextView textViewDisplayMessage;
    EditText editTextNewMessage;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        textViewDisplayMessage = findViewById(R.id.textViewDisplayMessage);
        editTextNewMessage = findViewById(R.id.editTextNewMessage);
        buttonSend = findViewById(R.id.buttonSend);

        // Mostrar el mensaje recibido de MainActivity
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("message")) {
            String message = intent.getStringExtra("message");
            textViewDisplayMessage.setText(message);
        }

        // Enviar mensaje desde DisplayMessageActivity
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newMessage = editTextNewMessage.getText().toString();
                textViewDisplayMessage.append("\n" + newMessage);
                editTextNewMessage.getText().clear();
            }
        });
    }
}


