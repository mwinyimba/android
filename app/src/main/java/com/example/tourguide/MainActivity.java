package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView email = (TextView) findViewById(R.id.email);
        TextView password = (TextView) findViewById(R.id.password);
        Button loginbtn = (Button) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (email.getText().toString().equals("yussufrahma@gmail.com") && password.getText().toString().equals("12345678")) {
                    Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                } else

                    Toast.makeText(MainActivity.this, "wrong password", Toast.LENGTH_SHORT).show();
            }
        });
//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent( MainActivity.this , SecondActivity.class);
//                startActivity(intent);
//
//            }
//        });

    }
}