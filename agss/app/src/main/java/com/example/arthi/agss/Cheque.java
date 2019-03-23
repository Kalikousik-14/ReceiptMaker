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
import android.widget.Toast;


public class Cheque extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button Button1 ,Button2 ;
    String order;
    Spinner spin;

    EditText cheque;
    String[] bankNames={"Allahabad bank",
            "Andhra Bank",
            "Axis Bank",
            "Bank of Bahrain and Kuwait",
            "Bank of Baroda - Corporate Banking ",
            "Bank of Baroda - Retail Banking ","Bank of India",
            "Bank of Maharashtra"," Canara Bank ",
            "Central Bank of India",
            "City Union Bank"," Corporation Bank ",
            "Deutsche Bank",
            "Development Credit Bank",
            "Dhanlaxmi Bank",
            "Federal Bank",
            "ICICI Bank",
            "IDBI Bank",
            "Indian Bank",
            "Indian Overseas Bank",
            "IndusInd Bank",
            "ING Vysya Bank",
            "Jammu and Kashmir Bank", "Karnataka Bank Ltd",
            "Karur Vysya Bank",
            "Kotak Bank",
            "Laxmi Vilas Bank",
            "Oriental Bank of Commerce",
            "Punjab National Bank - Corporate Banking",
            "Punjab National Bank - Retail Banking",
            "Punjab & Sind Bank",
            "Shamrao Vitthal Co-operative Bank",
            "South Indian Bank",
            "State Bank of Bikaner & Jaipur",
            "State Bank of Hyderabad",
            "State Bank of India",
            "State Bank of Mysore",
            "State Bank of Patiala",
            "State Bank of Travancore",
            "Syndicate Bank",
            "Tamilnadu Mercantile Bank Ltd.",
            "UCO Bank",
            "Union Bank of India",
            "United Bank of India",
            "Vijaya Bank",
            "Yes Bank Ltd"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheque);
        Intent i=getIntent();
        order=i.getStringExtra("order");

        spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bankNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        cheque = (EditText) findViewById(R.id.editText);
        cheque.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Toast msg = Toast.makeText(getBaseContext(), "numbers",

                        Toast.LENGTH_LONG);

                msg.show();

            }

        });

        Button1 = (Button) findViewById(R.id.button);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Cheque.this, FinalActivity.class);

                String cheqque = "Cheque payment:\n\n"+"Bank:\t"+spin.getSelectedItem().toString()+"\nCheque number:\t"+cheque.getText().toString();

                intent.putExtra("payment",cheqque);

                intent.putExtra("order",order);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });

        Button2 = (Button) findViewById(R.id.button2);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Cheque.this, LogoutActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });


    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), bankNames[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {


    }
}
