package com.techobbyist.HouseHold;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class addnewtask extends AppCompatActivity implements View.OnClickListener {

    private Button btconfirm;
    private Button btcancel;
    private EditText taskname, person,deadline,equipemenets,notes;
    private DataBaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewtask);

        helper = new DataBaseHelper(this);

        btconfirm = (Button)findViewById(R.id.taskconfirm);
        btcancel = (Button)findViewById(R.id.taskcancel);

        taskname = (EditText) findViewById(R.id.names);
        person = (EditText) findViewById(R.id.username);
        deadline = (EditText) findViewById(R.id.deadline);
        equipemenets = (EditText) findViewById(R.id.equipement);
        notes = (EditText) findViewById(R.id.notes);

        btconfirm.setOnClickListener(this);
        btcancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.taskconfirm:
                addtask();
                finish();
                break;
            case R.id.taskcancel:
                startActivity(new Intent(addnewtask.this,menu.class));
                finish();
                break;
            default:

        }
    }

    private void addtask(){

        String taskp = taskname.getText().toString();
        String personp = person.getText().toString();
        String deadlinep = deadline.getText().toString();
        String equipementsp = equipemenets.getText().toString();
        String notesp = notes.getText().toString();

        if(taskp.isEmpty())
        {
            displayToast("please name your task");
        }
        else if( personp.isEmpty()){
            displayToast("please give a person's name");
        }

        else if( deadlinep.isEmpty()){
            displayToast("please set a deadline");
        }
        else{
            Task t =new Task();
            t.setTaskName(taskp);
            t.setPersonName(personp);
            t.setRequiredItems(equipementsp);
            t.setDeadline(deadlinep);
            t.setNote(notesp);
            helper.insertTask(t);
            displayToast("Task has been created successfully ");
            startActivity(new Intent(addnewtask.this,menu.class));
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

