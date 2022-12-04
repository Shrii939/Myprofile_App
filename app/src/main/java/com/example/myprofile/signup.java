package com.example.myprofile;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    EditText username, password, fullName, USN;
    Button sup;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    String daofbrth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        initDatePicker();
        dateButton = findViewById(R.id.datepicker);
        dateButton.setText(getTodaysDate());
        username = findViewById(R.id.uname);
        password = findViewById(R.id.psswdd);
        fullName = findViewById(R.id.fname);
        USN = findViewById(R.id.usn);
        sup = findViewById(R.id.signupBtn);
        sup.setOnClickListener(view -> signUp(view));

    }



    public void signUp(View v) {

        if( username.getText().toString().trim().equals(""))
        {
            username.setError( "First name is required!" );

            username.setHint("please enter username");
        }
        if( fullName.getText().toString().trim().equals(""))
        {
            fullName.setError( "Fullname is required!" );

            fullName.setHint("please enter fullname");
        }
        if( USN.getText().toString().trim().equals(""))
        {
            USN.setError( "USN required!" );

            USN.setHint("please enter USN");
        }


        if(password.getText().toString().length()>=8 && validatePassword(password.getText().toString()))
        {
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,signIn.class);

            Bundle bundleMA = new Bundle();
            bundleMA.putString("uid",username.getText().toString());
            bundleMA.putString("password",password.getText().toString());
            bundleMA.putString("fullname", fullName.getText().toString());
            bundleMA.putString("usn", USN.getText().toString());
            bundleMA.putString("DOB", daofbrth);
            intent.putExtras(bundleMA);
            startActivity(intent);
            finish();
        }
        else
        {

            Toast.makeText(this, "Password not meeting constraints", Toast.LENGTH_LONG).show();
        }
    }

    public boolean validatePassword(String password) {
        Pattern pattern;
        Matcher matcher;
        String passwordPtrn = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[<>/+-@#$])(?=\\S+$).{8,}$";

                /*
                      ^                 # start-of-string
                    (?=.*[0-9])       # a digit must occur at least once
                    (?=.*[a-z])       # a lower case letter must occur at least once
                    (?=.*[A-Z])       # an upper case letter must occur at least once
                    (?=.*[@#$%^&+=])  # a special character must occur at least once
                    (?=\S+$)          # no whitespace allowed in the entire string
                    .{8,}             # anything, at least eight places though
                    $                 # end-of-string

                 */
        pattern =Pattern.compile(passwordPtrn);
        matcher=pattern.matcher(password);
        return matcher.matches();
    }


    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, month, day) -> {
            month = month + 1;
            String date = makeDateString(day, month, year);
            dateButton.setText(date);
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        daofbrth = "DOB: "+ getMonthFormat(month) + " " + day + " " + year;
        return daofbrth;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }

}