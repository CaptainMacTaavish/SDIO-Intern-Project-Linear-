package com.example.linearsdioproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {
    private long backPressedTimed;
    Toast backToastd;

    Button addRecord, viewRecord;

    @Override
    public void onBackPressed() {

        if(backPressedTimed + 2000 > System.currentTimeMillis()){
            backToastd.cancel();
            super.onBackPressed();
            return;
        }else{
            backToastd = Toast.makeText(getBaseContext(), "Press Back again to exit", Toast.LENGTH_SHORT);
            backToastd.show();
        }

        backPressedTimed = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        addRecord = findViewById(R.id.btn_add_record);
        viewRecord = findViewById(R.id.btn_view_record);

        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AddRecordActivity.class);
                startActivity(intent);
            }
        });

        viewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, ViewRecordActivity.class);
                startActivity(intent);
            }
        });

    }
}