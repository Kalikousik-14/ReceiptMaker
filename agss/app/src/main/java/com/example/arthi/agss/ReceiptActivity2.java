package com.example.arthi.agss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiptActivity2 extends AppCompatActivity {
    String deal;
    String product;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt2);
        Intent i=getIntent();
        deal=i.getStringExtra("deal");
        product=i.getStringExtra("product");
        counter = i.getIntExtra("counter",1);
        String p = Integer.toString(counter);
        TextView dealer=(TextView) findViewById(R.id.textView16);
        TextView productList=(TextView) findViewById(R.id.textView17);
        productList.setText(product);
        Button place = (Button) findViewById(R.id.button111);
        Button add = (Button) findViewById(R.id.button112);
        Button button=findViewById(R.id.cancel4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReceiptActivity2.this, LogoutActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        dealer.setText(deal);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ReceiptActivity2.this,OrderActivity2.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);


                intent.putExtra("deal",deal);

                intent.putExtra("counter",counter+1);

                intent.putExtra("product",product);

                startActivity(intent);
            }

        });
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ReceiptActivity2.this,PaymentModeActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);


                intent.putExtra("deal",deal);

                intent.putExtra("counter",counter+1);

                intent.putExtra("product",product);

                startActivity(intent);
            }

        });


    }
    }

