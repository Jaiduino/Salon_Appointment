package com.example.saloon_version_0.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saloon_version_0.R;

public class BookAppointementActivity extends AppCompatActivity
{
    private TextView text;
    private Button button;
    Spinner spinner0,spinner1;
    String[] branches = new String[] {"Hadapsar", "Hinjewadi", "Kothrud", "Pimpri", "Kharadi"};
    String[] timeslot = new String[] {"10:00 AM", "12:00 PM", "02:00 PM", "04:00 PM", "06:00 PM", "08:00 PM"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointement);

        text = findViewById(R.id.showText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }

        });

        spinner0 = findViewById(R.id.spinner0);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(BookAppointementActivity.this, R.layout.branches_file,branches);
        adapter.setDropDownViewResource(R.layout.branches_file);
        spinner0.setAdapter(adapter);

        spinner0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                Toast.makeText(BookAppointementActivity.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(BookAppointementActivity.this, R.layout.timeslot,timeslot);
        adapter.setDropDownViewResource(R.layout.timeslot);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                Toast.makeText(BookAppointementActivity.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void  openDialog() {
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                text.setText(String.valueOf(dayOfMonth)+"."+String.valueOf(month+1)+"."+String.valueOf(year)+"  ");
            }
        }, 2023, 2, 01);
        dialog.show();
    }

    public void confirmBooking (View view)
    {
        startActivity(new Intent(this,FinalActivity.class));
    }

    public void cancel (View view)
    {
        startActivity(new Intent(this,Home_Page_Activity.class));
    }
}