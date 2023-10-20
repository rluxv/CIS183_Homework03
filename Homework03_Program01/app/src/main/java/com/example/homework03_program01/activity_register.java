package com.example.homework03_program01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class activity_register extends AppCompatActivity
{

    EditText et_j_fName, et_j_lName, et_j_email, et_j_age, et_j_username, et_j_password;
    Button btn_j_addEmployee, btn_j_returnToMain;

    DatabaseHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerItems();
        registerEventListeners();

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

    public void registerEventListeners()
    {
        returnToMainButtonEvent();
        registerButtonEvent();
    }
    public void returnToMainButtonEvent()
    {
        btn_j_returnToMain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //this closes the activity and takes us back to the previous activity.
                finish();
            }
        });
    }

    public void registerButtonEvent()
    {
        btn_j_addEmployee.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(textboxesFilled())
                {
                    //Register
                    String username = et_j_username.getText().toString();
                    String password = et_j_password.getText().toString();
                    String firstname = et_j_fName.getText().toString();
                    String lastname = et_j_lName.getText().toString();
                    String email = et_j_email.getText().toString();
                    String age = et_j_age.getText().toString();
                    Employee employee = new Employee(username, password, firstname, lastname, email, age);
                    //dbHelper.addEmployee();
                }
            }
        });
    }

    public boolean textboxesFilled()
    {
        boolean returnStatement = true;
        if(et_j_fName.getText().toString().equals(""))
        {
            et_j_fName.setError("Text must not be blank.");
            returnStatement = false;
        }

        if(et_j_lName.getText().toString().equals(""))
        {
            et_j_lName.setError("Text must not be blank.");
            returnStatement = false;
        }

        if(et_j_username.getText().toString().equals(""))
        {
            et_j_username.setError("Text must not be blank.");
            returnStatement = false;
        }

        if(et_j_email.getText().toString().equals(""))
        {
            et_j_email.setError("Text must not be blank.");
            returnStatement = false;
        }

        if(et_j_password.getText().toString().equals(""))
        {
            et_j_password.setError("Text must not be blank.");
            returnStatement = false;
        }

        if(et_j_age.getText().toString().equals(""))
        {
            et_j_age.setError("Text must not be blank.");
            returnStatement = false;
        }

        return returnStatement;
    }
    public void registerUser()
    {

    }

}
