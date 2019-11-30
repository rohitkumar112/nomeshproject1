package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class debitcredit extends AppCompatActivity {
EditText debit,credit,summary;
Button submit;
RecyclerView debitcreditlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debitcredit);
        debitcreditlist=(RecyclerView)findViewById(R.id.debitcreditlist);
        //from here we can get list from db
        debitcreditlist.setLayoutManager(new LinearLayoutManager(this));
   //     final String[] name={"rohit","kumar","sandesh"};
        List<debitcreditmodel> debitcreditmodelList=new ArrayList<debitcreditmodel>();

    }
}
