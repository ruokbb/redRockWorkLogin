package com.example.redrockwork;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        Button registerbutton =  findViewById(R.id.button3);


        //下拉框的设置
        List<String> list  = new ArrayList<String>();
        list.add("男");
        list.add("女");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        //本地文件持久化
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                EditText nameedit = findViewById(R.id.editText5);
                EditText phoneedit = findViewById(R.id.editText4);
                EditText passwordedit = findViewById(R.id.editText3);
                Spinner spinner = findViewById(R.id.spinner);
                String putname = nameedit.getText().toString();
                String putphone = phoneedit.getText().toString();
                String putpassword = passwordedit.getText().toString();
                String sex = spinner.getSelectedItem().toString();
                if (putname.isEmpty() || putphone.isEmpty() || putpassword.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "输入错误", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("name", putname);
                    editor.putString("phone", putphone);
                    editor.putString("password", putpassword);
                    editor.putString("sex",sex);
                    editor.apply();
                    finish();
                }
            }
        });



    }
}
