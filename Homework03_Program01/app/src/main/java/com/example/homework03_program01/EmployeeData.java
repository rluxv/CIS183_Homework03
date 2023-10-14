package com.example.homework03_program01;

import java.util.ArrayList;

public class EmployeeData
{
    public static ArrayList<Employee> employeeArrayList;

    public void initializeList()
    {
        employeeArrayList = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployeeList()
    {
        return employeeArrayList;
    }

    public boolean usernameAlreadyExists(String username)
    {
        //if there are no users in the arraylist, then we would return false
        if(employeeArrayList.size() == 0)
        {
            return false;
        }
        for(int i = 0; i < employeeArrayList.size(); i++)
        {
            if(employeeArrayList.get(i).getUsername().equalsIgnoreCase(username))
            {
                return true;
            }
        }
        //if the function can get thru the loop without returning true, then there are no users in the arraylist that have the same username
        return false;
    }

}
