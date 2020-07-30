package com.example.homework_502;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PhotoActivity extends AppCompatActivity {

    private Button buttonBack;
    private Button buttonForward;
    private TextView textLink;
    int a = 0;
    int b = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        buttonBack = (Button) findViewById(R.id.btn_back);
        buttonForward = (Button) findViewById(R.id.btn_forward);
        textLink = (TextView) findViewById(R.id.textLink);

        textLink.setText("http://myfile.org/" + (a + (int) (Math.random() * b)));

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonForward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(PhotoActivity.this, PhotoActivity.class);
                startActivity(intent);
            }
        });
    }
}