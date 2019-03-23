package com.example.arthi.agss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Intent i = getIntent();
        String payment = i.getStringExtra("payment");
        String order = i.getStringExtra("order");
        String receipt=order+"\n\n"+payment;
        TextView creceipt = (TextView) findViewById(R.id.textView18);
        creceipt.setText(receipt);
        Button button=findViewById(R.id.continue1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalActivity.this, LogoutActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);}
        });
    }
}
