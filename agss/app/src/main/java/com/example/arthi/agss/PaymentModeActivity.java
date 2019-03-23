package com.example.arthi.agss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentModeActivity extends AppCompatActivity {
    String order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_mode);
        Intent i=getIntent();
        String deal =i.getStringExtra("deal");
        String product=i.getStringExtra("product");
        order=deal+"\n\n"+product;
        Button cash = (Button) findViewById(R.id.button122);
        Button cheque = (Button) findViewById(R.id.button121);
        Button button=findViewById(R.id.cancel5);
        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentModeActivity.this,Cash.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("order",order);

                startActivity(intent);
            }
        });

        cheque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentModeActivity.this,Cheque.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("order",order);

                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentModeActivity.this, LogoutActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

    }
});
}}
