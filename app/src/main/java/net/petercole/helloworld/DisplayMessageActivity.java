package net.petercole.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String colour = intent.getStringExtra(MainActivity.RADIO_CHOSEN);

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        if (colour.equals("Red")) {
            textView.setTextColor(Color.RED);
        } else if (colour.equals("Green")) {
            textView.setTextColor(Color.GREEN);
        } else if (colour.equals("Blue")) {
            textView.setTextColor(Color.BLUE);
        } else {
            textView.setText(colour);
        }
    }
}
