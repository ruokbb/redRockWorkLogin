package com.example.redrockwork;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        Button buttonRegister =  findViewById(R.id.button2);
        Button buttonlogin =  findViewById(R.id.button);
        buttonRegister.setOnClickListener(this);
        buttonlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        switch(v.getId()){
            case R.id.button2:
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.button:
                EditText nameedit = findViewById(R.id.editText);
                EditText passwordedit = findViewById(R.id.editText2);
                String name= pref.getString("name","null");
                String password = pref.getString("password","null");
                String putname  = nameedit.getText().toString();
                String putpassword = passwordedit.getText().toString();
                if(putname.equals(name)&&putpassword.equals(password)){
                    Intent intent1 = new Intent(LoginActivity.this,InformationActivity.class);
                    startActivity(intent1);
                    break;
                }
                else{
                    Toast.makeText(LoginActivity.this,"输入错误",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

