package com.example.homework03_program01;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EmployeeListAdapter extends BaseAdapter
{

    ArrayList<Employee> employeeArrayList;
    Context context;
    public EmployeeListAdapter(Context c, ArrayList<Employee> empArrList)
    {
        employeeArrayList = empArrList;
        context = c;
    }
    @Override
    public int getCount() {
        return employeeArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return employeeArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.employee_cell, null);
        }
        Employee employee = employeeArrayList.get(i);
        TextView fullname = view.findViewById(R.id.tv_v_e_fullname);
        TextView username = view.findViewById(R.id.tv_v_e_username);
        fullname.setText(employee.getLastname() + ", " + employee.getFirstname());
        username.setText(employee.getUsername());

        return view;
    }
}
