package com.example.dell.simpleapp.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dell.simpleapp.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.Calendar;

import cz.msebera.android.httpclient.Header;

public class RegistrationActivity extends AppCompatActivity {
    String URL = ConfigurationClass.url + "Tbl_Patient" + ConfigurationClass.type;
    private Button btnNext;
    private EditText editTextDob, editTextName, editTextPhone, editTextAddress;
    private Calendar mCalendar = Calendar.getInstance();
    int mDay, mMonth, mYear;
    String[] districtList, stateList;
    Spinner spinnerDistrict, spinnerState;
    RadioGroup radioGroupGender;
    RadioButton radioButtonGender;
    private String gender;
    AsyncHttpClient asyncHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(editTextName.getText().toString(),
                        editTextDob.getText().toString(),
                        editTextPhone.getText().toString(),
                        editTextAddress.getText().toString());
            }
        });
        editTextDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarDialog();
            }
        });
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkID = group.getCheckedRadioButtonId();
                radioButtonGender = findViewById(checkID);
                gender = radioButtonGender.getText().toString();
            }
        });
        setDistrict();
        setState();




    }

    private void calendarDialog(){

        DatePickerDialog dateDialog = new DatePickerDialog(this, dateListener, mYear, mMonth, mDay);
        dateDialog.show();
    }
    DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month += 1;
            if(month < 10){
                editTextDob.setText(dayOfMonth + "-0" + month + "-" + year);
            }
            else{
                editTextDob.setText(dayOfMonth + "-" + month + "-" + year);
            }
        }
    };
    private void init(){
        btnNext = findViewById(R.id.button_Next);
        editTextDob = findViewById(R.id.dob_edit_text);
        editTextName = findViewById(R.id.patient_edit_text);
        editTextPhone = findViewById(R.id.mobile_edit_text);
        editTextAddress = findViewById(R.id.address_edit_text);
        spinnerDistrict = findViewById(R.id.district_spinner);
        spinnerState = findViewById(R.id.state_spinner);
        radioGroupGender = findViewById(R.id.rg_gender);
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH);
        mMonth = mCalendar.get(Calendar.MONTH);
        mYear = mCalendar.get(Calendar.YEAR);
        asyncHttpClient = new AsyncHttpClient();
    }
    private void setDistrict(){
        districtList = new String[]{"District 1", "District 2", "District 3", "District 4"};
        ArrayAdapter<String> districtAdapter = new ArrayAdapter(this,  android.R.layout.simple_spinner_item, districtList);
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistrict.setAdapter(districtAdapter);


    }
    private void setState(){
        stateList = new String[]{"State 1", "State 2", "State 3", "State 4"};
        ArrayAdapter<String> stateAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, stateList);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(stateAdapter);
    }

    private void sendData(String name, String dob, String mobile, String address){
        String Admin = Integer.toString(Admin_Login_Object_Class.shared.admin_Id);
        RequestParams params = new RequestParams();
        params.put("name", name);
        params.put("date_Of_Brith", dob);
        params.put("phone_No", mobile);
        params.put("gender", gender);
        params.put("status", address);
        params.put("created_By", Admin_Login_Object_Class.shared.name );
        asyncHttpClient.post(getApplicationContext(), URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Toast.makeText(RegistrationActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegistrationActivity.this, PatientMedicalHistoryActivity.class));
                RegistrationActivity.this.finish();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(RegistrationActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }




}
