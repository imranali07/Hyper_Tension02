package com.example.dell.simpleapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dell.simpleapp.R;

public class MedicineActivity extends AppCompatActivity {
    Button BtnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        BtnNext = findViewById(R.id.Button_Next_BP);

        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MedicineActivity.this, NextAppointmentActivity.class));
                MedicineActivity.this.finish();
            }
        });
    }
}
