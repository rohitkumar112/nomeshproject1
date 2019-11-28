package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    EditText name,pass;
    Button login,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        //  sname=name.
        login=(Button)findViewById(R.id.login);
        pass=(EditText)findViewById(R.id.pass);
        signin=(Button)findViewById(R.id.create);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname=name.getText().toString();
                String spass=pass.getText().toString();
                AndroidNetworking.get("http://localhost:59993/api/login")
                        .addQueryParameter("name",sname)
                        .addQueryParameter("pass",spass)
                        .addQueryParameter("syncDateTime",null)
                        .setTag("test")
                        .setPriority(

                                Priority.LOW)
                        .build()
                        .getAsObject(verifylogin.class, new ParsedRequestListener<verifylogin>() {
                            @Override
                            public void onResponse(verifylogin response) {
                                if(response.getMessage().equals("nonsuccessfull"))
                                {
                                    Toast.makeText(MainActivity.this,"no not working",LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_SHORT).show();
                                    //storing the username and password
                                    Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onError(ANError anError) {

                            }


                        });

                Intent intent=new Intent(MainActivity.this,dashboard.class);
                startActivity(intent);
            }
        });
    }
}
