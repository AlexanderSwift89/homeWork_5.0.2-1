package com.example.homework_502;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

public class HealthActivity extends AppCompatActivity {

    private static final String TAG = HealthActivity.class.getSimpleName();

    private EditText inputName;
    private EditText inputSurname;
    private EditText inputSecondName;
    private EditText inputAge;
    private Button btnSave;
    private Button btnPressureData;
    private Button btnLifeData;

    DataMainActivity dataStorage = new DataMainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        init();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d(TAG,"Saved button clicked on the MainActivity");
                String inputNameStr = inputName.getText().toString();
                String inputSurnameStr = inputSurname.getText().toString();
                String inputSecondNameStr = inputSecondName.getText().toString();
                String inputAgeStr = inputAge.getText().toString();

                dataStorage.setName(inputNameStr);
                dataStorage.setSurname(inputSurnameStr);
                dataStorage.setSecondName(inputSecondNameStr);
                dataStorage.setAge(inputAgeStr);

                try{
                    int age = Integer.parseInt(inputAgeStr);

                    String result = getString(R.string.name_input) + " " + inputNameStr + ": " +
                            getString(R.string.surname_input) + " " + inputSurnameStr + ": " +
                            getString(R.string.secondName_input) + " " + inputSecondNameStr + ": " +
                            getString(R.string.age_input) + " " + inputAgeStr;
                    Toast.makeText(HealthActivity.this, result, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(HealthActivity.this, R.string.incorrect_value, Toast.LENGTH_SHORT).show();
                } finally {
                    inputName.getText().clear();
                    inputSurname.getText().clear();
                    inputSecondName.getText().clear();
                    inputAge.getText().clear();
                }
            }
        });

        btnPressureData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d(TAG,"PressureData button clicked on the MainActivity");
                Intent intent = new Intent(HealthActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        btnLifeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d(TAG,"LifeData button clicked on the MainActivity");
                Intent intent = new Intent(HealthActivity.this, LifeWriteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        inputName = findViewById(R.id.name);
        inputSurname = findViewById(R.id.inputSurname);
        inputSecondName = findViewById(R.id.inputSecondName);
        inputAge = findViewById(R.id.inputAge);
        btnSave = findViewById(R.id.btnSave);
        btnPressureData = findViewById(R.id.btnPressureData);
        btnLifeData = findViewById(R.id.btnLifeData);
        Log.d(TAG,"All views initialized on the MainActivity");
    }
}