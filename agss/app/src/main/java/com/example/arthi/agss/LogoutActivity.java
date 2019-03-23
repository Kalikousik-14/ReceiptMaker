package com.example.arthi.agss;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class LogoutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        Intent i = getIntent();
        final String buyer=i.getStringExtra("buyer");
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final Button back = findViewById(R.id.back1);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogoutActivity.this, ProfileActivity.class);

                String product="Veedol - "+buyer;

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("product",product);

                startActivity(intent);


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogoutActivity.this, ProfileActivity2.class);

                String product="Marvel - "+buyer;

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("product",product);

                startActivity(intent);


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogoutActivity.this, AreaActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);


            }
        });




    }


}