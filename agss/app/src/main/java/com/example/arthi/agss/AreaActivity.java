package com.example.arthi.agss;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseUser;

import java.io.Serializable;

public class AreaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner spinnerCountry, spinnerDivision;
    ArrayAdapter<String> countryArray, DealersArray;
    Button button;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        final Button logout= findViewById(R.id.logout_button);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dlg = new ProgressDialog(AreaActivity.this);
                dlg.setTitle("Please, wait a moment.");
                dlg.setMessage("Signing Out...");
                dlg.show();
                // logging out of Parse
                ParseUser.logOut();
                alertDisplayer("Logut sucessfull...", "Logut..");
            }
        });
        button = (Button) findViewById(R.id.button4);
        //implementing OnClickListener (need to override the method)
        button.setOnClickListener(this);

        spinnerCountry = (Spinner) findViewById(R.id.spinnerArea);
        //implementing OnItemSelectedListener (need to override the method)
        spinnerCountry.setOnItemSelectedListener(this);

        countryArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        countryArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spinnerCountry.setAdapter(countryArray);


        countryArray.add("Ayyalur");
        countryArray.add("Batlagundu");
        countryArray.add("Bodi");
        countryArray.add("Chinnamanur");
        countryArray.add("Cumbam");
        countryArray.add("Devakottai");
        countryArray.add("Dharapuram");
        countryArray.add("Dindigul");
        countryArray.add("GopalPatti");
        countryArray.add("Gujiliyamparai");
        countryArray.add("Karaikudi");
        countryArray.add("Naatham");
        countryArray.add("Nilakottai");
        countryArray.add("Ottanchathram");
        countryArray.add("Palani");
        countryArray.add("Periyiakulam");
        countryArray.add("singanampuneri");
        countryArray.add("Theni");
        countryArray.add("Thirupathur");
        countryArray.add("usilampatti");
        countryArray.setNotifyOnChange(true);

        spinnerCountry.setSelection(0);

        spinnerDivision = (Spinner) findViewById(R.id.spinnerDealer);
        //implementing OnItemSelectedListener (need to override the method)
        spinnerDivision.setOnItemSelectedListener(this);

        DealersArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        DealersArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDivision.setAdapter(DealersArray);

        //implementing OnItemSelectedListener (need to override the method)






    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Selected Area :"+spinnerCountry.getSelectedItem().toString()+
                "\nSelected Dealer :"+spinnerDivision.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

        String area = spinnerCountry.getSelectedItem().toString();

        String dealer = spinnerDivision.getSelectedItem().toString();

        String buyer = dealer+" , "+area;

        Intent intent = new Intent(AreaActivity.this, LogoutActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        intent.putExtra("buyer",buyer);

        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //first spinner item position
        int countrySpinnerPosition = spinnerCountry.getSelectedItemPosition();
        switch (countrySpinnerPosition){
            case 0: //1st item of 1st spinner selected
                //fill data for second spinner
                fillAyyalurDivision();
            break;
            case 1:   //second spinner item position
               fillBatlagunduDivision();
            break;
            case 2:
                fillBodiDivision();

            break;
            case 3:
                 fillChinnamanurDivision();

            break;
            case 4:
                 fillCumbamDivision();

            break;
            case 5:
                fillDevakottaiDivision();
                break;
            case 6:
                fillDharapuramDivision();
            break;
            case 7:
                fillDindigulDivision();

           break; case 8:
                fillGopalpattiDivision();

           break;
           case 9:
                fillGujiliyamparaiDivision();

            break;
            case 10:
                fillKaraikudi();
            break;
            case 11:
                fillNatham();

            break;
            case 12:
                    fillNilakottai();
            break;
            case 13:
                fillOttanchathram();
            break;
            case 14:
                fillPalani();
            break;
            case 15:
                fillPeriyakulam();
            break;
            case 16:
                fillSinganampuneri();
            break;
            case 17:
                 fillTheni();
            break;
            case 18:
                fillThirupathur();
            break;
            case 19:
                fillUsilampatti();
            break;
    }}


    private void fillAyyalurDivision() {
        DealersArray.clear();
        DealersArray.add("sri Elumalaiyan Auto Spares");
        DealersArray.notifyDataSetChanged();
    }

    private void fillBatlagunduDivision() {
        DealersArray.clear();
        DealersArray.add("AJ Store");
        DealersArray.add("A.K.R Auto And Tingers");
        DealersArray.add("Amman Auto Store,Kodaikanal");
        DealersArray.add("Annai Auto Parts,Kodaikanal");
        DealersArray.add("Bala Auto Parts");
        DealersArray.add("JaiSakthi Bahavathi Auto Spares ");
        DealersArray.add("Keerthi Auto Electric");
        DealersArray.add("Meenatchi Auto");
        DealersArray.add("M.R.Two Wheeler(Muthu Raja Auto Works)");
        DealersArray.add("M.S.K.Spare Parts");
        DealersArray.add("Naveen Two Wheeler Spares");
        DealersArray.add("Rengaraj Auto Store");
        DealersArray.add("R.M.Auto Stores");
        DealersArray.add("SivaShakthi Automobiles");
        DealersArray.add("Sri Amman Automobiles,(D.R)");
        DealersArray.add("Sri Sakthi Automobiles");
        DealersArray.add("Sri Sakthi Automobiles,(New)");
        DealersArray.add("Sri Selvaganesh Auto Store");
        DealersArray.add("Sri Vinayaka Auto Store");
        DealersArray.notifyDataSetChanged();
    }
    private void fillCumbamDivision(){
        DealersArray.clear();
        DealersArray.add("Bilal Auto Centre");
        DealersArray.add("B.S.P.Motors");
        DealersArray.add("Cornl.Benni Cuicq Two Wheeler Assocition");
        DealersArray.add("Deen Motors");
        DealersArray.add("Deen Stores");
        DealersArray.add("Golden Auto Spares");
        DealersArray.add("Haj Motorss");
        DealersArray.add("Indin Auto Stores");
        DealersArray.add("Kirupa Motors");
        DealersArray.add("Lakshmi AutoMobiles");
        DealersArray.add("Muthu Automobiles");
        DealersArray.add("Navarathna Auto Centre");
        DealersArray.add("Ohm Vinayaga Transports");
        DealersArray.add("PNK Auto");
        DealersArray.add("P.S.R.Agency");
        DealersArray.add("Sri Grunda Traders,Kombai");
        DealersArray.add("Sri Goysalya Auto Spares");
        DealersArray.notifyDataSetChanged();
    }

    private void fillBodiDivision() {
        DealersArray.clear();
        DealersArray.add("Arun Motors");
        DealersArray.add("Jay Dev Traders");
        DealersArray.add("Karruppasami Auto Spares");
        DealersArray.add("Nagappa Motor");
        DealersArray.add("Royal Motors");
        DealersArray.add("Sakthi Auto Spares");
        DealersArray.add("Sri Ealumalayan Auto store");
        DealersArray.add("Sri RAm Auto Stores");
        DealersArray.add("Swami Auto Store");
        DealersArray.add("Thirupathi Auto Spare");
        DealersArray.add("Velavan Auto Store");
        DealersArray.notifyDataSetChanged();
    }

    private void fillChinnamanurDivision(){
        DealersArray.clear();
        DealersArray.add("AA Auto Store");
        DealersArray.add("Annam Auto Stores");
        DealersArray.add("Annam Auto Stores New");
        DealersArray.add("Annai Auto");
        DealersArray.add("Bismi Lorry Service");
        DealersArray.add("Deepan Auto Stores");
        DealersArray.add("Friends Auto Stores");
        DealersArray.add("Kerrthiga Auto Store");
        DealersArray.add("Kumaran Motor(Krishna Traders)");
        DealersArray.add("Lakshmi Automobile");
        DealersArray.add("Narayanan Auto Stores");
        DealersArray.add("Om Saravana Auto Spares");
        DealersArray.add("Om Saravana Auto Stores");
        DealersArray.add("Sandeep Automobiles");
        DealersArray.add("Sowmya Auto Electicals");
        DealersArray.add("Sri Senthil Murugan Auto Store");
        DealersArray.add("Sri Vari Auto Store");
        DealersArray.add("Swami Two Wheeler & Auto Sore");
        DealersArray.add("T.Somasuntharam");
        DealersArray.notifyDataSetChanged();
    }
    private void fillDevakottaiDivision(){
        DealersArray.clear();
        DealersArray.add("Annai Two Wheeler Works");
        DealersArray.add("A.R.Sekar Two Wheeler Works");
        DealersArray.add("Balamurugan Two Wheeler Works");
        DealersArray.add("Jeyanthi Auto Spares &Oils CO.");
        DealersArray.add("Sasi Motors Service");
        DealersArray.add("Sri Ayyanar Auto Mobiles");
        DealersArray.add("Sri Selvam Auto Spare Parts&Oil Store");
        DealersArray.add("Sri Vinayaga Auto Spare");
        DealersArray.notifyDataSetChanged();

    }

    private void fillDharapuramDivision(){
        DealersArray.clear();
        DealersArray.add("Dharapuram Auto Spares");
        DealersArray.add("Ganapathi Auto Spares");
        DealersArray.add("Mani Auto SPares And Oil Store");
        DealersArray.add("Marutha Rathna Spares");
        DealersArray.add("N.A.H. Atu Spares");
        DealersArray.add("Raja Rajeshwari Auto Store");
        DealersArray.add("Rajesh Auto Care");
        DealersArray.add("R.V.Manikandan Auto Care");
        DealersArray.add("Sri Abinaya Auto Store");
        DealersArray.add("Sri Bala Murugan Automobiles");
        DealersArray.add("S.S.V.Batteries & Automobiles");
        DealersArray.notifyDataSetChanged();

    }

    private void fillDindigulDivision(){
        DealersArray.clear();
        DealersArray.add("Achutha Public School");
        DealersArray.add("Ambika Cycle Mark, Kodairoad");
        DealersArray.add("Amirtham Auto's");
        DealersArray.add("Amman Auto Store");
        DealersArray.add("Anjali Systems");
        DealersArray.add("Amman Auto Spares,Kodairoad");
        DealersArray.add("Amman Auto Store");
        DealersArray.add("Amman Two Wheeler Works (Raja Mechanic)");
        DealersArray.add("Anjali Systems");
        DealersArray.add("A.R.Dairy Food(P)Ltd");
        DealersArray.add("Arkay Glen Rocks");
        DealersArray.add("Aruna Blue Stone");
        DealersArray.add("Bala's Auto");
        DealersArray.add("Bala Murugan Auto Store");
        DealersArray.add("Bethu Auto Spares");
        DealersArray.add("Bharath Auto Works");
        DealersArray.add("Brito(Mariyan Mechanic)");
        DealersArray.add("Devi Auto Works");
        DealersArray.add("Dharshana Auto Spares,Vadamadurai");
        DealersArray.add("Dharani Auto Works,Eriode");
        DealersArray.add("Gain-UP Industires India PVT");
        DealersArray.add("Ganapathy Works");
        DealersArray.add("Ganesh Auto Spares");
        DealersArray.add("B.M.Sornampillai Sons");
        DealersArray.add("Grace Travels");
        DealersArray.add("GVR Mini Bus");
        DealersArray.add("G.S.R.Auto Store,Vaadamadurai");
        DealersArray.add("Hari Krishnan Auto Parts");
        DealersArray.add("Heritage Agro Foods");
        DealersArray.add("Janani Auto Works");
        DealersArray.add("Kanaga Raj,Authur");
        DealersArray.add("Kanna Auto Wrks,Eriode");
        DealersArray.add("Karai Auto Spares,Kovilur");
        DealersArray.add("Kaviyarasu Bus Service");
        DealersArray.add("KRNS Transports");
        DealersArray.add("Kumar Auto Force");
        DealersArray.add("KV Lorry");
        DealersArray.add("KVM Auto Spares");
        DealersArray.add("Mariyan Tractor Works");
        DealersArray.add("Maharishi Educational Trust");
        DealersArray.add("Maruthi Tipper");
        DealersArray.add("Matha Diesel Works");
        DealersArray.add("Mayil Swami");
        DealersArray.add("Mohan Motor Works");
        DealersArray.add("Murugan Machanic");
        DealersArray.add("Naga Mini BUs");
        DealersArray.add("New Arun Auto Spares");
        DealersArray.add("New RPS Auto Spares");
        DealersArray.add("Noble Auto Stores");
        DealersArray.add("OSKP Bus Service");
        DealersArray.add("Pandiyan Auto Works");
        DealersArray.add("Parvathi Anugraha International School");
        DealersArray.add("Parvathi Arts And Science");
        DealersArray.add("PAS Auto Stores");
        DealersArray.add("P.M.Jammal Mohaideen");
        DealersArray.add("P.N.R Scooter House");
        DealersArray.add("Prathip Roadways");
        DealersArray.add("P.Vijayakumar(PVK mahal)");
        DealersArray.add("Raj Milk");
        DealersArray.add("Raja Transports");
        DealersArray.add("Rajendran(Britto),Ammapatti");
        DealersArray.add("RMS Auto Services");
        DealersArray.add("Royal Transport");
        DealersArray.add("Sakthi Bus Service(Sowndarya Bus)");
        DealersArray.add("Saraswathi Auto Store");
        DealersArray.add("Sakthivel Vinayagar");
        DealersArray.add("SBM Group Of Institutes");
        DealersArray.add("Selvam Auto Parts & Tool Centre");
        DealersArray.add("Selvam Tractor Works");
        DealersArray.add("Shanmugavel Spinners");
        DealersArray.add("Shiek Bai,Sithaiyankottai");
        DealersArray.add("Sidhu Co-Co Pith");
        DealersArray.add("Siva AutoMobiles");
        DealersArray.add("SMBS");
        DealersArray.add("SMS Auto");
        DealersArray.add("Sona Crane");
        DealersArray.add("Sree Ganapathi Auto Spares");
        DealersArray.add("Sri Andavar Transports(9571)");
        DealersArray.add("Sri Bala's Automoliles");
        DealersArray.add("Sri Balaji Spares&Oils,Vaiyampatti");
        DealersArray.add("Sri Danam Auto Parts ,Vaiyampatti");
        DealersArray.add("Sri Guru Autoworks,Rediyarchatram");
        DealersArray.add("Sri Gurumuki Vidyashramam");
        DealersArray.add("Sri Ram & Company");
        DealersArray.add("Sri Maharishi Educational Trust");
        DealersArray.add("Sri Vijayalakshmi Auto Store");
        DealersArray.add("Sri vinayaka Cars");
        DealersArray.add("S.R.Rajalakshmi Lorry");
        DealersArray.add("Suresh (Jesus Travels)");
        DealersArray.add("Suresh Motors,Vedasaanthur");
        DealersArray.add("Surya Pipe Traders,Vadamadurai");
        DealersArray.add("Talco-Dint-Dindigul-Tamilnaduc");
        DealersArray.add("Thalapakatti pvt Ltd");
        DealersArray.add("Thanga Muthu Machanic");
        DealersArray.add("Thayagam Mattai Company");
        DealersArray.add("Thirumurugan Auto Store,Vedashanthur");
        DealersArray.add("Uniteed Polypacks Pvt Ld,Vedasanthur");
        DealersArray.add("Vaigai Travels");
        DealersArray.add("Vani School,Eriode");
        DealersArray.add("Veera's Automobiles");
        DealersArray.add("Vijayalakshmi Transport(OSKP mini bus)");
        DealersArray.add("Vithya Bharathi Educational Trust");
        DealersArray.add("V.S.Star Auto Agency");
        DealersArray.add("Yuva Car Care,Chinnalapatti");
        DealersArray.notifyDataSetChanged();

    }

    private void fillGopalpattiDivision(){
        DealersArray.clear();
        DealersArray.add("Balaji Traders");
        DealersArray.add("Balamurugan Auto Works");
        DealersArray.add("GVR Gnapathi Auto Store");
        DealersArray.add("P.V.Auto Store");
        DealersArray.add("Saravana Auto Spares");
        DealersArray.add("Sri Lingam Auto Store");
        DealersArray.notifyDataSetChanged();

    }

    private void fillGujiliyamparaiDivision(){
        DealersArray.clear();
        DealersArray.add("A.P.Kumarasami Auto Spares");
        DealersArray.add("Jeeva Uto Care");
        DealersArray.add("Mathiyalagan (Lakshmi Auto Works)");
        DealersArray.add("Ravi Two WHeeler Works");
        DealersArray.add("Sri Varshini Motors");
        DealersArray.add("Thangam Auto Stores,Palayam");
        DealersArray.notifyDataSetChanged();

    }

    private void fillKaraikudi(){
        DealersArray.clear();
        DealersArray.add("Geekay Wash&Run,Karaikudi");
        DealersArray.add("Jothi Auto Store&Electrical");
        DealersArray.add("Kalai Auto Parts(Aasai Motors)");
        DealersArray.add("Kamalam Agency");
        DealersArray.add("Murugan Lubricants");
        DealersArray.add("R.K..N.Auto Works");
        DealersArray.add("Shri Lakshmi Scooters");
        DealersArray.add("Sri Ganesha Moorthi Oil Store");
        DealersArray.add("Sri Senthil Murugan Auto Agencies");
        DealersArray.add("Subiah Agencys");
        DealersArray.notifyDataSetChanged();

    }


    private void fillNatham(){
        DealersArray.clear();
        DealersArray.add("Agni Auto Stores,Sanarpatti");
        DealersArray.add("Benzamin Auto Store");
        DealersArray.add("Mathura Auto Store");
        DealersArray.add("Natam Sri Mariamman Tractor Works");
        DealersArray.add("Shri Muthalamman Auto Works");
        DealersArray.add("Sun Auto");
        DealersArray.add("VPS Travels");
        DealersArray.add("WPR Groups");
        DealersArray.notifyDataSetChanged();

    }

    private void fillNilakottai(){
        DealersArray.clear();
        DealersArray.add("Annam Auto Stores");
        DealersArray.add("Amman Two Wheeler AutoWorks And Service centre");
        DealersArray.add("Maruthamalai Two Wheeler Works");
        DealersArray.add("Prabu,(Thalabathi Two Wheelers Work Shop)");
        DealersArray.add("Rajan Auto Spares And Spares(Maruthu Auto)");
        DealersArray.add("Rthna Auto");
        DealersArray.add("RV Auto");
        DealersArray.add("Saastha Oil Store");
        DealersArray.add("Selvam Auto");
        DealersArray.add("Thlapatji Two Wheeler Work Shop");
        DealersArray.add("VKV Motors");
        DealersArray.notifyDataSetChanged();

    }




    private void fillOttanchathram() {
        DealersArray.clear();
        DealersArray.add("Anbu Auto Spares");
        DealersArray.add("Arul Murugan Auto Mobiles");
        DealersArray.add("Bharath Traders(Karthikeyan),Sriramapuram");
        DealersArray.add("Bilal Oil Store");
        DealersArray.add("Jey Auto Spares& Electricas,Kallimanthaiyam");
        DealersArray.add("Kalaamman Auto Store");
        DealersArray.add("Karthi Auo Mobiles");
        DealersArray.add("Kumaresavarman(Senthil Auto Works)");
        DealersArray.add("Mahalakshmi Auto Spares Parts");
        DealersArray.add("Manikam Cmpany Firm");
        DealersArray.add("New Kumaran Auto Spare Parts");
        DealersArray.add("PRG Vellaper Hr.Sec.School,Neikarapatti");
        DealersArray.add("Renuga Devi Educational Trust Neikarpatti");
        DealersArray.add("Senthil Murugan Auto Stores,ODC(NEW)");
        DealersArray.add("Shanmuga Auto Spares");
        DealersArray.add("Sri Amman Auto Store");
        DealersArray.add("Sri Amman Auto Store,ODDC(NEW)");
        DealersArray.add("Sri Arulmurugan Auto Spares");
        DealersArray.add("Sri Rajesh Auto Spares");
        DealersArray.add("Sri Vinayaga Auto Spares");
        DealersArray.add("Swamy Auto Spare Parts");
        DealersArray.add("Tamilnadu Traders");
        DealersArray.add("Valarmathi Motors");
        DealersArray.add("Vishnu Traders");
        DealersArray.notifyDataSetChanged();
    }

    private void fillPalani(){
        DealersArray.clear();
        DealersArray.add("Ambal Auto Spares");
        DealersArray.add("Balu Two Wheelers Works");
        DealersArray.add("Deepa Automobiles");
        DealersArray.add("Kannan Auto Store");
        DealersArray.add("Palaniyappa Auto Spare Parts");
        DealersArray.add("Saahithiya Cars");
        DealersArray.add("Sabari Traders");
        DealersArray.notifyDataSetChanged();

    }

    private void fillPeriyakulam(){
        DealersArray.clear();
        DealersArray.add("Annamalai Auto Stores");
        DealersArray.add("Annamalai Traders");
        DealersArray.add("Hameedia Auto Mobiles");
        DealersArray.add("Indian Traders ");
        DealersArray.add("Popular Two Wheeler Spare Parts");
        DealersArray.add("Siva Sakthi Motors");
        DealersArray.add("Sri Easwari Motors");
        DealersArray.add("Sri Ganesh Auto Agency");
        DealersArray.add("T.S.Auto Store");
        DealersArray.add("VKS Oil Agencies");
        DealersArray.notifyDataSetChanged();

    }



    private void fillSinganampuneri(){
        DealersArray.clear();
        DealersArray.add("C.S.R.Tires&Spares");
        DealersArray.add("G.S.Auto Works");
        DealersArray.add("Muthu Auto Mobiles");
        DealersArray.add("Raj Auto Spares");
        DealersArray.add("Sakthivel Auto Stores");
        DealersArray.add("Shri Veeraiah Motor's");
        DealersArray.add("Siva Auto Spares");
        DealersArray.notifyDataSetChanged();

    }


    private void fillTheni(){
        DealersArray.clear();
        DealersArray.add("Amman Auto Store,K.vilakku");
        DealersArray.add("Annai Muthu Mari Amman Stores");
        DealersArray.add("Annamalai Auto Mobiles");
        DealersArray.add("Ayyappa Auto,Kottampatti");
        DealersArray.add("Bathri Auto Store");
        DealersArray.add("Boss Two Wheeler Works,Veerapandi");
        DealersArray.add("Chellapa Auto Store,Devaram");
        DealersArray.add("C.S.K.Auto Store");
        DealersArray.add("Deivam Tractor,Uthamapalayam");
        DealersArray.add("G.K.Automobiles");
        DealersArray.add("Gurumoorthi Auto Store,Andipatti");
        DealersArray.add("Jamki Automobiles");
        DealersArray.add("Jeyalakshmi Auto Mobiles");
        DealersArray.add("Jeyam Auto Spare Parts,Andipatti");
        DealersArray.add("Jeya Two Wheeler Works,Andipatti");
        DealersArray.add("Jintha Auto Works,Uthamapalayam");
        DealersArray.add("JJ Automobiles,Andipatti");
        DealersArray.add("J.K. Traders,Andipatti");
        DealersArray.add("Kalai Auto Store");
        DealersArray.add("Kamadhenu Motor Cycle Company");
        DealersArray.add("Kanishka Auto Store,Kadamalaikundu");
        DealersArray.add("Kanna Auto Store");
        DealersArray.add("Karthileya Tractor Spares");
        DealersArray.add("KC Automobiles,Thevaram");
        DealersArray.add("Krishna Auto Mobiles");
        DealersArray.add("KRR Traders");
        DealersArray.add("KRS Auto Stores,Kottampatti");
        DealersArray.add("Mahadev Auto Mobiles");
        DealersArray.add("M&R Auto mobies");
        DealersArray.add("MS Auto,Aundipatti");
        DealersArray.add("Nandhini Auto&Two Wheelers Spares,Aundipaati");
        DealersArray.add("N.R.Auto");
        DealersArray.add("N.S.K.Automobiles ");
        DealersArray.add("Om Muruga Autoworkshop,Aundipaati");
        DealersArray.add("Polymer Tires & Lubricants,Thirupathur");
        DealersArray.add("Ponnar Shankar Auto,Devaram");
        DealersArray.add("Raj Two Wheeler Works,Aundipatti");
        DealersArray.add("Raphale Auto,Kombai");
        DealersArray.add("Sait Roadways");
        DealersArray.add("Saravana Auto Store");
        DealersArray.add("Saravana Tractor");
        DealersArray.add("Shankar Auto Spares");
        DealersArray.add("Shri Blaji Two Wheeler Spares ,Theni(old)");
        DealersArray.add("Shree Auto Store");
        DealersArray.add("Shree Chakra Auto Spares,Thirupathur");
        DealersArray.add("Sri Anjanaya Auto Store");
        DealersArray.add("Sri Balaji Auto Parts,Theni(NEW)");
        DealersArray.add("Sri Balaji Auto Spares");
        DealersArray.add("Sri Balaji Auto Store");
        DealersArray.add("Sri Eswari Motors");
        DealersArray.add("Sri Lakshmi Auto Stores");
        DealersArray.add("Sri Mahalakshmi Auto Store");
        DealersArray.add("Sri Mathi Auto Store");
        DealersArray.add("Sri Meenakshi Auto Mobiles");
        DealersArray.add("Sri Meenachi Auto Store,Aundipatti");
        DealersArray.add("Srinivasa Auto Store,Theni(NEW)");
        DealersArray.add("Sri Rajaram Auto Mobiles");
        DealersArray.add("Sri Sarava Auto Parts");
        DealersArray.add("Sri Senthil Andavar Auto Store,Aundipatti");
        DealersArray.add("Sri Venkateshwara Auto Parts");
        DealersArray.add("Sri Vignesh Traders");
        DealersArray.add("SS Auto Spares");
        DealersArray.add("Suryaa Auto Store,Aundipatti");
        DealersArray.add("Suriya Auto Mobiles,Jakkampatti");
        DealersArray.add("Theni Kamavar Sangam Arts& Science College");
        DealersArray.add("Thirumalai Meenatshi,Devaram");
        DealersArray.add("Tirumani Ati Auto Stores");
        DealersArray.add("UmaSankar Auto Store,Aundipaati");
        DealersArray.add("Vel Automobile");
        DealersArray.add("Velavan Milk Store");
        DealersArray.add("Venkatesh Auto");
        DealersArray.add("Venkateshwara Store,Thirupathur");
        DealersArray.add("Vignesh Auto Store,Madurai");
        DealersArray.notifyDataSetChanged();

    }


    private void fillThirupathur(){
        DealersArray.clear();
        DealersArray.add("Polimer Tyres&Lubricants");
        DealersArray.add("Sree Chakra Auto Spares");
        DealersArray.add("Venkateshwara Store T.Patti");
        DealersArray.notifyDataSetChanged();

    }


    private void fillUsilampatti(){
        DealersArray.clear();
        DealersArray.add("Amaravathi Tracter Works");
        DealersArray.add("Anbu Auto Store");
        DealersArray.add("Aravind Agro Enterprises");
        DealersArray.add("Gokul Motors");
        DealersArray.add("Jeya Auto Spares");
        DealersArray.add("MBR Automobiles & Oil Stores");
        DealersArray.add("MRP Two Wheeler SPare Parts");
        DealersArray.add("Pandiyan Auto SPare Parts");
        DealersArray.add("Raja Spare Parts");
        DealersArray.add("Sravana Auto Spares");
        DealersArray.add("Suba Auto Store");
        DealersArray.notifyDataSetChanged();

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void alertDisplayer(String title,String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(AreaActivity.this)

                .setTitle(title)

                .setMessage(message)

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                        sp.edit().putBoolean("logged",false).apply();

                        Intent intent = new Intent(AreaActivity.this, LoginActivity.class);

                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                        startActivity(intent);

                    }


                });

        AlertDialog ok = builder.create();

        ok.show();

    }
}