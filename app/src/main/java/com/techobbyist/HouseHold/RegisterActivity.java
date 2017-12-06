package com.techobbyist.HouseHold;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private Button reg;
    private TextView tvLogin;
    private EditText email, name,username,password1,password2,sexe;

    private DataBaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        helper = new DataBaseHelper(this);
        reg = (Button)findViewById(R.id.btnReg);
        tvLogin = (TextView)findViewById(R.id.Tvlogin);
        name = (EditText) findViewById(R.id.Name);
        username = (EditText) findViewById(R.id.Username);
        email = (EditText) findViewById(R.id.email);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);
        sexe = (EditText) findViewById(R.id.sexe);
        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnReg:
                register();
                finish();
                break;
            case R.id.Tvlogin:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
                break;
            default:

        }
    }

    private void register(){
        String nameStr = name.getText().toString();
        String emailStr = email.getText().toString();
        String usernameStr = username.getText().toString();
        String password1Str = password1.getText().toString();
        String password2Str = password2.getText().toString();
        String sexStr = sexe.getText().toString();
        //String m =  new String("m");//male
        //String f =new String("f");//female

        if(nameStr.isEmpty())
        {
            displayToast("Name  field empty");
        }
        else if( usernameStr.isEmpty()){
            displayToast("username field empty");
        }
        else if( emailStr.isEmpty()){
            displayToast("Email field empty");
        }

        else if( password1Str.isEmpty()){
            displayToast("password field empty");
        }
        else if( password2Str.isEmpty()){
            displayToast("password field empty");
        }
        else if(!password1Str.equals(password2Str)){
            displayToast("passwords doesnt match ");
        }
        else  if(sexStr.isEmpty()){
            displayToast("Sex field is empty ");
        }
        else{
            Contact c =new Contact();
            c.setName(nameStr);
            c.setSexe(sexStr);
            c.setEmail(emailStr);
            c.setPassword(password1Str);
            c.setPassword(password2Str);
            c.setUsername(usernameStr);

            startActivity(new Intent(RegisterActivity.this,AddImageActivity.class));
            finish();
            helper.insertContact(c);
            displayToast("Thank you for register with us ,Household Manager ");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
