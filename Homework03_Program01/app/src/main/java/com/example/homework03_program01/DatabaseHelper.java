package com.example.homework03_program01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String DATABASENAME = "Employees.db";
    public static final String TABLENAME = "Employees";
    public DatabaseHelper(Context context)
    {
        super(context,DATABASENAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        //Create the database table
        //Fields: username (Primary Key), password, first name, last name, email, age
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLENAME + " (username PRIMARY KEY NOT NULL, password TEXT, firstname TEXT, lastname TEXT, email TEXT, age TEXT);");
    }

    public void addEmployee(Employee employee)
    {

        //I am using the .replace function to make sure I don't mess up the SQL code
        String sqlExecStatement = "INSERT INTO " + TABLENAME + " VALUES ('USR','PASS','FNME','LNME','EML','AGE');"
                .replace("USR", employee.getUsername())
                .replace("PASS", employee.getPassword())
                .replace("FNME", employee.getFirstname())
                .replace("LNME", employee.getLastname())
                .replace("EML", employee.getEmail())
                .replace("AGE", employee.getAge());
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //Add employee to database
        sqLiteDatabase.execSQL(sqlExecStatement);

        //Add employee to arraylist
        EmployeeData.employeeArrayList.add(employee);

        //Must close database after finished writing
        sqLiteDatabase.close();
    }

    public void deleteEmployee(Employee employee)
    {
        //get writable copy of db
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //delete employee from db
        sqLiteDatabase.execSQL("DELETE FROM " + TABLENAME + " WHERE username = '" + employee.getUsername() + "';");
        //delete employee from arraylist
        EmployeeData.employeeArrayList.remove(employee);
        //close db
        sqLiteDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLENAME + ";");
    }
}
