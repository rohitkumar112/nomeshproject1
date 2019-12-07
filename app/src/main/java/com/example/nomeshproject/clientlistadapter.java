package com.example.nomeshproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;




import java.util.ArrayList;
import java.util.List;

public class clientlistadapter extends RecyclerView.Adapter<clientlistadapter.viewholder> {
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.clientdata,parent,false);

        return new clientlistadapter.viewholder(view);

    }
    List<debitcreditmodel> wholelist=new ArrayList<debitcreditmodel>();
Context context;
    public clientlistadapter(List<debitcreditmodel> wholelist, Context context)
    {
        this.context=context;
        this.wholelist=wholelist;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.name.setText(wholelist.get(position).getName());
    holder.credit.setText(String.valueOf(wholelist.get(position).getCredit()));
        holder.credit.setText(String.valueOf(wholelist.get(position).getDebit()));
    }

    @Override
    public int getItemCount() {
        return wholelist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView name;
        TextView credit,debit;
        Button add;

        public viewholder(@NonNull View itemView) {

        super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            debit=(TextView) itemView.findViewById(R.id.debit1);
            credit=(TextView) itemView.findViewById(R.id.credit1);
            add=(Button)itemView.findViewById(R.id.add);
    }
}
}
