package com.example.homework_502;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PressureActivity extends AppCompatActivity {

    private static final String TAG = PressureActivity.class.getSimpleName();

    private EditText upPressure;
    private EditText lowPressure;
    private EditText pulse;
    private CheckBox checkTach;
    private TextView timeTxt;
    private TextView dataTxt;
    private Button btnSavePressure;
    private Button btnBack;

    DataPressureActivity dataStorage = new DataPressureActivity();

    Date currentDate = new Date();// Текущее время
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());// Форматирование времени как "день.месяц.год"
    String dateText = dateFormat.format(currentDate);
    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());// Форматирование времени как "часы:минуты:секунды"
    String timeText = timeFormat.format(currentDate);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        init();
        timeTxt.setText(dateText);
        dataTxt.setText(timeText);

        btnSavePressure.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Saved button clicked on the PressureActivity");
                String upPressureStr = upPressure.getText().toString();
                String lowPressureStr = lowPressure.getText().toString();
                String pulseStr = pulse.getText().toString();
                boolean checkTachCbx = checkTach.isChecked();

                dataStorage.setUpPressure(upPressureStr);
                dataStorage.setLowPressure(lowPressureStr);
                dataStorage.setPulse(pulseStr);

                try{
                    int upper = Integer.parseInt(upPressureStr);
                    int lower = Integer.parseInt(lowPressureStr);
                    int pulseInt = Integer.parseInt(pulseStr);

                    String result = getString(R.string.upPressure_input) + ": " + upper + " " +
                            getString(R.string.lowPressure_input) + ": " + lower + " " + getString(R.string.pulse_input) +
                            ": " + pulseInt + " " + getString(R.string.tach_checkbox) + ": " + checkTachCbx + " " +
                            getString(R.string.data_text) + ": " + dateText + " " + getString(R.string.time_text) + ": " + timeText;
                    Toast.makeText(PressureActivity.this, result, Toast.LENGTH_LONG).show();
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(PressureActivity.this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }
                finally{
                    upPressure.getText().clear();
                    lowPressure.getText().clear();
                    pulse.getText().clear();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Pressure Back button clicked on the PressureActivity");
                Intent intent = new Intent(PressureActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        upPressure = findViewById(R.id.upPressure);
        lowPressure = findViewById(R.id.name);
        pulse = findViewById(R.id.pulse);
        checkTach = findViewById(R.id.checkTach);
        timeTxt = findViewById(R.id.timeTxt);
        dataTxt = findViewById(R.id.dataTxt);
        btnSavePressure = findViewById(R.id.btnSavePressure);
        btnBack = findViewById(R.id.btnBack);
        Log.d(TAG, "All views initialized on the PressureActivity");
    }
}