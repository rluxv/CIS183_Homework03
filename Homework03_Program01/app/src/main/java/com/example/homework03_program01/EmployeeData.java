package com.example.homework03_program01;

import java.util.ArrayList;

public class EmployeeData
{
    private static ArrayList<Employee> employeeArrayList;

    public void initializeList()
    {
        employeeArrayList = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployeeList()
    {
        return employeeArrayList;
    }


}
