package com.example.homework_502;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LifeWriteActivity extends AppCompatActivity {

    private static final String TAG = LifeWriteActivity.class.getSimpleName();

    private EditText weight;
    private EditText numOfSteps;
    private Button btnSave;
    private Button btnBack;

    DataLifeWriteActivity dataStorage = new DataLifeWriteActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_write);
        init();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Saved button clicked on the LifeWriteActivity");
                String weightStr = weight.getText().toString();
                String numOfStepsStr = numOfSteps.getText().toString();

                dataStorage.setWeight(weightStr);
                dataStorage.setNumOfSteps(numOfStepsStr);

                try {
                    int weightInt = Integer.parseInt(weightStr);
                    int numOfStepsInt = Integer.parseInt(numOfStepsStr);

                    String result = getString(R.string.weight_input) + ": " + weightInt + " " +
                            getString(R.string.numOfSteps_input) + ": " + numOfStepsInt;
                    Toast.makeText(LifeWriteActivity.this, result, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(LifeWriteActivity.this, R.string.incorrect_value, Toast.LENGTH_SHORT).show();
                } finally {
                    weight.getText().clear();
                    numOfSteps.getText().clear();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Pressure Back button clicked on the LifeWriteActivity");
                Intent intent = new Intent(LifeWriteActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        weight = findViewById(R.id.weight);
        numOfSteps = findViewById(R.id.numOfSteps);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack);
        Log.d(TAG, "All views initialized on the LifeWriteActivity");
    }
}