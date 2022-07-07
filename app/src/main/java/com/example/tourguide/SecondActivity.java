package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    EditText username , password;
    Button btnlogin;
    dbmanager DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        Button btnlogin = (Button) findViewById(R.id.btnsignup1);
        DB= new dbmanager(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("")|| pass.equals(""))
                    Toast.makeText(SecondActivity.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass= DB.checkusernamepassword(user,pass);
                    if (checkuserpass==true){
                        Toast.makeText(SecondActivity.this, "sign in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),ComfirmationActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SecondActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }






}