package com.example.homework_502;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Настройки...", Toast.LENGTH_LONG).show();
        }else if (id == R.id.action_exit) {
            Toast.makeText(MainActivity.this, "Выход...", Toast.LENGTH_LONG).show();
            finish();
            //return true;
        }else if (id == R.id.action_subscribe) {
            Toast.makeText(MainActivity.this, "Переход на страницу Подписки...", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(MainActivity.this, SubscribeActivity.class);
            startActivity(intentNotes);
        }else if (id == R.id.action_photo) {
            Toast.makeText(MainActivity.this, "Переход на страницу Просмотра фотографий...", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(MainActivity.this, PhotoActivity.class);
            startActivity(intentNotes);
        }else if (id == R.id.action_health) {
            Toast.makeText(MainActivity.this, "Переход на страницу Мониторинг здоровья...", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(MainActivity.this, HealthActivity.class);
            startActivity(intentNotes);
        }else if (id == R.id.action_payment) {
            Toast.makeText(MainActivity.this, "Переход на страницу Оплата услуг...", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(MainActivity.this, PaymentActivity.class);
            startActivity(intentNotes);
        }else if (id == R.id.action_input_address) {
            Toast.makeText(MainActivity.this, "Переход на стрианицу Ваш адрес...", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(MainActivity.this, AddressActivity.class);
            startActivity(intentNotes);
        }else if (id == R.id.action_planner) {
            Toast.makeText(MainActivity.this, "Переход на стрианицу Планировщика...", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(MainActivity.this, PlanningActivity.class);
            startActivity(intentNotes);
        }else if (id == R.id.action_open_notes) {
            Toast.makeText(MainActivity.this, "Переход на страницу Записная книжка...", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intentNotes);
        }
        return super.onOptionsItemSelected(item);
    }
}