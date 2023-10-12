package com.example.homework03_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{

    Button btn_j_addEmployee;
    ListView lv_j_listEmployees;
    Intent int_j_activity_register;
    EmployeeData empData;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerItems();
        registerEvents();
        empData = new EmployeeData();
        empData.initializeList();
    }

    private void registerItems()
    {
        btn_j_addEmployee = findViewById(R.id.btn_v_addEmployee);
        lv_j_listEmployees = findViewById(R.id.lv_v_employeeList);
        int_j_activity_register = new Intent(MainActivity.this, activity_register.class);
    }

    private void registerEvents()
    {
        addEmployeeButtonEvent();
        employeeListLongPressEvent();
        employeeListShortPressEvent();
    }

    private void addEmployeeButtonEvent()
    {
        btn_j_addEmployee.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(int_j_activity_register);
            }
        });
    }

    private void employeeListShortPressEvent()
    {
        lv_j_listEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

            }
        });
    }

    private void employeeListLongPressEvent()
    {
        lv_j_listEmployees.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                return false;
            }
        });
    }

}