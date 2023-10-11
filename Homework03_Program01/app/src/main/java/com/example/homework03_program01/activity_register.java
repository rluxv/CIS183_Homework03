package com.example.homework03_program01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class activity_register extends AppCompatActivity
{

    EditText et_j_fName, et_j_lName, et_j_email, et_j_age, et_j_username, et_j_password;
    Button btn_j_addEmployee, btn_j_returnToMain;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerItems();

    }

    public void registerItems()
    {
        et_j_fName = findViewById(R.id.et_v_r_fName);
        et_j_lName = findViewById(R.id.et_v_r_lName);
        et_j_email = findViewById(R.id.et_v_r_email);
        et_j_age = findViewById(R.id.et_v_r_age);
        et_j_username = findViewById(R.id.et_v_r_username);
        et_j_password = findViewById(R.id.et_v_r_password);
        btn_j_addEmployee = findViewById(R.id.btn_v_r_addEmployee);
        btn_j_returnToMain = findViewById(R.id.btn_v_r_returnToMain);
    }

}
