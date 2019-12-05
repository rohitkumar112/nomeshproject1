package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {
TextView debitcredit,addclienttext,wholedata;
LinearLayout ldebitcredit,laddclient,llogout,lwholedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ldebitcredit=(LinearLayout)findViewById(R.id.ldebitcredit);
        laddclient=(LinearLayout)findViewById(R.id.laddclient);
        lwholedata=(LinearLayout)findViewById(R.id.lwholelist);
        llogout=(LinearLayout)findViewById(R.id.llogout);

//        wholedata=(TextView)findViewById(R.id.wholedata);
//        debitcredit=(TextView)findViewById(R.id.debitcredit);
//        addclienttext=(TextView)findViewById(R.id.addclienttext);
        //this is for debit credit
        lwholedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent intent=new Intent(dashboard.this, com.example.nomeshproject.debitcredit.class);
startActivity(intent);
            }
        });
//       lwholedata.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//           }
//       });
        laddclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,addclient.class);
                startActivity(intent);
//                addclientpopup add=new addclientpopup(getApplicationContext());
//                add.show();
            }
        });
        //this is for whole list
        ldebitcredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,wholelist.class);
            startActivity(intent);
            }
        });

    }

}
