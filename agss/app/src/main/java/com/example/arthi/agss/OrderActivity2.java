package com.example.arthi.agss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class OrderActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinnerCountry;
    ArrayAdapter<String> OrderArray;
    Button button,button2;
    EditText pieces;

    String deal;
    int counter;
    String proDuct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);
        Intent i=getIntent();
        deal = i.getStringExtra("deal");
        counter = i.getIntExtra("counter",1);
        proDuct=i.getStringExtra("product");
        pieces= (EditText) findViewById(R.id.editText13);
        button2 = (Button) findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String product=spinnerCountry.getSelectedItem().toString()+" - "+pieces.getText().toString()+"pcs"+"\n";

                if(counter>0)
                {
                    product= proDuct+"\n"+product;
                }

                Intent intent = new Intent(OrderActivity2.this, ReceiptActivity2.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("product",product);

                intent.putExtra("deal",deal);

                intent.putExtra("counter",counter);

                startActivity(intent);
            }
        });

        button=findViewById(R.id.cancel2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity2.this, LogoutActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);
        //implementing OnItemSelectedListener (need to override the method)
        spinnerCountry.setOnItemSelectedListener(this);
        OrderArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        OrderArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCountry.setAdapter(OrderArray);

        OrderArray.add("20w40");
        OrderArray.add("15w40");
        OrderArray.add("Cutting oil");
        OrderArray.add("Transformer oil");
        OrderArray.add("Lithium based grease");
        OrderArray.add("IAP-3 Grease");
        OrderArray.add("oil-32");
        OrderArray.add("oil-2T");
        OrderArray.add("oil-140");
        OrderArray.add("oil-90");
        OrderArray.add("oil-68");
        OrderArray.setNotifyOnChange(true);

        spinnerCountry.setSelection(0);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
