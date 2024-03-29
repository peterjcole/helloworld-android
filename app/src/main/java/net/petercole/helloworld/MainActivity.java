package net.petercole.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "net.petercole.helloworld.MESSAGE";
    public static final String RADIO_CHOSEN = "net.petercole.helloworld.RADIO_CHOSEN";
    static final int MESSAGE_PRESET_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //called when user taps send button
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        RadioGroup radioGroup = findViewById(R.id.colourGroup);
        int selectedID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedID);
        String text = radioButton.getText().toString();
        intent.putExtra(RADIO_CHOSEN, text);

        startActivityForResult(intent, MESSAGE_PRESET_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == MESSAGE_PRESET_REQUEST) {
            if(resultCode == RESULT_OK) {
                EditText editText = findViewById(R.id.editText);
                String presetMessage = data.getStringExtra(DisplayMessageActivity.PRESET_MESSAGE);
                editText.setText(presetMessage);
            }
        }
    }
}
