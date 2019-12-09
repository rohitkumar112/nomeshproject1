package com.example.nomeshproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    EditText name,pass;
    Button login,signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        //  sname=name.
        login=(Button)findViewById(R.id.login);
        pass=(EditText)findViewById(R.id.pass);
        signin=(Button)findViewById(R.id.create);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname=name.getText().toString();
                String spass=pass.getText().toString();

                //   AndroidNetworking.initialize(getApplicationContext(), myUnsafeHttpClient());
                AndroidNetworking.get("http://192.168.2.114:8080/api/login")
                        .addQueryParameter("name",sname)
                        .addQueryParameter("pass",spass)

                        .addQueryParameter("syncDateTime",null)
                        .setTag("test")
                        .setPriority(

                                Priority.LOW)
                        .build()

                        .getAsObject(verifylogin.class, new ParsedRequestListener<verifylogin>() {
                            @Override
                            public void onResponse(verifylogin response) {
                                if(response.getMessage().equals("unsuccessfull"))
                                {
                                    Toast.makeText(MainActivity.this,"no not working",LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_SHORT).show();
                                                    Intent intent=new Intent(MainActivity.this,dashboard.class);
                startActivity(intent);
                                    //storing the username and password
                                    //Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                Toast.makeText(MainActivity.this,anError.getMessage(),LENGTH_SHORT).show();
                            System.out.println(anError.getMessage());
                            }


                        });


            }
        });
    }
    private static OkHttpClient myUnsafeHttpClient() {
        try {

            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {

                    new X509TrustManager() {

                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) { }
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }
                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            //Using TLS 1_2 & 1_1 for HTTP/2 Server requests
            // Note : The following is suitable for my Server. Please change accordingly
            ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.COMPATIBLE_TLS)
                    .tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0)
                    .cipherSuites(
                            CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,
                            CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384,
                            CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                            CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384,
                            CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA,
                            CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384,
                            CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256,
                            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                            CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256,
                            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,
                            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA)
                    .build();

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.connectionSpecs(Collections.singletonList(spec));
          //  builder.hostnameVerifier(("https://192.168.2.114:8080/api/login","") -> true);
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
