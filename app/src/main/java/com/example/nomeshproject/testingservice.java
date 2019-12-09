package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import static android.widget.Toast.LENGTH_SHORT;

public class testingservice extends AppCompatActivity {
Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testingservice);
        click=(Button)findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AndroidNetworking.get("http://192.168.2.114:8090/api/login")


                        .addQueryParameter("syncDateTime",null)
                        .setTag("test")
                        .setPriority(

                                Priority.LOW)
                        .build()

                        .getAsObject(testingservicemodel.class, new ParsedRequestListener<testingservicemodel>() {
                            @Override
                            public void onResponse(testingservicemodel response) {
                                if(response.getMessage().equals("unsuccessfull"))
                                {
                                    Toast.makeText(testingservice.this,"no not working",LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(testingservice.this,dashboard.class);
                                    startActivity(intent);
                                    //storing the username and password
                                    //Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                Toast.makeText(testingservice.this,anError.getMessage(),LENGTH_SHORT).show();
                                System.out.println(anError.getMessage());
                            }


                        });
            }
        });

    }
}