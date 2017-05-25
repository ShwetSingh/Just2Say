package com.example.shwet.just2say;

import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Shwet on 5/9/2017.
 */

public class CustomAdapter extends ArrayAdapter<User> {

    int groupid;

    ArrayList<User> records;

    Context context;



    public CustomAdapter(Context context, int vg, int id, ArrayList<User>
            records) {

        super(context, vg, id, records);

        this.context = context;

        groupid = vg;

        this.records = records;



    }



    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(groupid, parent, false);

        TextView textName = (TextView) itemView.findViewById(R.id.user_name);

        textName.setText(records.get(position).getUserName());

        TextView textPrice = (TextView) itemView.findViewById(R.id.user_phone);

        textPrice.setText(records.get(position).getUserPhone() + "$");



        return itemView;

    }

}


public class User {

    private String pName;

    private int uPhone;

    public void setUserName(String pName){this.pName=pName;}

    public void setuPhone(int uPrice){this.uPhone=uPhone;}

    public String getUserName(){return pName;}

    public int getUserPhone(){return uPhone;}



}

