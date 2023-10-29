//----------------------------------------------------------------------\
// Author: Nicholas Frederick
// Submission Date: Oct 29, 2023
// Description: Android app that utilizes a database to store employee
// information, with full CRUD implemented.
//----------------------------------------------------------------------

package com.example.homework03_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    Button btn_j_addEmployee;
    ListView lv_j_listEmployees;
    Intent int_j_activity_register;
    Intent int_j_activity_employee_view_update;
    EmployeeData empData;
    EmployeeListAdapter employeeListAdapter;
    ArrayList<Employee> employeeArrayList;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerItems();
        registerEvents();
        empData = new EmployeeData();
        empData.initializeList();
        db = new DatabaseHelper(this);
        //Log.d("EmployeesInTableMain", db.numberOfRowsInTable() + "");
        employeeArrayList = db.getAllRows();
        for(int i = 0; i < employeeArrayList.size(); i++)
        {
            Log.d("Employee " + i, employeeArrayList.get(i).getUsername());
        }

        fillListView();
    }

    public void fillListView()
    {
        employeeListAdapter = new EmployeeListAdapter(this, employeeArrayList);
        //set the listviews adapter
        lv_j_listEmployees.setAdapter(employeeListAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1)
        {
            //
            Log.d("Success", "Success");
            DatabaseHelper db = new DatabaseHelper(this);
            Log.d("EmployeesInTableMain", db.numberOfRowsInTable() + "");
            employeeArrayList = db.getAllRows();
            fillListView();
        }
    }

    private void registerItems()
    {
        btn_j_addEmployee = findViewById(R.id.btn_v_addEmployee);
        lv_j_listEmployees = findViewById(R.id.lv_v_employeeList);
        int_j_activity_register = new Intent(MainActivity.this, activity_register.class);
        int_j_activity_employee_view_update = new Intent(MainActivity.this, EmployeeViewUpdateActivity.class);
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
                startActivityForResult(int_j_activity_register, 1);
                //startActivity(int_j_activity_register);
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
                int_j_activity_employee_view_update.putExtra("Employee", employeeArrayList.get(i));
                startActivityForResult(int_j_activity_employee_view_update, 1);
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
                db.deleteEmployee(employeeArrayList.get(i));
                employeeArrayList = db.getAllRows();
                fillListView();
                return false;
            }
        });
    }

}