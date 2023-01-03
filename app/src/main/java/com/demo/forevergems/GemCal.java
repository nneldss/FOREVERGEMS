package com.demo.forevergems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class GemCal extends AppCompatActivity implements View.OnClickListener{

    EditText Entermaterialg, Enterpriceg, purityg, Enterweightg, Enterhoursg, laborhoursg, Enteroverheadg, caratg, gemtypeg, caratpriceg;
    String strmaterial, strprice, strpurity, strweight, strhours, strlaorhours, stroverhead,strcarat, resultMessage, strgemtypeg, strcaratpriceg;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gem_cal);

        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GemCal.this,chart.class);
                startActivity(intent);

            }

        });

        Button button = findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ComputeResult();
    }

    public void ComputeResult()

    {
        caratpriceg = (EditText) findViewById(R.id.caratpriceg);
        gemtypeg = (EditText) findViewById(R.id.gemtypeg);
        Entermaterialg = findViewById(R.id.Entermaterialg);
        caratg = findViewById(R.id.caratg);
        Enterpriceg = findViewById(R.id.Enterpriceg);
        purityg= findViewById(R.id.purityg);
        Enterweightg = findViewById(R.id.Enterweightg);
        Enterhoursg = findViewById(R.id.Enterhoursg);
        laborhoursg = findViewById(R.id.laborhoursg);
        Enteroverheadg = findViewById(R.id.Enteroverheadg);

        if (Entermaterialg.getText().toString().isEmpty() || gemtypeg.getText().toString().isEmpty()|| caratpriceg.getText().toString().isEmpty()|| Enterpriceg.getText().toString().isEmpty() || caratg.getText().toString().isEmpty() ||
                purityg.getText().toString().isEmpty() || Enterweightg.getText().toString().isEmpty() ||
                Enterhoursg.getText().toString().isEmpty() || laborhoursg.getText().toString().isEmpty() || Enteroverheadg.getText().toString().isEmpty()) {

            strcaratpriceg ="0";
            strgemtypeg = "0";
            strmaterial = "0";
            strprice = "0";
            strpurity = "0";
            strcarat="0";
            strweight = "0";
            strhours = "0";
            strlaorhours = "0";
            stroverhead = "0";

        } else {
            strcaratpriceg = caratpriceg.getText().toString();
            strgemtypeg = gemtypeg.getText().toString();
            strmaterial = Entermaterialg.getText().toString();
            strprice = Enterpriceg.getText().toString();
            strpurity = purityg.getText().toString();
            strweight = Enterweightg.getText().toString();
            strhours = Enterhoursg.getText().toString();
            strcarat = caratg.getText().toString();
            strlaorhours = laborhoursg.getText().toString();
            stroverhead = Enteroverheadg.getText().toString();
        }
        double caratprice = Double.parseDouble(strcaratpriceg);
        double matprice = Double.parseDouble(strprice);
        double matpurity = Double.parseDouble(strpurity);
        double matweight = Double.parseDouble(strweight);
        double dcarat = Double.parseDouble(strcarat);
        double lcost = Double.parseDouble(strhours);
        double lhours = Double.parseDouble(strlaorhours);
        double overhead = Double.parseDouble(stroverhead);

        double carattotal = caratprice*dcarat;
        double tmrate = ((matprice*(matpurity/100)*matweight));
        double ltr = lhours*lcost;
        double or = ((tmrate + ltr+carattotal)*(overhead/100));
        double ic = (tmrate+ltr+or+carattotal);
        double wholesalep = ic*2;
        double retail = wholesalep*2.5;
        double result = retail;

        resultMessage ="\n\n\n"+"Category : Gemstone Ring"+"\n"+"-------------------------------------------------------------"+
                "\n\n\n"+"Gem Type : "+strgemtypeg+"\n"+"Gemstone Carat: "+dcarat+"\n"+"Gemstone Price Today :"+strcaratpriceg+"\n"+"-------------------------------------------------------------"+"\n"+"Total Gemstone Price :"+carattotal+"\n\n\n"+"Material :"+strmaterial +"\n" + "Material Purity :"+
                matpurity +"%"+"\n"+"Total Material Rate :"+ tmrate+"\n"
                +"-------------------------------------------------------------"+"\n"+
                "Total Labor Rate :" + ltr +"\n" +
                ""+"Overhead Rate :"+ or+"\n"+
                "-------------------------------------------------------------"+"\n"+
                "Initial Cost :"+ic+"\n\n\n"+"-------------------------------------------------------------"+"\n"+
                "Wholesale Price :"+ wholesalep+"\n"+"-------------------------------------------------------------"+"\n"+"\n\n\n"+
                "-------------------------------------------------------------"+"\n"+
                "Retail Price :"+ result+"\n"+"-------------------------------------------------------------"+"\n";

        // Create Bundle instance, this will allow transfer of data from Activity to DialogFragment
        Bundle args = new Bundle();
        args.putString("result", resultMessage);

        // Create a dialog instance
        DialogFragmentCustom dialogFragmentImp = new DialogFragmentCustom();
        // Pass on dialog argument(args), the result
        dialogFragmentImp.setArguments(args);
        // Display the Dialog
        dialogFragmentImp.show(getSupportFragmentManager(),"Display Result");
        // Reset EditTexts
        clearEditText();
    }
    public void clearEditText(){
        Entermaterialg.getText().clear();
        Enterpriceg.getText().clear();
        purityg.getText().clear();
        Enterweightg.getText().clear();
        Enterhoursg.getText().clear();
        laborhoursg.getText().clear();
        Enteroverheadg.getText().clear();
        Entermaterialg.requestFocus();
    }
}