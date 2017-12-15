package com.example.redrockwork;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        setContentView(R.layout.activity_information);

        String putname = pref.getString("name","未知错误");
        String putphone = pref.getString("phone","未知错误");
        String putsex = pref.getString("sex","未知错误");

        TextView textView = findViewById(R.id.name);
        TextView textView1 = findViewById(R.id.phone);
        TextView textView2 = findViewById(R.id.sex);


        textView.setText(putname);
        textView1.setText(putphone);
        textView2.setText(putsex);
    }
}
