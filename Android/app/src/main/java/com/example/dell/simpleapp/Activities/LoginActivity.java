package com.example.dell.simpleapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dell.simpleapp.R;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.DataInput;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText editTextPhone, editTextPass;
    AsyncHttpClient asyncHttpClient;

    String URL = ConfigurationClass.url +"/Tbl_Admin/GetTbl_Admin/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btnLogin = findViewById(R.id.button_login);
        editTextPhone = findViewById(R.id.mobile);
        editTextPass = findViewById(R.id.password);
        asyncHttpClient = new AsyncHttpClient();




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String phone = editTextPhone.getText().toString();
//                String pass = editTextPass.getText().toString();
                userLogin(editTextPhone.getText().toString(), editTextPass.getText().toString());//phone, pass

            }
        });

    }

    private void userLogin(String phone, String pass)
    {
//        final RequestParams params = new RequestParams();
//        params.add("", phone);
//        params.add("", pass);
        URL = URL + phone + "/" + pass + ConfigurationClass.type;
        asyncHttpClient.get(LoginActivity.this, URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String respone = new String(responseBody);
                try{

                    JSONObject adminlogin = new JSONObject(respone);
                    JsonNode jsonNode = JSONParse.convertJsonFormat(adminlogin);
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    Admin_Login_Object_Class.shared = mapper.readValue(new TreeTraversingParser(jsonNode), Admin_Login_Object_Class.class);

                   // String id = Admin_Login_Object_Class.shared.phoneNo;

                    //Toast.makeText(LoginActivity.this,id, Toast.LENGTH_LONG).show();
                      startActivity(new Intent(LoginActivity.this, MainActivity.class));
                     LoginActivity.this.finish();

                }
                catch (Exception ex){

                    Toast.makeText(LoginActivity.this,ex.getMessage(), Toast.LENGTH_LONG).show();
                }



            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(LoginActivity.this, "Invalid phone or password", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


