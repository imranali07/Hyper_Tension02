package com.example.dell.simpleapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.simpleapp.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class BloodPressure extends AppCompatActivity {
     Button BtnNext;
     EditText Systolic;
     EditText DiaSystolic;
    AsyncHttpClient asyncHttpClient;
    String URL = ConfigurationClass.url + "Tbl_BP" + ConfigurationClass.type;
    String Diabetes_;
    String HeartsAttack_;
    String Strokes_;
    String KidneyDisease_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure);
        BtnNext = findViewById(R.id.Button_Next_BP);
        Systolic = findViewById(R.id.Systolic);
        DiaSystolic = findViewById(R.id.Diastolic);
        asyncHttpClient = new AsyncHttpClient();

        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BloodPressure.this, MedicineActivity.class));
                BloodPressure.this.finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        int Diabetes = intent.getIntExtra("Diabetes", 2);
        int HeartsAttack = intent.getIntExtra("HeartAttackInLast3years", 2);
        int Strokes = intent.getIntExtra("Strokes", 2);
        int KidneyDisease = intent.getIntExtra("KidneyDisease", 2);
        Diabetes_ = Integer.toString(Diabetes);
        HeartsAttack_ = Integer.toString(HeartsAttack);
        Strokes_ = Integer.toString(Strokes);
        KidneyDisease_ = Integer.toString(KidneyDisease);


        Toast.makeText(BloodPressure.this, Diabetes_ + HeartsAttack_ + Strokes_ + KidneyDisease_ , Toast.LENGTH_LONG).show();

    }





    private void sendBPData(String Systolic, String diastolic, Boolean Diabetes, Boolean HeartAttack, Boolean Strokes, Boolean Kidneydisease, String address){
        String Admin = Integer.toString(Admin_Login_Object_Class.shared.admin_Id);
        RequestParams params = new RequestParams();
        params.put("systolic", Systolic);
        params.put("diastolic", diastolic);
        params.put("Diabetes", Diabetes );
        params.put("HeartAttackInLast3Year", HeartAttack);
        params.put("Strokes", Strokes);
        params.put("KindneyDisease", Kidneydisease );
        params.put("status", address);
        params.put("patient_Id", Admin_Login_Object_Class.shared.name );
        asyncHttpClient.post(getApplicationContext(), URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Toast.makeText(BloodPressure.this, response.toString(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BloodPressure.this, MedicineActivity.class));
                BloodPressure.this.finish();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(BloodPressure.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
