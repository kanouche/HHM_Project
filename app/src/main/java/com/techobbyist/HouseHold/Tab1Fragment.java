package com.techobbyist.HouseHold;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramzy on 2017-11-26.
 */

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";


    private ArrayList<String> shopping_list = new ArrayList<String>() ;
    private EditText itemname;
    private ImageButton additem;
    private DataBaseHelper helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);
        //fillItemList();
        ListView listview = (ListView) view.findViewById(R.id.shopping_list);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, shopping_list);
        listview.setAdapter(listViewAdapter);
        additem = (ImageButton) view.findViewById(R.id.Additem);
        itemname = (EditText) view.findViewById(R.id.Itemname);
        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.Additem:
                        additem();
                        break;
                }
            }
        });
        helper=new DataBaseHelper(getActivity());
        return view;
    }

    private void additem(){
        String nameStr = itemname.getText().toString();

        if(nameStr.isEmpty())
        {
            displayToast("Name  field empty");
        }

        else{
            helper.insertitem(nameStr);
            displayToast("the item has been added succesfully !");
        }
    }
    private void displayToast(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /*
    public void fillItemList(){
        DataBaseHelper db = new DataBaseHelper(getActivity());
        shopping_list=db.getAllItem();

    }
    */


}
