package com.example.nomeshproject;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

public class addclientpopup extends Dialog {
    public addclientpopup(@NonNull Context context) {
        super(context);
        setContentView(R.layout.addclientdialog);
    }
}
