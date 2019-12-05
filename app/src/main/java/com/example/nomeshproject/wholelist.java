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

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

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
        final List<debitcreditmodel> wholelist=new ArrayList<debitcreditmodel>();
        ///apii connection
        AndroidNetworking.get("http://192.168.137.1:8044/api/department")
                .addQueryParameter("syncDateTime",null)
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(Clientdebitlist.class, new ParsedRequestListener<Clientdebitlist>() {


                    @Override
                    public void onResponse(Clientdebitlist response) {

                        int k=0;
                        if(response!=null)
                        {

                            for(int i=0;i<response.getGet().size();i++)
                            {

                                debitcreditmodel u=new debitcreditmodel(response.getGet().get(i).getName(),response.getGet().get(i).getDebit(),response.getGet().get(i).getCredit(),response.getGet().get(i).getDate());
                                wholelist.add(u);
//                        db.insert()
//
//                        if(response.getMessage().equals("nonsuccessfull"))
//                        {
//                            Toast.makeText(getdata.this,"no not working",LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Toast.makeText(getdata.this,"working",LENGTH_SHORT).show();
//                        }

                            }
                            Toast.makeText(wholelist.this,"data inserted", LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(wholelist.this,anError.getMessage(),LENGTH_SHORT).show();
                        System.out.println(anError.getMessage());
                    }
                });


int z=wholelist.size();












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
