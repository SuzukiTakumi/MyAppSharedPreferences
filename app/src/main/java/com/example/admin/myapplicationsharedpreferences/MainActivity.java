package com.example.admin.myapplicationsharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences dataStore;
    private TextView countTextView;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataStore = getSharedPreferences("dataStore", MODE_PRIVATE);
        count = dataStore.getInt("count", 0);

        countTextView = (TextView)findViewById(R.id.textView);
        countTextView.setText(String.valueOf(count));
    }

    public void countUp(View view){
        count++;
        countTextView.setText(String.valueOf(count));
        SharedPreferences.Editor editor = dataStore.edit();
        editor.putInt("count", count);
        editor.apply();
    }
}