package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id=item.getItemId();
        if (item_id == R.id.place) {
            Intent intent = new Intent(SecondActivity.this , ServicesActivity.class);
            startActivity(intent);
            Toast.makeText(this, "This is place option item", Toast.LENGTH_SHORT).show();

        }
        else if (item_id==R.id.tour){
            Intent intent = new Intent(SecondActivity.this , TourActivity.class);
            startActivity(intent);
            Toast.makeText(this, "This is TourGuide option item", Toast.LENGTH_SHORT).show();

        }
        else if (item_id==R.id.lng){
            Intent intent = new Intent(SecondActivity.this , LanguageActivity.class);
            startActivity(intent);
            Toast.makeText(this, "This is language option item", Toast.LENGTH_SHORT).show();

        }
        else if (item_id==R.id.payment){
            Intent intent = new Intent(SecondActivity.this ,PaymentActivity.class);
            startActivity(intent);
            Toast.makeText(this, "This is payment option item", Toast.LENGTH_SHORT).show();

        }
        else if (item_id==R.id.comf){
            Intent intent = new Intent(SecondActivity.this , ComfirmationActivity.class);
            startActivity(intent);

            Toast.makeText(this, "This is confirmation option item", Toast.LENGTH_SHORT).show();

        }
        else if (item_id==R.id.logout){
            Intent intent = new Intent(SecondActivity.this , LogoutActivity.class);
            startActivity(intent);
            Toast.makeText(this, "This is logout option item", Toast.LENGTH_SHORT).show();

        }
        return true;









    }
}