package com.example.homework03_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmployeeViewUpdateActivity extends AppCompatActivity {


    TextView tv_j_firstname, tv_j_lastname, tv_j_email, tv_j_age, tv_j_password, tv_j_username;
    EditText et_j_firstname, et_j_lastname, et_j_email, et_j_age, et_j_password;
    Button btn_j_update, btn_j_finishactivity;
    private boolean updatingUser;
   // Employee employee = new Employee("usernameTest", "password", "firstnn", "lastnn", "email@email", "22");
    Employee employee;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_view_update);


        employee = (Employee) getIntent().getSerializableExtra("Employee");

        dbHelper = new DatabaseHelper(this);
        updatingUser = false;

        tv_j_firstname = findViewById(R.id.tv_v_evu_firstname);
        tv_j_lastname = findViewById(R.id.tv_v_evu_lastname);
        tv_j_username = findViewById(R.id.tv_v_evu_username);
        tv_j_age = findViewById(R.id.tv_v_evu_age);
        tv_j_email = findViewById(R.id.tv_v_evu_email);
        tv_j_password = findViewById(R.id.tv_v_evu_password);

        tv_j_username.setText(employee.getUsername());
        updateTextViews();

        et_j_age = findViewById(R.id.et_v_evu_age); et_j_age.setText(employee.getAge());
        et_j_password = findViewById(R.id.et_v_evu_password); et_j_password.setText(employee.getPassword());
        et_j_email = findViewById(R.id.et_v_evu_email); et_j_email.setText(employee.getEmail());
        et_j_firstname = findViewById(R.id.et_v_evu_fName); et_j_firstname.setText(employee.getFirstname());
        et_j_lastname = findViewById(R.id.et_v_evu_lName); et_j_lastname.setText(employee.getLastname());

        updateEditTextVisibility();


        btn_j_finishactivity = findViewById(R.id.btn_v_evu_finishactivity);
        btn_j_update = findViewById(R.id.btn_v_evu_update);
        updateButtonEvent();
        finishButtonEvent();
    }

    public void updateTextViews()
    {
        if(updatingUser)
        {
            tv_j_firstname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            tv_j_firstname.setGravity(Gravity.RIGHT);
            tv_j_firstname.setText("First Name");

            tv_j_lastname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            tv_j_lastname.setGravity(Gravity.RIGHT);
            tv_j_lastname.setText("Last Name");

            tv_j_password.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            tv_j_password.setGravity(Gravity.RIGHT);
            tv_j_password.setText("Password");

            tv_j_email.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            tv_j_email.setGravity(Gravity.RIGHT);
            tv_j_email.setText("Email");

            tv_j_age.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            tv_j_age.setGravity(Gravity.RIGHT);
            tv_j_age.setText("Age");
        }
        else
        {
            tv_j_firstname.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_j_firstname.setGravity(Gravity.CENTER);
            tv_j_firstname.setText("First Name: " + employee.getFirstname());

            tv_j_lastname.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_j_lastname.setGravity(Gravity.CENTER);
            tv_j_lastname.setText("Last Name: " + employee.getLastname());

            tv_j_password.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_j_password.setGravity(Gravity.CENTER);
            tv_j_password.setText("Password: " + employee.getPassword());

            tv_j_email.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_j_email.setGravity(Gravity.CENTER);
            tv_j_email.setText("Email: " + employee.getEmail());

            tv_j_age.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_j_age.setGravity(Gravity.CENTER);
            tv_j_age.setText("Age: " + employee.getAge());
        }
    }

    public void updateEditTextVisibility()
    {
        if(updatingUser)
        {
            et_j_lastname.setVisibility(View.VISIBLE);
            et_j_firstname.setVisibility(View.VISIBLE);
            et_j_age.setVisibility(View.VISIBLE);
            et_j_email.setVisibility(View.VISIBLE);
            et_j_password.setVisibility(View.VISIBLE);
        }
        else
        {
            et_j_lastname.setVisibility(View.INVISIBLE);
            et_j_firstname.setVisibility(View.INVISIBLE);
            et_j_age.setVisibility(View.INVISIBLE);
            et_j_email.setVisibility(View.INVISIBLE);
            et_j_password.setVisibility(View.INVISIBLE);
        }
    }

    public void updateButtonEvent()
    {
        btn_j_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(updatingUser)
                {
                    updatingUser = false;
                    btn_j_update.setText("Update");
                    //Save changes
                    employee.setAge(et_j_age.getText().toString());
                    employee.setEmail(et_j_email.getText().toString());
                    employee.setFirstname(et_j_firstname.getText().toString());
                    employee.setPassword(et_j_password.getText().toString());
                    employee.setLastname(et_j_lastname.getText().toString());

                    dbHelper.updateUser(employee);
                }
                else
                {
                    updatingUser = true;
                    btn_j_update.setText("Save Changes");
                }

                updateEditTextVisibility();
                updateTextViews();
            }
        });
    }

    public void finishButtonEvent()
    {
        btn_j_finishactivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                setResult(1, intent);
                finish();
            }
        });
    }
}