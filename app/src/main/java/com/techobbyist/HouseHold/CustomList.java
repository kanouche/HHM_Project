package com.techobbyist.HouseHold;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by dell on 05/12/2017.
 */

public class CustomList extends ArrayAdapter<Contact> {
    private int layoutResourceId;
    ArrayList<Contact> contacts;
    int nbrOfTasks;
    Context context;

    public CustomList(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        layoutResourceId = textViewResourceId;
    }
    public CustomList(Context context, int resource, ArrayList<Contact> contacts) {
        super(context, resource, contacts);
        this.context=context;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            Contact contact = getItem(position);
            View v = null;
            if (convertView == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.profile_list, null);

            } else {
                v = convertView;
            }
            ImageView iconImage= (ImageView) v.findViewById(R.id.profileIcon);
            TextView nameHeader = (TextView) v.findViewById(R.id.name);
            TextView nbrOfTask = (TextView) v.findViewById(R.id.nbr_of_task);
            TextView phoneNbr = (TextView) v.findViewById(R.id.phoneNumber);

            if(contact.getSexe()=="M"){
                iconImage.setImageResource(context.getResources().getIdentifier("male","drawable","com.package.application"));
            }
            else{
                iconImage.setImageResource(context.getResources().getIdentifier("female","drawable","com.package.application"));

            }
            nameHeader.setText(contact.getName());
            nbrOfTask.setText("number of task of this user : "+ contact.getNbrOfTask());
            phoneNbr.setText("Phone number :"+contact.getSexe());

            return v;

    }

}

