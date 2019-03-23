package com.example.arthi.agss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cash extends AppCompatActivity {
    String re2000,re500,re100,re50,re20,re10,re5,re2,re1,total,order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);
        Intent i = getIntent();
        order = i.getStringExtra("order");
        final EditText r2000 = (EditText) findViewById(R.id.editText2);
        final EditText r500 = (EditText) findViewById(R.id.editText3);
        final EditText r100 = (EditText) findViewById(R.id.editText4);
        final EditText r50 = (EditText) findViewById(R.id.editText6);
        final EditText r20 = (EditText) findViewById(R.id.editText5);
        final EditText r10 = (EditText) findViewById(R.id.editText7);
        final EditText r5 = (EditText) findViewById(R.id.editText8);
        final EditText r2 = (EditText) findViewById(R.id.editText9);
        final EditText r1 = (EditText) findViewById(R.id.editText10);
        final EditText tot = (EditText) findViewById(R.id.editText11);


        Button cont = (Button) findViewById(R.id.button130);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                re2000 = r2000.getText().toString();
                re500 = r500.getText().toString();
                re100 = r100.getText().toString();
                re50 = r50.getText().toString();
                re20 = r20.getText().toString();
                re10 = r10.getText().toString();
                re5 = r5.getText().toString();
                re2 = r2.getText().toString();
                re1 = r1.getText().toString();
                total = tot.getText().toString();
                //if you use total
                //int rs2000 = Integer.valueOf(re2000);
                //int rs500 = Integer.parseInt(re500);
                //int rs100 = Integer.parseInt(re100);
                //int rs50 = Integer.parseInt(re50);
                //int rs20 = Integer.parseInt(re20);
                //int rs10 = Integer.parseInt(re10);
                //int rs5 = Integer.parseInt(re5);
                //int rs2 = Integer.parseInt(re2);
                //int rs1 = Integer.parseInt(re1);

                //int tot = (rs1) + (rs2 * 2) + (rs5 * 5) + (rs10 * 10) + (rs20 * 20) + (rs50 * 50) + (rs100 * 100) + (rs500 * 500) + (rs2000 * 2000);

                //String total=Integer.toString(tot);

                Intent intent = new Intent(Cash.this, FinalActivity.class);

                String cash = "Cash Denominations" + "\n" + "₹2000 X " + re2000 + "\n" + "₹500 X " + re500 + "\n" + "₹100 X " + re100 + "\n" + "₹50 X " + re50 + "\n" + "₹20 X " + re20 + "\n" + "₹10 X " + re10 + "\n" + "₹5 X " + re5 + "\n" + "₹2 X " + re2 + "\n" + "₹1 X " + re1 + '\n' + "Total = " + total;

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("payment", cash);

                intent.putExtra("order", order);

                startActivity(intent);
            }
        });
        Button button = findViewById(R.id.cancel6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cash.this, LogoutActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }}
