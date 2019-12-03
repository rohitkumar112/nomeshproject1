package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

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
        debitcreditlist=(RecyclerView)findViewById(R.id.debitcreditlist);

        debitcreditlist.setLayoutManager(new LinearLayoutManager(this));
        final List<debitcreditmodel> wholelist=new ArrayList<debitcreditmodel>();
        final List<debitcreditmodel> wcopylist=new ArrayList<debitcreditmodel>();
        AndroidNetworking.get("http://192.168.1.125:8090/api/getvaluefromdb")
                .addQueryParameter("syncDateTime",null)
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(Clientdebitlist.class, new ParsedRequestListener<Clientdebitlist>() {

                    @Override
                    public void onResponse(Clientdebitlist response) {
                        for(int i=0;i<response.getGetdata().size();i++)
                        {
                            Toast.makeText(getApplicationContext(),response.getGetdata().get(0).getName(), LENGTH_SHORT).show();
                            debitcreditmodel d=new debitcreditmodel(response.getGetdata().get(i).getName(),response.getGetdata().get(i).getDebit(),response.getGetdata().get(i).getCredit());
                            wholelist.add(d);
//                            wcopylist.addAll(wholelist);
                        }
                        debitcreditlist.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        debitcreditlist.setAdapter(new clientlistadapter(wholelist,getApplicationContext()));

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }
}
