package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        String name="rohit";
        String pass="sasa";
        addclientmodel ad=new addclientmodel();
        ad.setMessage("successfull");
        List<debitcreditmodel> d=new ArrayList<>();
        debitcreditmodel add=new debitcreditmodel();
        add.setDebit(1);
        add.setDebit(1);
        add.setName("as");
        for(int i=0;i<2;i++)
        {
         d.add(add);
        }

        //addqueryparameter means passing the paramter to the api
        //passing object to api throgh add bodyparameter
        //pass list as object to web api using addapplicationjsonbody
        AndroidNetworking.post("http://192.168.2.114:8080/api/test")
//                .addQueryParameter("name")
//                .addQueryParameter("pass",pass)// posting java object
//                .addBodyParameter(s)
                .addApplicationJsonBody(d)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                // .setContentType("application/json")
                .build()
                .getAsObject(verifyinsertion.class, new ParsedRequestListener<verifyinsertion>() {
                    @Override
                    public void onResponse(verifyinsertion response) {
                        if(response.getMessage().equals("successfull"))
                        {
                           Toast.makeText(test.this,"succes",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(test.this,"faild",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
