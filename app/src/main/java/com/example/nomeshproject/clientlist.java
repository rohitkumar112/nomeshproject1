package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class clientlist extends AppCompatActivity {
RecyclerView recyclerview;
    final List<debitcreditmodel> wholelist=new ArrayList<debitcreditmodel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientlist);
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        AndroidNetworking.get("http://192.168.1.125:8090/api/getvaluefromdb")
                .addQueryParameter("syncDateTime",null)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObject(Clientdebitlist.class, new ParsedRequestListener<Clientdebitlist>() {

                    @Override
                    public void onResponse(Clientdebitlist response) {
                        for(int i=0;i<response.getGetdata().size();i++)
                        {
                        }
                        //Toast.makeText(getApplicationContext(),response.getGetdata().get(0).getName(), LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
wholelist.size();
        recyclerview.setAdapter(new clientlistadapter(wholelist,this));

    }
}
