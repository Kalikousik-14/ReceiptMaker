package com.example.arthi.agss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerCountry, spinnerDivision, spinnerDistrict;
    ArrayAdapter<String> OrderArray, TypesArray, districtArray;
    Button button,button2;
    EditText pieces;

    String deal;
    int counter;
    String proDuct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent i=getIntent();
        deal = i.getStringExtra("deal");
        counter = i.getIntExtra("counter",1);
        proDuct=i.getStringExtra("product");
        pieces= (EditText) findViewById(R.id.editText13);
        button2 = (Button) findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String product=spinnerCountry.getSelectedItem().toString()+" - "+spinnerDistrict.getSelectedItem().toString()+" - "+spinnerDivision.getSelectedItem().toString()+" - "+pieces.getText().toString()+"pcs"+"\n";

                if(counter>0)
                {
                    product= proDuct+"\n"+product;
                }

                Intent intent = new Intent(OrderActivity.this, ReceiptActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("product",product);

                intent.putExtra("deal",deal);

                intent.putExtra("counter",counter);

                startActivity(intent);

            }
        });
        button=findViewById(R.id.cancel1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, LogoutActivity.class);
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

        OrderArray.add("All Purpose Greases");
        OrderArray.add("Automotive Greases");
        OrderArray.add("C.V.Diesel Engine Oils");
        OrderArray.add("Dedicated Engine oils");
        OrderArray.add("Gear & Transmission Oils");
        OrderArray.add("Industrial Grades");
        OrderArray.add("Passenger Car Oils");
        OrderArray.add("Tractor Engine Oils");
        OrderArray.add("Two Wheeler Oils");
        OrderArray.add("Others");
        OrderArray.setNotifyOnChange(true);

        spinnerCountry.setSelection(0);

        spinnerDivision = (Spinner) findViewById(R.id.spinnerDivision);
        //implementing OnItemSelectedListener (need to override the method)
        spinnerDivision.setOnItemSelectedListener(this);

        TypesArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        TypesArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDivision.setAdapter(TypesArray);

        spinnerDistrict = (Spinner) findViewById(R.id.spinnerDistrict);
        //implementing OnItemSelectedListener (need to override the method)
        spinnerDistrict.setOnItemSelectedListener(this);

        districtArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        districtArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDistrict.setAdapter(districtArray);


    }





    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //first spinner item position
        int countrySpinnerPosition = spinnerCountry.getSelectedItemPosition();
        switch (countrySpinnerPosition){
            case 0: //1st item of 1st spinner selected
                //fill data for second spinner
                fillAllPurposeGreaseTypes();
                //second spinner item position
                int divisionSpinnerPositionBD = spinnerDivision.getSelectedItemPosition();

                switch (divisionSpinnerPositionBD){
                    case 0: //1st item of 2nd spinner selected
                        //fill data for third spinner
                        fillall1();
                        break;
                    case 1: //2nd item of 2nd spinner selected and same for the rest.
                        //fill data for third spinner
                        fillall2();
                        break;
                    case 2:
                        //fill data for third spinner
                        fillall3();
                        break;

                }

                break;
            case 1: //2nd item of 1st spinner selected
                //fill data for second spinner
                fillAutomotiveGreaseTypes();
                //second spinner item position
                int divisionSpinnerPositionIndia = spinnerDivision.getSelectedItemPosition();
                switch (divisionSpinnerPositionIndia){
                    case 0: //1st item of 2nd spinner selected
                        //fill data for third spinner
                        fillauto1();
                        break;
                    case 1: //2nd item of 2nd spinner selected and same for the rest.
                        //fill data for third spinner
                        fillauto2();
                        break;
                    case 2:
                        //fill data for third spinner
                        fillauto3();
                        break;
                    case 3:
                        //fill data for third spinner
                        fillauto4();
                        break;
                    case 4:
                        //fill data for third spinner
                        fillauto5();
                        break;

                }
                break;
            case 2: //2nd item of 1st spinner selected
                //fill data for second spinner
                fillCVDeaselEngineOilTypes();
                //second spinner item position
                int divisionSpinnerPositioncv = spinnerDivision.getSelectedItemPosition();
                switch (divisionSpinnerPositioncv){
                    case 0: //1st item of 2nd spinner selected
                        //fill data for third spinner
                        fillcv1();
                        break;
                    case 1: //2nd item of 2nd spinner selected and same for the rest.
                        //fill data for third spinner
                        fillCV2();
                        break;
                    case 2 :
                        //fill data for third spinner
                        fillcv3();
                        break;
                }
                break;

            case 3: //2nd item of 1st spinner selected
                //fill data for second spinner
                fillDedicatedEngineoilTypes();
                //second spinner item position
                int divisionSpinnerPositiondeo = spinnerDivision.getSelectedItemPosition();
                switch (divisionSpinnerPositiondeo){
                    case 0: //1st item of 2nd spinner selected
                        //fill data for third spinner
                        filldeo1();
                        break;
                    case 1: //2nd item of 2nd spinner selected and same for the rest.
                        //fill data for third spinner
                        filldeo2();
                        break;
                    case 2:
                        //fill data for third spinner
                        filldeo3();
                        break;
                    case 3:
                        //fill data for third spinner
                        filldeo4();
                        break;
                    case 4 :
                        filldeo4();
                        break;
                }
                break;
            case 4: //2nd item of 1st spinner selected
                //fill data for second spinner
                fillGearTransmissionOilTypes();
                //second spinner item position
                int divisionSpinnerPositiongt = spinnerDivision.getSelectedItemPosition();
                switch (divisionSpinnerPositiongt) {
                    case 0: //1st item of 2nd spinner selected
                        //fill data for third spinner
                        fillgt1();
                        break;
                    case 1: //2nd item of 2nd spinner selected and same for the rest.
                        //fill data for third spinner
                        fillgt2();
                        break;
                    case 2:
                        //fill data for third spinner
                        fillgt3();
                        break;
                    case 3:
                        //fill data for third spinner
                        fillgt4();
                        break;
                    case 4:
                        //fill data for third spinner
                        fillgt5();
                        break;
                    case 5:
                        //fill data for third spinner
                        fillgt6();
                        break;
                    case 6:
                        //fill data for third spinner
                        fillgt7();
                        break;
                    case 7:
                        //fill data for third spinner
                        fillgt8();
                        break;
                    case 8:
                        //fill data for third spinner
                        fillgt9();
                        break;
                    case 9:
                        //fill data for third spinner
                        fillgt10();
                        break;
                    case 10:
                        //fill data for third spinner
                        fillgt11();
                        break;
                    case 11:
                        //fill data for third spinner
                        fillgt12();
                        break;

                    case 12:
                        //fill data for third spinner
                        fillgt13();
                        break;

                    case 13:
                        //fill data for third spinner
                        fillgt14();
                        break;


                }
                break;

            case 5: //2nd item of 1st spinner selected
                //fill data for second spinner
                fillIndustrialGradesTypes();
                //second spinner item position
                int divisionSpinnerPositionIg = spinnerDivision.getSelectedItemPosition();
                switch (divisionSpinnerPositionIg){
                    case 0: //1st item of 2nd spinner selected
                        //fill data for third spinner
                        fillind1();
                        break;
                    case 1: //2nd item of 2nd spinner selected and same for the rest.
                        //fill data for third spinner
                        fillind2();
                        break;
                    case 2:
                        //fill data for third spinner
                        fillind3();
                        break;
                    case 3:
                        //fill data for third spinner
                        fillind4();
                        break;
                    case 4:
                        //fill data for third spinner
                        fillind5();
                        break;
                    case 5:
                        //fill data for third spinner
                        fillind6();
                        break;
                    case 6:
                        //fill data for third spinner
                        fillind7();
                        break;
                    case 7:
                        //fill data for third spinner
                        fillind8();
                        break;

                }
                break;



            case 6: //2nd item of 1st spinner selected
                //fill data for second spinner
                fillPassengerCarOilTypes();
                //second spinner item position
                int divisionSpinnerPositionpcm = spinnerDivision.getSelectedItemPosition();
                switch (divisionSpinnerPositionpcm){
                    case 0: //1st item of 2nd spinner selected
                        //fill data for third spinner
                        fillpcmo1();
                        break;
                    case 1: //2nd item of 2nd spinner selected and same for the rest.
                        //fill data for third spinner
                        fillpcmo1();
                        break;
                    case 2:
                        //fill data for third spinner
                        fillpcmo2();
                        break;
                    case 3:
                        //fill data for third spinner
                        fillpcmo3();
                        break;
                    case 4:
                        //fill data for third spinner
                        fillpcmo4();
                        break;
                    case 5:
                        //fill data for third spinner
                        fillpcmo5();
                        break;

                }

                break;




            case 7: //2nd item of 1st spinner selected
                //fill data for second spinner
                fillTractorEngineOilTypes();
                //second spinner item position
                int divisionSpinnerPositiont = spinnerDivision.getSelectedItemPosition();
                switch (divisionSpinnerPositiont){
                    case 0: //1st item of 2nd spinner selected
                        //fill data for third spinner
                        fillDistrictUnderprima1();
                        break;
                    case 1: //2nd item of 2nd spinner selected and same for the rest.
                        //fill data for third spinner
                        fillDistrictUnderprima2();
                        break;
                    case 2:
                        //fill data for third spinner
                        fillDistrictUnderprima3();
                        break;

                }
                break;

            case 8: //2nd item of 1st spinner selected
                //fill data for second spinner
                fillTwoWheelerOilTypes();
                //second spinner item position
                int divisionSpinnerPositionTW = spinnerDivision.getSelectedItemPosition();
                switch (divisionSpinnerPositionTW){
                    case 0: //1st item of 2nd spinner selected
                        //fill data for third spinner
                        filltwo1();
                        break;
                    case 1: //2nd item of 2nd spinner selected and same for the rest.
                        //fill data for third spinner
                        filltwo2();
                        break;
                    case 2:
                        //fill data for third spinner
                        filltwo3();
                        break;
                    case 3:
                        //fill data for third spinner
                        filltwo4();
                        break;
                    case 4:
                        //fill data for third spinner
                        filltwo5();
                        break;
                    case 5:
                        //fill data for third spinner
                        filltwo6();
                        break;
                    case 6:
                        //fill data for third spinner
                        filltwo7();
                        break;
                    case 7:
                        //fill data for third spinner
                        filltwo8();
                        break;
                    case 8:
                        //fill data for third spinner
                        filltwo9();
                        break;
                    case 9:
                        //fill data for third spinner
                        filltwo10();
                        break;
                    case 10:
                        //fill data for third spinner
                        filltwo11();
                        break;
                }
                break;


            case 9: //2nd item of 1st spinner selected
                //fill data for second spinner
                fillOthersTypes();
                //second spinner item position
                int divisionSpinnerPositionot = spinnerDivision.getSelectedItemPosition();
                switch (divisionSpinnerPositionot){
                    case 0: //1st item of 2nd spinner selected
                        //fill data for third spinner
                        fillot1();
                        break;
                    case 1: //2nd item of 2nd spinner selected and same for the rest.
                        //fill data for third spinner
                        fillot2();
                        break;
                    case 2:
                        //fill data for third spinner
                        fillot3();
                        break;
                    case 3:
                        //fill data for third spinner
                        fillot4();
                        break;
                    case 4:
                        //fill data for third spinner
                        fillot5();
                        break;
                    case 5:
                        //fill data for third spinner
                        fillot6();
                        break;
                    case 6:
                        //fill data for third spinner
                        fillot7();
                        break;
                    case 7:
                        //fill data for third spinner
                        fillot8();
                        break;
                    case 8:
                        //fill data for third spinner
                        fillot9();
                        break;
                }
                break;


        }

    }


    private void  fillAllPurposeGreaseTypes() {
        TypesArray.clear();
        TypesArray.add("AP 2 Grease");
        TypesArray.add("AP 3 Grease");
        TypesArray.add("AP 3 Supreme Grease");
        TypesArray.notifyDataSetChanged();
        TypesArray.notifyDataSetChanged();
    }

    private void fillAutomotiveGreaseTypes() {
        TypesArray.clear();
        TypesArray.add("Silk Shield UL Ultra Grease");
        TypesArray.add("Silk Shield Grease");
        TypesArray.add("Long Life Grease");
        TypesArray.add("VC Grease");
        TypesArray.add("WB Grease");
        TypesArray.notifyDataSetChanged();
    }

    private void fillCVDeaselEngineOilTypes() {
        TypesArray.clear();
        TypesArray.add("MaxPro Long Drain 15W-40 CI-4 Plus");
        TypesArray.add("TurboPro 15W-40 CH-4");
        TypesArray.add("HDC Turbo Sprint 15W-40 CF-4");
        TypesArray.notifyDataSetChanged();
    }

    private void fillDedicatedEngineoilTypes(){
        TypesArray.clear();
        TypesArray.add("Heavy Pull Pro 15W-40 CH-4");
        TypesArray.add("Heavy Pull 15W-40 CH-4");
        TypesArray.add("Auto-Rickshaw oil");
        TypesArray.add("CNG Special 20W-50");
        TypesArray.add("Deep Sea Premium 15W-40 CI-4");
        TypesArray.notifyDataSetChanged();
    }
    private void fillGearTransmissionOilTypes() {
        TypesArray.clear();
        TypesArray.add("Multigear 80");
        TypesArray.add("Multigear 80W-90");
        TypesArray.add("Multigear 85W-140HD");
        TypesArray.add("Multigear Plus 80W-90");
        TypesArray.add("Multigear Plus 85W-140HD");
        TypesArray.add("Multigear 90");
        TypesArray.add("Multigear 140HD");
        TypesArray.add("Multigear SM");
        TypesArray.add("P S Fluid");
        TypesArray.add("Transgear Express 90");
        TypesArray.add("Transgear Express 140");
        TypesArray.add("Transgear C3/C4 30,40");
        TypesArray.add("Wet Break Premium");
        TypesArray.add("Trac one");
        TypesArray.notifyDataSetChanged();
    }

    private void fillIndustrialGradesTypes() {
        TypesArray.clear();
        TypesArray.add("Max Shield Def(AUS 32)");
        TypesArray.add("Avalon 32,46");
        TypesArray.add("Avalon 68");
        TypesArray.add("Alithex 20");
        TypesArray.add("Amulkut 4");
        TypesArray.add("Solukut Super");
        TypesArray.add("ApresLube 220");
        TypesArray.add("ApresLube 320");
        TypesArray.notifyDataSetChanged();
    }

    private void fillPassengerCarOilTypes() {
        TypesArray.clear();
        TypesArray.add("Syntron 5W-40");
        TypesArray.add("Powertron 5W-30 SN ");
        TypesArray.add("Powertron 15W-40 CH-4");
        TypesArray.add("Blue Blood");
        TypesArray.add("Turbostar 20W-50");
        TypesArray.notifyDataSetChanged();
    }

    private void fillTractorEngineOilTypes() {
        TypesArray.clear();
        TypesArray.add("Prima Shakthi 15W-40 CI-4 Plus");
        TypesArray.add("HDB Prima 15W-40 CF-4");
        TypesArray.add("HDB Prima20W-40 CF-4");
        TypesArray.notifyDataSetChanged();
    }

    private void fillTwoWheelerOilTypes() {
        TypesArray.clear();
        TypesArray.add("Take Off 4T Racing 10W-50");
        TypesArray.add("Super Swift 10W-40");
        TypesArray.add("Take Off 4T Premium 10W-30 SN");
        TypesArray.add("Take Off 4S 10W-30 SN/MB");
        TypesArray.add("Take Off 4T HD 15W-50 SN/MA2");
        TypesArray.add("Take Off 4T Plus SM");
        TypesArray.add("Take Off 4T SPL 20W-40");
        TypesArray.add("Take Off 4T 20W50");
        TypesArray.add("Take Off 2T");
        TypesArray.add("Chain lube");
        TypesArray.add("Front Fork Oil");
        TypesArray.notifyDataSetChanged();
    }

    private void fillOthersTypes() {
        TypesArray.clear();
        TypesArray.add("HDB 20W-40 Plus API CF");
        TypesArray.add("HDB 20W-40 CF");
        TypesArray.add("HDB XL Super 20W-40 CF");
        TypesArray.add("Power Tiller Oil");
        TypesArray.add("Pump Set Oil");
        TypesArray.add("Rapid Cool");
        TypesArray.add("Dot 3");
        TypesArray.add("901 S3 10W");
        TypesArray.add("903 S3 30");
        TypesArray.notifyDataSetChanged();
    }


    private void fillDistrictUnderprima1() {
        districtArray.clear();

        districtArray.add("10 ltr");
        districtArray.add("8.5 ltr");
        districtArray.add("7.5 ltr");
        districtArray.notifyDataSetChanged();
    }

    private void  fillDistrictUnderprima2(){
        districtArray.clear();

        districtArray.add("10 ltr");
        districtArray.add("8.5 ltr");
        districtArray.add("7.5 ltr");
        districtArray.add("5 ltr");
        districtArray.add("l tr");
        districtArray.notifyDataSetChanged();
    }
    private  void fillDistrictUnderprima3(){
        districtArray.clear();
        districtArray.add("20 ltr");
        districtArray.add("10 ltr");
        districtArray.add("7.5 ltr");
        districtArray.add("6 ltr");
        districtArray.add("5 ltr");
        districtArray.add("3.5 ltr");
        districtArray.add("2.5 ltr");
        districtArray.add("l tr");
        districtArray.add("500 ml");
        districtArray.add("1 ltrP");
        districtArray.add("500 ml p");
        districtArray.notifyDataSetChanged();
    }
    private void fillcv1(){
        districtArray.clear();
        districtArray.add("20 ltr");
        districtArray.add("15 ltr");
        districtArray.add("10 ltr");
        districtArray.add("7.5 ltr");
        districtArray.add("7 ltr");
        districtArray.add("5 ltr");
        districtArray.add("1 ltr");

        districtArray.notifyDataSetChanged();

    }
    private void fillCV2() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("15 Ltr");
        districtArray.add("10Ltr");
        districtArray.add("7.5 Ltr");
        districtArray.add("7 Litr");
        districtArray.add("6 Ltr");
        districtArray.add("3 Ltr");
        districtArray.add("1 Ltr");
        districtArray.notifyDataSetChanged();
    }
    private void fillcv3(){
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("15 Ltr");
        districtArray.add("10Ltr");
        districtArray.add("7.5 Ltr");
        districtArray.add("6 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("4 Ltr");
        districtArray.add("3 Ltr");
        districtArray.add("2.5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.add("3 Ltr");
        districtArray.add("1 Ltr P");
        districtArray.add("500 ml P");

        districtArray.notifyDataSetChanged();

    }
    private void fillpcmo1(){
        districtArray.clear();
        districtArray.add("4 Ltr");
        districtArray.add("3.5 Ltr");

        districtArray.notifyDataSetChanged();


    }
    private void fillpcmo2(){
        districtArray.clear();
        districtArray.add("3.5 Ltr");
        districtArray.add("3 Ltr");
        districtArray.add("1 Ltr");

        districtArray.notifyDataSetChanged();

    }
    private void fillpcmo3(){
        districtArray.clear();
        districtArray.add("7 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("4 Ltr");
        districtArray.add("3.5 Ltr");
        districtArray.add("500 ml ");

        districtArray.notifyDataSetChanged();

    }
    private void fillpcmo4(){
        districtArray.clear();
        districtArray.add("4 Ltr");
        districtArray.add("3.5 Ltr");
        districtArray.add("1 Ltr");


        districtArray.notifyDataSetChanged();

    }
    private void fillpcmo5(){
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("3.5 Ltr");
        districtArray.add("3 Ltr");
        districtArray.add("1 Ltr");
        districtArray.add("500 ml");
        districtArray.notifyDataSetChanged();

    }
    private void filltwo1(){
        districtArray.clear();
        districtArray.add("1 Ltr");

        districtArray.notifyDataSetChanged();

    }
    private void filltwo2(){
        districtArray.clear();
        districtArray.add("1 Ltr");
        districtArray.add("900 ml");
        districtArray.notifyDataSetChanged();

    }
    private void filltwo3(){
        districtArray.clear();
        districtArray.add("1.2 Ltr");
        districtArray.add("1 Ltr");
        districtArray.add("900 ml");
        districtArray.notifyDataSetChanged();

    }
    private void filltwo4(){
        districtArray.clear();
        districtArray.add("900 ml M");
        districtArray.add("900 ml");
        districtArray.add("800 ml");
        districtArray.notifyDataSetChanged();

    }
    private void filltwo5(){
        districtArray.clear();
        districtArray.add("3 Ltr");
        districtArray.add("2.5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.notifyDataSetChanged();

    }
    private void filltwo6(){
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("1 Ltr");
        districtArray.add("900 ml");
        districtArray.add("800 ml");
        districtArray.notifyDataSetChanged();

    }
    private void filltwo7(){
        districtArray.clear();
        districtArray.add("1 Ltr");
        districtArray.add("900 ml");
        districtArray.notifyDataSetChanged();

    }
    private void filltwo8(){
        districtArray.clear();
        districtArray.add("1.2 Ltr");
        districtArray.add("1 ltr");
        districtArray.notifyDataSetChanged();

    }
    private void filltwo9(){
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("1 ltr");
        districtArray.add("500 ml");
        districtArray.add("40 ml P");
        districtArray.notifyDataSetChanged();

    }
    private void filltwo10(){
        districtArray.clear();
        districtArray.add("125 ml");
        districtArray.notifyDataSetChanged();

    }
    private void filltwo11(){
        districtArray.clear();
        districtArray.add("350 ml");
        districtArray.add("175 ml");
        districtArray.notifyDataSetChanged();

    }
    private void filldeo1(){
        districtArray.clear();
        districtArray.add("3 ltr");
        districtArray.add("2.5 ltr");
        districtArray.add("1 ltr");
        districtArray.add("500ml  ltr");

        districtArray.notifyDataSetChanged();

    }
    private void filldeo2(){
        districtArray.clear();
        districtArray.add("3 ltr");
        districtArray.add("2.5 ltr");
        districtArray.add("1 ltr");
        districtArray.add("500ml  ltr");
        districtArray.notifyDataSetChanged();

    }
    private void filldeo3(){
        districtArray.clear();


        districtArray.add("2.5 ltr");
        districtArray.add("1 ltr");
        districtArray.add("500ml  ltr");

        districtArray.notifyDataSetChanged();

    }
    private void filldeo4(){
        districtArray.clear();
        districtArray.add("1 ltr");
        districtArray.add("500ml  ltr");

        districtArray.notifyDataSetChanged();

    }
    private void filldeo5(){
        districtArray.clear();
        districtArray.add("20 ltr");
        districtArray.add("5 ltr");
        districtArray.notifyDataSetChanged();

    }
    private void fillot1(){
        districtArray.clear();
        districtArray.add("20 ltr");
        districtArray.notifyDataSetChanged();
    }
    private void fillot2(){
        districtArray.clear();
        districtArray.add("1 ltr P");
        districtArray.add("500 ml P");
        districtArray.notifyDataSetChanged();
    }
    private void fillot3(){
        districtArray.clear();
        districtArray.add("350 ml");
        districtArray.notifyDataSetChanged();
    }
    private void fillot4(){
        districtArray.clear();
        districtArray.add("3 ltr");
        districtArray.notifyDataSetChanged();
    }
    private void fillot5(){
        districtArray.clear();
        districtArray.add("5 ltr");
        districtArray.add("4 ltr");
        districtArray.add("3.5 ltr");
        districtArray.notifyDataSetChanged();
    }
    private void fillot6() {
        districtArray.clear();
        districtArray.add("20 ltr");
        districtArray.add("5 ltr");
        districtArray.add("3 ltr");
        districtArray.add("1 ltr");
        districtArray.add("500 ml");
        districtArray.notifyDataSetChanged();
    }
    private void fillot7() {
        districtArray.clear();
        districtArray.add("500 ml");
        districtArray.add("250 ml");
        districtArray.add("100 ml");
        districtArray.notifyDataSetChanged();
    }

    private void fillot8() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.notifyDataSetChanged();
    }

    private void fillot9() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.notifyDataSetChanged();
    }

    private void fillgt1() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.notifyDataSetChanged();
    }


    private void fillgt2() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.notifyDataSetChanged();
    }

    private void fillgt3() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.notifyDataSetChanged();
    }

    private void fillgt4() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("7 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("2.5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.notifyDataSetChanged();
    }

    private void fillgt5() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("10 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.add("500 ml");
        districtArray.notifyDataSetChanged();
    }

    private void fillgt6() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.notifyDataSetChanged();
    }


    private void fillgt7() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.notifyDataSetChanged();
    }


    private void fillgt8() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.add("500 ml");
        districtArray.notifyDataSetChanged();
    }



    private void fillgt9() {
        districtArray.clear();
        districtArray.add("5 Ltr");
        districtArray.add("3 Ltr");
        districtArray.add("1 Ltr");
        districtArray.add("500 ml");
        districtArray.notifyDataSetChanged();
    }

    private void fillgt10() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("10 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.add("500 ml");
        districtArray.add("1 Ltr P");
        districtArray.add("500 ml P");
        districtArray.notifyDataSetChanged();
    }




    private void fillgt11() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.add("500 ml");
        districtArray.add("1 Ltr P");
        districtArray.add("500 ml P");
        districtArray.notifyDataSetChanged();
    }



    private void fillgt12() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.notifyDataSetChanged();
    }


    private void fillgt13() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.notifyDataSetChanged();
    }


    private void fillgt14() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.notifyDataSetChanged();
    }
    private void fillall1() {
        districtArray.clear();
        districtArray.add("20 kg");
        districtArray.notifyDataSetChanged();
    }

    private void fillall2() {
        districtArray.clear();
        districtArray.add("20 kg");
        districtArray.add("15 kg");
        districtArray.add("10 kg");
        districtArray.add("5 kg");
        districtArray.add("3 kg");
        districtArray.add("2 kg");
        districtArray.add("1 kg");
        districtArray.add("500 gm");
        districtArray.add("50 gm");
        districtArray.add("1 kg p");
        districtArray.add("500 gm p");
        districtArray.add("200 gm p");
        districtArray.add("100 gm p");
    }

    private void fillall3() {
        districtArray.clear();
        districtArray.add("100 gm T");

    }

    private void fillauto1() {
        districtArray.clear();
        districtArray.add("20 kg");
        districtArray.add("10 kg");
        districtArray.add("7 kg");
        districtArray.add("5 kg");
        districtArray.add("3 kg M");
        districtArray.add("3 kg");
        districtArray.add("2 kg");
        districtArray.add("1 kg");
        districtArray.add("500 mg");
    }


    private void fillauto2() {
        districtArray.clear();
        districtArray.add("7 kg");
        districtArray.add("5 kg");
        districtArray.add("3 kg M");
        districtArray.add("3 kg");
        districtArray.add("2 kg");
        districtArray.add("1 kg");
        districtArray.add("500 mg");
    }

    private void fillauto3() {
        districtArray.clear();
        districtArray.add("20 kg");
        districtArray.add("10 kg");
        districtArray.add("7 kg");
        districtArray.add("5 kg");
        districtArray.add("3 kg");
        districtArray.add("2 kg");
        districtArray.add("1 kg");
        districtArray.add("500 gm");
        districtArray.add("50 gm");
        districtArray.add("200 gm p");;
    }



    private void fillauto4() {
        districtArray.clear();
        districtArray.add("20 kg");
        districtArray.add("3 kg");
        districtArray.add("2 kg");
        districtArray.add("1 kg");
        districtArray.add("500 gm");
    }


    private void fillauto5() {
        districtArray.clear();
        districtArray.add("20 kg");
        districtArray.add("3 kg");
        districtArray.add("2 kg");
        districtArray.add("1 kg");
        districtArray.add("500 gm");
    }



    private void fillind1() {
        districtArray.clear();
        districtArray.add("20 Ltr");
    }

    private void fillind2() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("500 ml P");
    }

    private void fillind3() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("6 Ltr");
        districtArray.add("5 Ltr");
        districtArray.add("1 Ltr");
        districtArray.add("500 ml");
        districtArray.add("1 Ltr P");
        districtArray.add("500 ml P");
    }



    private void fillind4() {
        districtArray.clear();
        districtArray.add("20 kg");
        districtArray.add("5 kg");
    }

    private void fillind5() {
        districtArray.clear();
        districtArray.add("20 Ltr");
    }

    private void fillind6() {
        districtArray.clear();
        districtArray.add("20 Ltr");
    }

    private void fillind7() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");

    }
    private void fillind8() {
        districtArray.clear();
        districtArray.add("20 Ltr");
        districtArray.add("5 Ltr");

    }





    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

