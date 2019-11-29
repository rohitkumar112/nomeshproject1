package com.example.nomeshproject;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import static android.widget.Toast.LENGTH_SHORT;


public class addclientdialog extends Dialog implements View.OnClickListener{
    EditText name,phonenumber,detail;
    Button add;
    public addclientdialog(@NonNull Context context) {
        super(context);

    setContentView(R.layout.addclientdialog);
    name=(EditText) findViewById(R.id.name);
        phonenumber=(EditText) findViewById(R.id.phonenumber);
        detail=(EditText) findViewById(R.id.detail);
        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname,sphonenumber,sdetail;
                sname=name.getText().toString();
                sphonenumber=phonenumber.getText().toString();
                sdetail=detail.getText().toString();
                if(sname.isEmpty()||sphonenumber.isEmpty()||sdetail.isEmpty())
                {
                    Toast.makeText(getContext(),"please fill detail", LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}





