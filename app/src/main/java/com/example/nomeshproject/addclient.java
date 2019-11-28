package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

public class addclient extends AppCompatActivity {
EditText name,phonenumber,detail;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclient);
    name=findViewById(R.id.name);
        phonenumber=findViewById(R.id.phonenumber);
        detail=findViewById(R.id.detail);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname,sphonenumber,sdetail;
                sname=name.getText().toString();
                sphonenumber=phonenumber.getText().toString();
                sdetail=detail.getText().toString();

                //connecting to web service

                AndroidNetworking.post("http://localhost:59993/api/addclient")
                        //.addBodyParameter(loginModel)
                        .addBodyParameter("name",sname)
                        .addBodyParameter("phonenumer",sphonenumber)
                        .addBodyParameter("detail",sdetail)
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsObject(addclientmodel.class, new ParsedRequestListener<addclientmodel>() {
                            @Override
                            public void onResponse(addclientmodel response) {
                                if(response.getMessage().equals("successfull"))
                                {
                                    Toast.makeText(addclient.this,"data entered successfully",Toast.LENGTH_SHORT).show();
//                                    Intent intent=new Intent(MainActivity.this,loginactivity.class);
//                                    startActivity(intent);
                                }
                            }

                            @Override
                            public void onError(ANError error) {
                                Toast.makeText(addclient.this, "Error : "+error.getMessage(), Toast.LENGTH_LONG).show();
                                // handle error
                            }
                        });




            }
        });

    }
}
