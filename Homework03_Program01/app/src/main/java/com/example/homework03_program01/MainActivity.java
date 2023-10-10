package com.example.homework03_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{

    Button btn_j_addEmployee;
    ListView lv_j_listEmployees;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerItems();
        registerEvents();
    }

    private void registerItems()
    {
        btn_j_addEmployee = findViewById(R.id.btn_v_addEmployee);
        lv_j_listEmployees = findViewById(R.id.lv_v_employeeList);
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