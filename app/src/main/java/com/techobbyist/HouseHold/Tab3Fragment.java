package com.techobbyist.HouseHold;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramzy on 2017-11-26.
 */

public class Tab3Fragment extends Fragment  {
    private ImageButton sendSMS;
    private static final String TAG = "Tab3Fragment";

    ArrayList<Contact> menuProfiles = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.tab3_fragment,container,false);
        fillList();
        ListView listview = (ListView) view.findViewById(R.id.peopleListView);
        CustomList customAdapter = new CustomList(getActivity(), R.layout.profile_list, menuProfiles );

        ListView lv = (ListView) view.findViewById(R.id.peopleListView);
        lv.setAdapter(customAdapter);
        sendSMS = (ImageButton) view.findViewById(R.id.sms);
        sendSMS.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"));
                startActivity(sendIntent);

            }
        });
        return view;
    }

    public void fillList(){
        DataBaseHelper db = new DataBaseHelper(getActivity());
        menuProfiles=db.getAllContacts();

    }
}
