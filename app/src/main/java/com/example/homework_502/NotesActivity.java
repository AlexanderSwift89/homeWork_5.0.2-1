package com.example.homework_502;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {

    private EditText mInputNote;
    private Button mBtnSaveNote;
    private final static String NOTE_TEXT = "note_text";
    private static final String SHARED_KEY_TEXT="shared_key_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        initViews();

        String saveText = getSavedText();
        mInputNote.setText(saveText);

        mBtnSaveNote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String noteTxt = mInputNote.getText().toString();
                saveText(noteTxt);
            }
        });
    }

    private String getSavedText(){
        return getSharedPreferences(NOTE_TEXT, MODE_PRIVATE).getString(SHARED_KEY_TEXT," ");
    }

    private void saveText(String noteTxt){
        SharedPreferences myEditor = getSharedPreferences(NOTE_TEXT, MODE_PRIVATE);
        myEditor.edit()
                .putString(SHARED_KEY_TEXT, noteTxt)
                .apply();
        Toast.makeText(NotesActivity.this, "данные сохранены", Toast.LENGTH_LONG).show();
    }

    private void initViews(){
        mInputNote = findViewById(R.id.inputNote);
        mBtnSaveNote = findViewById(R.id.btnSaveNote);
    }
}