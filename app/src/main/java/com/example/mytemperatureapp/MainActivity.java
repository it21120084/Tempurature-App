package com.example.mytemperatureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText et;
    RadioGroup rg;
    TextView tv;
    RadioButton rb1;
    RadioButton rb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnTemp);
        et = findViewById(R.id.etTemp);
        rg = findViewById(R.id.rgTemp);
        tv = findViewById(R.id.tvTemp);
        rb1 = findViewById(R.id.rbCel);
        rb2 = findViewById(R.id.rbFah);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onClick Method
                calculateAnswer();

                //Toast.makeText(this,"Please enter a value",Toast.LENGTH_LONG).show();


            }
        });
    }

    protected void calculateAnswer(){
        String s = et.getText().toString();
        Boolean error = Boolean.FALSE;

        if( s.equals("")){
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_LONG).show();
        }
        else{ Float d=0.0f;
                    try {
                        d = Float.parseFloat(s);
                    }
                    catch(NumberFormatException e)
                    {
                        Toast.makeText(this,"Invalid Entry", Toast.LENGTH_SHORT).show();
                        error = Boolean.TRUE;
                    }

                if(!error){
                    int i = rg.getCheckedRadioButtonId(); //user's selection

                    if(i == R.id.rbCel)
                    {
                        //call Celcius to Fahrenheit
                        tv.setText(convertCelciusToFahrenheit(d) +"");
                    }
                    else
                    {
                        //call Fahrenheit to Celcius
                            tv.setText(convertFahrenheitToCelcius(d)+"");
                    }

                }
        }

    }
    protected float convertCelciusToFahrenheit(Float value){
        Float ans = (value *9/5) +32 ;
        return ans;
    }

    protected float convertFahrenheitToCelcius(Float value){
        Float ans = (value *9/5) * 5/9;
        return ans;
    }


}