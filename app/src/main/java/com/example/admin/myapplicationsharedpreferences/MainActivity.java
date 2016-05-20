package com.example.admin.myapplicationsharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences dataStore;
    private EditText editText;
    private TextView textViewWrite, textViewRead;
    private Button buttonWrite, buttonRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataStore = getSharedPreferences("DataStore", MODE_PRIVATE);
        editText = (EditText) findViewById(R.id.edit_text);
        textViewWrite = (TextView) findViewById(R.id.textview_write);
        textViewRead = (TextView) findViewById(R.id.textview_read);
        buttonWrite = (Button) findViewById(R.id.button_write);
        buttonWrite.setOnClickListener(this);
        buttonRead = (Button) findViewById(R.id.button_read);
        buttonRead.setOnClickListener(this);
    }

    public void writeText(View view){
        String text = editText.getText().toString();
        textViewWrite.setText(text);

        SharedPreferences.Editor editor = dataStore.edit();
        editor.putString("input", text);
        editor.commit();

    }

    public void readText(View view){
        String text = dataStore.getString("input", "Nothing");
        if(!text.equals("Nothing")){
            textViewRead.setText(text);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == buttonWrite){
            writeText(view);
        }else if(view == buttonRead){
            readText(view);
        }
    }
}