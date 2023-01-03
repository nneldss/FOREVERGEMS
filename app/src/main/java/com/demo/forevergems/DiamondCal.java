package com.demo.forevergems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DiamondCal { extends AppCompatActivity implements View.OnClickListener{

    EditText Entermateriald, Enterpriced, purityd, Enterweightd, Enterhoursd, laborhoursd, Enteroverheadd, caratd, caratpriced;
    String strmaterial, strprice, strpurity, strweight, strhours, strlaorhours, stroverhead,strcarat, resultMessage, strcaratpriced;    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_cal);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);

        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiamondCal.this,chart.class);
                startActivity(intent);

            }

        });

    }

    @Override
    public void onClick(View v) {
        ComputeResult();
    }

    public void ComputeResult()
    {
        caratpriced = findViewById(R.id.caratpriced);
        Entermateriald = findViewById(R.id.Entermateriald);
        caratd = findViewById(R.id.caratd);
        Enterpriced = findViewById(R.id.Enterpriced);
        purityd= findViewById(R.id.purityd);
        Enterweightd = findViewById(R.id.Enterweightd);
        Enterhoursd = findViewById(R.id.Enterhoursd);
        laborhoursd = findViewById(R.id.laborhoursd);
        Enteroverheadd = findViewById(R.id.Enteroverheadd);

        if (Entermateriald.getText().toString().isEmpty() || Enterpriced.getText().toString().isEmpty()|| caratpriced.getText().toString().isEmpty()  || caratd.getText().toString().isEmpty() ||
                purityd.getText().toString().isEmpty() || Enterweightd.getText().toString().isEmpty() ||
                Enterhoursd.getText().toString().isEmpty() || laborhoursd.getText().toString().isEmpty() || Enteroverheadd.getText().toString().isEmpty()) {

            strcaratpriced = "0";
            strmaterial = "0";
            strprice = "0";
            strpurity = "0";
            strcarat="0";
            strweight = "0";
            strhours = "0";
            strlaorhours = "0";
            stroverhead = "0";

        } else {
            strcaratpriced = caratpriced.getText().toString();
            strmaterial = Entermateriald.getText().toString();
            strprice = Enterpriced.getText().toString();
            strpurity = purityd.getText().toString();
            strweight = Enterweightd.getText().toString();
            strhours = Enterhoursd.getText().toString();
            strcarat = caratd.getText().toString();
            strlaorhours = laborhoursd.getText().toString();
            stroverhead = Enteroverheadd.getText().toString();
        }

        double dpcarat = Double.parseDouble(strcaratpriced);
        double matprice = Double.parseDouble(strprice);
        double matpurity = Double.parseDouble(strpurity);
        double matweight = Double.parseDouble(strweight);
        double dcarat = Double.parseDouble(strcarat);
        double lcost = Double.parseDouble(strhours);
        double lhours = Double.parseDouble(strlaorhours);
        double overhead = Double.parseDouble(stroverhead);

        double carattotal = dpcarat*dcarat;
        double tmrate = ((matprice*(matpurity/100)*matweight));
        double ltr = lhours*lcost;
        double or = ((tmrate + ltr+carattotal)*(overhead/100));
        double ic = (tmrate+ltr+or+carattotal);
        double wholesalep = ic*2;
        double retail = wholesalep*2.5;
        double result = retail;

        resultMessage ="\n\n\n"+"Category : Diamond Ring"+"\n"+"-------------------------------------------------------------"+
                "\n\n\n"+"Diamond Carat: "+dcarat+"\n"+"Diamond Price Today :"+strcaratpriced+"\n"+"-------------------------------------------------------------"+"\n"+"Total Diamond Price :"+carattotal+"\n\n\n"+"Material :"+strmaterial +"\n" + "Material Purity :"+
                matpurity +"%"+"\n"+"Total Material Rate :"+ tmrate+"\n"
                +"-------------------------------------------------------------"+"\n"+
                "Total Labor Rate :" + ltr +"\n" +
                ""+"Overhead Rate :"+ or+"\n"+
                "-------------------------------------------------------------"+"\n"+
                "Initial Cost :"+ic+"\n\n\n\n"+"-------------------------------------------------------------"+"\n"+
                "Wholesale Price :"+ wholesalep+"\n"+"-------------------------------------------------------------"+"\n"+"\n\n\n\n"+
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
        Entermateriald.getText().clear();
        Enterpriced.getText().clear();
        purityd.getText().clear();
        Enterweightd.getText().clear();
        Enterhoursd.getText().clear();
        laborhoursd.getText().clear();
        Enteroverheadd.getText().clear();
        Entermateriald.requestFocus();
    }
}
