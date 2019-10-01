package com.example.dell.simpleapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.simpleapp.Adapters.SearchListAdapter;
import com.example.dell.simpleapp.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private String URL =ConfigurationClass.url + "Tbl_Patient/GetSearchPatName" ;
    SearchView searchViewPatient;
    RecyclerView recyclerViewSearchList;
    SearchListAdapter searchListAdapter;
    TextView textNoPatient;
    Button btnRegister;
    AsyncHttpClient asyncHttpClient;

    int i = 0;
    SearchItem[] patientNameArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().hide();
       // patientNameArray = new String[]{"Roman Reigns", "John Cena", "Angelina Julie", "Michael Clarke", "Emma Watson"};
        textNoPatient = findViewById(R.id.no_patient_text);
        searchViewPatient = findViewById(R.id.search_view);
        btnRegister = findViewById(R.id.button_register);
        asyncHttpClient = new AsyncHttpClient();

        recyclerViewSearchList = findViewById(R.id.search_activity_recycler_view);
        recyclerViewSearchList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSearchList.setItemAnimator(new DefaultItemAnimator());

      //  searchListAdapter = new SearchListAdapter(patientNameArray);
        //recyclerViewSearchList.setAdapter(searchListAdapter);

        searchViewPatient.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                LoadPatientList(query);
                textNoPatient.setVisibility(View.VISIBLE);
                btnRegister.setVisibility(View.VISIBLE);
//                    textNoPatient.setText("No patient found in the list");
//                    recyclerViewSearchList.setVisibility(View.GONE);
                  //  Toast.makeText(SearchActivity.this,"True"+query, Toast.LENGTH_LONG).show();


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

               // Toast.makeText(SearchActivity.this, "False"+newText, Toast.LENGTH_LONG).show();

                return false;
            }
        });
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_register:
                startActivity(new Intent(SearchActivity.this, RegistrationActivity.class));
        }
    }

    private void LoadPatientList(String name)
    {
//        final RequestParams params = new RequestParams();
//        params.add("", phone);
//        params.add("", pass);
        URL = URL +"/"+ name+ ConfigurationClass.type;
        asyncHttpClient.get(SearchActivity.this, URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String Ab = new String(responseBody);


                try {

                    JSONArray ob = new JSONArray(Ab);

                    int l = ob.length();

                    patientNameArray = new SearchItem[l];

                    for (int i = 0; i< ob.length(); i++){

                        JSONObject objwq = ob.getJSONObject(i);
                        String name = objwq.getString("full_Name");
                        String address = objwq.getString("address_Id");
                        String dob = objwq.getString("date_Of_Brith");
                        String phoneNo = objwq.getString("phone_No");
                        SearchItem SI = new SearchItem(name,address,dob,phoneNo);
                         patientNameArray[i] = SI;


                    }

                    searchListAdapter = new SearchListAdapter(patientNameArray);
                    recyclerViewSearchList.setAdapter(searchListAdapter);

                  //  Toast.makeText(SearchActivity.this,job.toString(), Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                  //  Toast.makeText(SearchActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
                }
                }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(SearchActivity.this, "No Data found", Toast.LENGTH_SHORT).show();
            }
        });
    }



}

