package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class wholelist extends AppCompatActivity {
    RecyclerView recyclerview;
    EditText credit,debit;
    Button submit;
    SearchView searchicon;
    ImageView addclient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wholelist);
        final List<Integer> creditlist=new ArrayList<Integer>();
        final List<Integer> debitlist=new ArrayList<Integer>();
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        credit=(EditText)findViewById(R.id.credit);
        debit=(EditText)findViewById(R.id.debit);
        submit=(Button)findViewById(R.id.submit);
        //searchicon=(SearchView)findViewById(R.id.searchicon);

        addclient=(ImageView)findViewById(R.id.addclient);
        addclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
addclientdialog addclientd=new addclientdialog(wholelist.this);
addclientd.show();
            }
        });
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        final String[] name={"rohit","kumar","sandesh"};

//        submit=(Button)findViewById(R.id.submit);
//submit.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        final String creditt=credit.getText().toString();
//        final String debitt=debit.getText().toString();
//        final int debitint=Integer.parseInt(debitt);
//        final int creditint=Integer.parseInt(creditt);
//        creditlist.add(creditint);
//        debitlist.add(debitint);
        final recyceleradapter rr=new recyceleradapter(name,getApplicationContext());
        rr.filldata();
        recyclerview.setAdapter(rr);
//    }
//     //   searchicon.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//
//                             return false;
//            }
//        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int sum= rr.gettotalcount();
                if(sum>0)
                {
                    Toast.makeText(wholelist.this,"done",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(wholelist.this,"not done",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
