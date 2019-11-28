package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {
TextView debitcredit,addclienttext,wholedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        wholedata=(TextView)findViewById(R.id.wholedata);
        debitcredit=(TextView)findViewById(R.id.debitcredit);
        addclienttext=(TextView)findViewById(R.id.addclienttext);
       wholedata.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(dashboard.this,wholelist.class);
               startActivity(intent);
           }
       });
        addclienttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,addclient.class);
                startActivity(intent);
//                addclientpopup add=new addclientpopup(getApplicationContext());
//                add.show();
            }
        });
        debitcredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,debitcredit.class);
            startActivity(intent);
            }
        });

    }
}
