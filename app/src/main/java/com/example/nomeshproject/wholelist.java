package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class wholelist extends AppCompatActivity {
    RecyclerView recyclerview;
    EditText credit,debit;

    Button submit;
    SearchView searchicon;
    ImageView addclient;
    recyceleradapter rr;
    final List<clientnamemodel> wholelist=new ArrayList<clientnamemodel>();

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
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        addclient=(ImageView)findViewById(R.id.addclient);
        addclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
addclientdialog addclientd=new addclientdialog(wholelist.this);
addclientd.show();
            }
        });


        ///apii connection
        AndroidNetworking.get("http://192.168.1.125:8090/api/clientname")
                .addQueryParameter("syncDateTime",null)
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(clientname.class, new ParsedRequestListener<clientname>() {
                    @Override
                    public void onResponse(clientname response) {

                            for(int i=0;i<response.getData().size();i++)
                            {
                                clientnamemodel c=new clientnamemodel();
                                c.setName(response.getData().get(i).getName());
                                wholelist.add(c);
//
                            }
                        rr=new recyceleradapter(wholelist,getApplicationContext());
                        recyclerview.setAdapter(rr);
                        rr.filldata();
                    }
                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(wholelist.this,anError.getMessage(),LENGTH_SHORT).show();
                        System.out.println(anError.getMessage());
                    }
                });

        submit=(Button)findViewById(R.id.submit);
//submit.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        final String creditt=credit.getText().toString();
//        final String debitt=debit.getText().toString();
//        final int debitint=Integer.parseInt(debitt);
//        final int creditint=Integer.parseInt(creditt);
//        creditlist.add(creditint);
//        debitlist.add(debitint);
////        final recyceleradapter rr=new recyceleradapter(name,getApplicationContext());
////        rr.filldata();
////        recyclerview.setAdapter(rr);
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
                    List<debitcreditmodel> d=new ArrayList<>();

                    d=rr.getlist();

                    AndroidNetworking.post("http://192.168.1.125:8090/api/creditdebitcomments")
                            .addBodyParameter(d)
                            .addQueryParameter("syncDateTime",null)
                            .setTag("test")
                            .setPriority(Priority.LOW)
                            .build()
                            .getAsObject(verifylogin.class, new ParsedRequestListener<verifylogin>() {
                                @Override
                                public void onResponse(verifylogin response) {
                                    if(response.getMessage().equals("unsuccessfull"))
                                    {
                                        Toast.makeText(wholelist.this,"no not working",LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(), "Successfull Inserted", Toast.LENGTH_SHORT).show();
//                                        Intent intent=new Intent(wholelist.this,dashboard.class);
//                                        startActivity(intent);
                                        //storing the username and password
                                        //Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onError(ANError anError) {

                                }


                            });
                    //d=rr.getlist();
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
