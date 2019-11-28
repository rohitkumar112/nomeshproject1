package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class debitcredit extends AppCompatActivity {
EditText debit,credit,summary;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debitcredit);
 debit=(EditText)findViewById(R.id.debit);
 credit=(EditText)findViewById(R.id.credit);
 summary=(EditText)findViewById(R.id.summary);
 submit=(Button)findViewById(R.id.submit);
//credit.setOnEditorActionListener(new );
    }
}
