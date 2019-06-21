package net.petercole.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    public static String PRESET_MESSAGE = "net.petercole.helloworld.PRESET_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String colour = intent.getStringExtra(MainActivity.RADIO_CHOSEN);

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        textView.setTextColor(Color.parseColor(colour));

    }

    public void savePreset(View view) {
        Intent data = new Intent();
        Spinner spinner = findViewById(R.id.spinner);
        String selectedText = spinner.getSelectedItem().toString();
        data.putExtra(PRESET_MESSAGE, selectedText);
        setResult(RESULT_OK, data);
        finish();
    }

}
