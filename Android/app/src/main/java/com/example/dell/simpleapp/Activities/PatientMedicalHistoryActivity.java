package com.example.dell.simpleapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.dell.simpleapp.Adapters.PatientHistoryAdapter;
import com.example.dell.simpleapp.R;

public class PatientMedicalHistoryActivity extends AppCompatActivity implements View.OnClickListener {
//    String[] diseaseList;
//    PatientHistoryAdapter adapter;
    Button BtnNext;
    CheckBox c1, c2, c3, c4;
    int d1, d2, d3, d4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_medical_history);
//        diseaseList = new String[]{"Diabetes", "Heart attack in last 3 years", "Strokes", "Kidney disease"};
//        adapter = new PatientHistoryAdapter(diseaseList);
        BtnNext = (Button)findViewById(R.id.button_Next_patient_history);
        c1 = findViewById(R.id.checkBox1);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        c4 = findViewById(R.id.checkBox4);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        d1=d2=d3=d4=0;


        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(PatientMedicalHistoryActivity.this, BloodPressure.class);
                intent.putExtra("Diabetes", d1);
                intent.putExtra("HeartAttackInLast3years", d2);
                intent.putExtra("Strokes", d3);
                intent.putExtra("KidneyDisease", d4);
                startActivity(intent);

                PatientMedicalHistoryActivity.this.finish();

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.checkBox1:
                d1 = 1;
                break;
            case R.id.checkBox2:
                d2 = 1;
                break;
            case R.id.checkBox3:
                d3 = 1;
                break;
            case R.id.checkBox4:
                d4 = 1;
                break;
        }
    }
}
