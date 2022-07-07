package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username , password, repassword;
    Button singup , singin;
    dbmanager DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         username= (EditText) findViewById(R.id.username);
         password = (EditText) findViewById(R.id.password);
         repassword = (EditText) findViewById(R.id.repassword);
        singin= (Button) findViewById(R.id.btnsignin);
        singup=(Button) findViewById(R.id.btnsignup);
        DB = new dbmanager(this);
        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , SecondActivity.class);
                startActivity(intent);

            }
        });
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                if (user.equals("")|| pass.equals("") || repass.equals(""))
                    Toast.makeText(MainActivity.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)){
                        Boolean checkuser= DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert = DB.inserData(user,pass);
                            if (insert==true){
                                Toast.makeText(MainActivity.this, "Register successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),ComfirmationActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "user already exist please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "password not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



//        loginbtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                if (email.getText().toString().equals("yussufrahma@gmail.com") && password.getText().toString().equals("12345678")) {
//                    Intent intent = new Intent(MainActivity.this , SecondActivity.class);
//                    startActivity(intent);
//
//                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
//                } else
//
//                    Toast.makeText(MainActivity.this, "wrong password", Toast.LENGTH_SHORT).show();
//            }
//        });
//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent( MainActivity.this , SecondActivity.class);
//                startActivity(intent);
//
//            }
//        });

    }
//    public void dbmanager(View view){
//        new  dbmanager(this);
//        startActivity(new Intent(this,SecondActivity.class));
//    }
//
//    public void login(View view) {
//        dbmanager db = new dbmanager(this);
//        String res = db.addRecord(email.getText().toString(),password.getText().toString());
//        Toast.makeText(this,res,Toast.LENGTH_SHORT).show();
//        email.setText("");
//        password.setText("");
//        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//    }
//
//    public void sign(View view) {
//        Intent intent = new Intent(         MainActivity.this,SecondActivity.class);
//        startActivity(intent);
//    }
}