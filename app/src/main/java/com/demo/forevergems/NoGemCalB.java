package com.demo.forevergems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class NoGemCalB extends AppCompatActivity implements View.OnClickListener {
    EditText Entermaterial1, Enterprice1, purity, Enterweight1, Enterhours1, laborhours, Enteroverhead1 ;
    String strmaterial, strprice, strpurity, strweight, strhours, strlaorhours, stroverhead, resultMessage;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_gem_cal_b);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoGemCalB.this,chart.class);
                startActivity(intent);

            }

        });

    }

    @Override
    public void onClick(View v) {
        ComputeResult();
    }

    public void ComputeResult() {

        Entermaterial1 = (EditText) findViewById(R.id.Entermaterial1);
        Enterprice1 = (EditText) findViewById(R.id.Enterprice1);
        purity = (EditText) findViewById(R.id.purity);
        Enterweight1 = (EditText) findViewById(R.id.Enterweight1);
        Enterhours1 = (EditText) findViewById(R.id.Enterhours1);
        laborhours = (EditText) findViewById(R.id.laborhours);
        Enteroverhead1 = (EditText) findViewById(R.id.Enteroverhead1);

        if (Entermaterial1.getText().toString().isEmpty() || Enterprice1.getText().toString().isEmpty() ||
                purity.getText().toString().isEmpty() || Enterweight1.getText().toString().isEmpty() ||
                Enterhours1.getText().toString().isEmpty() || laborhours.getText().toString().isEmpty() || Enteroverhead1.getText().toString().isEmpty()) {


            strmaterial = "0";
            strprice = "0";
            strpurity = "0";
            strweight = "0";
            strhours = "0";
            strlaorhours = "0";
            stroverhead = "0";

        } else {

            strmaterial = Entermaterial1.getText().toString();
            strprice = Enterprice1.getText().toString();
            strpurity = purity.getText().toString();
            strweight = Enterweight1.getText().toString();
            strhours = Enterhours1.getText().toString();
            strlaorhours = laborhours.getText().toString();
            stroverhead = Enteroverhead1.getText().toString();
        }

        double matprice = Double.parseDouble(strprice);
        double matpurity = Double.parseDouble(strpurity);
        double matweight = Double.parseDouble(strweight);
        double lcost = Double.parseDouble(strhours);
        double lhours = Double.parseDouble(strlaorhours);
        double overhead = Double.parseDouble(stroverhead);

        double tmrate = ((matprice*(matpurity/100)*matweight));
        double ltr = lhours*lcost;
        double or = ((tmrate + ltr)*(overhead/100));
        double ic = (tmrate+ltr+or);
        double wholesalep = ic*2;
        double retail = wholesalep*2.5;



        resultMessage ="\n\n\n"+"Category : No Stone Bracelet"+"\n"+"-------------------------------------------------------------"+
                "\n\n\n"+"Material :"+strmaterial +"\n" + "Material Purity :"+
                matpurity +"%"+"\n"+"Total Material Rate :"+ tmrate+"\n"
                +"-------------------------------------------------------------"+"\n"+
                "Total Labor Rate :" + ltr +"\n" +
                ""+"Overhead Rate :"+ or+"%"+"\n"+
                "-------------------------------------------------------------"+"\n"+
                "Initial Cost :"+ic+"\n\n\n\n"+"-------------------------------------------------------------"+"\n"+
                "Wholesale Price :"+ wholesalep+"\n"+"-------------------------------------------------------------"+"\n"+"\n\n\n\n"+
                "-------------------------------------------------------------"+"\n"+
                "Retail Price :"+ retail+"\n"+"-------------------------------------------------------------"+"\n";

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
        Entermaterial1.getText().clear();
        Enterprice1.getText().clear();
        purity.getText().clear();
        Enterweight1.getText().clear();
        Enterhours1.getText().clear();
        laborhours.getText().clear();
        Enteroverhead1.getText().clear();
        Entermaterial1.requestFocus();
    }
}
