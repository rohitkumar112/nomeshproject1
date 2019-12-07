package com.example.nomeshproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;


public class recyceleradapter extends RecyclerView.Adapter<recyceleradapter.viewholder> implements Filterable {
    public recyceleradapter() {

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.recycler,parent,false);

        return new viewholder(view);
    }

    public String[] name;

    public Context context;
    List<clientnamemodel> wholelist=new ArrayList<clientnamemodel>();
    public List<debitcreditmodel> debitcreditmodels=new ArrayList<>();

    public recyceleradapter(List<clientnamemodel> wholelist, Context context)
    {
        this.wholelist=wholelist;
      //  this.name=name;
        this.context=context;
    }
    public void filldata()
    {
        for(int i=0;i<wholelist.size();i++)
        {
            debitcreditmodel db=new debitcreditmodel();
            db.setName(wholelist.get(i).getName().toString());
//            db.setName(name[i].toString());
            db.setCredit(0);
            db.setDebit(0);
            debitcreditmodels.add(db);
        }
    }
    //for checking whether this is equal or not.
    public int gettotalcount()
    {
        int debit = 0,credit=0,total=0;
        for(int i=0;i<debitcreditmodels.size();i++)
        {
            debit=debit+debitcreditmodels.get(i).getCredit();
            credit=credit+debitcreditmodels.get(i).getDebit();

        }
        if(credit==debit)
        {
            total=1;
        }
        else
        {
            total=0;
        }
        return total;
    }
    public List<debitcreditmodel> getlist()
    {
        return debitcreditmodels;
    }
    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, final int position) {
        //     holder.name.setText(String.valueOf(debitlist.get(position)));
        holder.name.setText(wholelist.get(position).getName().toString());
        holder.add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//        holder.debit.setText();
                for(int i=0;i<wholelist.size();i++)
                {
                    if(wholelist.get(position).getName().equals(debitcreditmodels.get(i).getName()))
//                    if(name[position].equals(debitcreditmodels.get(i).getName()))
                    {
                        Toast.makeText(context,"Successfully inserted",Toast.LENGTH_SHORT).show();
                        //get value from edittext field
                        String debit=holder.debit.getText().toString();
                        //store value in integer
                        int debitint=Integer.parseInt(debit);
                        String credit=holder.credit.getText().toString();
                        int creditint=Integer.parseInt(credit);
                        debitcreditmodels.get(i).setDebit(debitint);
                        debitcreditmodels.get(i).setCredit(creditint);
                    }
                }
//   db.setName(name[position].toString());
//   String debit=holder.debit.getText().toString();
//   int debitint=Integer.parseInt(debit);
//        String credit=holder.credit.getText().toString();
//        int creditint=Integer.parseInt(credit);
//        db.setCredit(debitint);
//        db.setDebit(creditint);
//        debitcreditmodels.add(db);
            }
        });
    }



    @Override
    public int getItemCount() {
        return wholelist.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }
    private Filter namefilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            return null;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        }
    };

    public static class viewholder extends RecyclerView.ViewHolder {
        TextView name;
        EditText credit,debit;
        Button add;
        public viewholder(@NonNull final View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            debit=(EditText)itemView.findViewById(R.id.debit);
            credit=(EditText)itemView.findViewById(R.id.credit);
            add=(Button)itemView.findViewById(R.id.add);

            //        debit.setOnClickListener(new
//                                         View.OnClickListener() {
//                                             @Override
//                                             public void onClick(View view) {
//                                                 Toast.makeText(context,debit.getText().toString(),Toast.LENGTH_SHORT).show();
//
//                                             }
//                                         });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                //    Toast.makeText(t,name.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
