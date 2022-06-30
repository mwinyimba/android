package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LanguageActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        radioGroup=findViewById(R.id.radiogroup);
        textView=findViewById(R.id.text_view_selected);

        Button buttonApply=findViewById(R.id.button_apply);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId= radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                textView.setText("Your choice: " +radioButton.getText());
            }
        });

    }
    public  void  checkButton(View v){
        int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioId);
        Toast.makeText(this, "selected radio button: "+radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}