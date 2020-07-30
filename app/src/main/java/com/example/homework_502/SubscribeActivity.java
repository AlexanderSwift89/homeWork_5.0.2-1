package com.example.homework_502;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.homework_502.R.id.buttonOk;


public class SubscribeActivity extends AppCompatActivity {

    public EditText inputUserName;
    public EditText inputEmailName;
    private TextView messageOutput;
    public Button buttonOk;
    public Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        inputUserName = (EditText) findViewById(R.id.inputUserName);
        inputEmailName = (EditText) findViewById(R.id.inputEmailName);
        messageOutput = (TextView) findViewById(R.id.messageOutput);
        buttonOk = (Button) findViewById(R.id.buttonOk);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        buttonOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Editable userName = inputUserName.getText();
                Editable emailName = inputEmailName.getText();
                messageOutput.setText ("Подписка на рассылку успешно оформлена для пользователя " + userName + " на электронный адрес " + emailName);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputUserName.setText(" ");
                inputEmailName.setText(" ");
                messageOutput.setText (" ");
            }
        });
    }
}