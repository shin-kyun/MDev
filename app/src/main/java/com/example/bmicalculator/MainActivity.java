package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button calculate;
    EditText height, weight;
    TextView result, category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate=findViewById(R.id.Calculate);
        height=findViewById(R.id.Height);
        weight=findViewById(R.id.Weight);
        result=findViewById(R.id.Result);
        category=findViewById(R.id.category);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getH=height.getText().toString();
                String getW=weight.getText().toString();

                float H=Float.parseFloat(getH);
                float W=Float.parseFloat(getW);

                float newH=H/100;
                float bmi=W/(newH*newH);

                result.setText("Your BMI is... \n"+String.format("%.2f", bmi));

                if(bmi<18.5) {
                    category.setText("Underweight");
                }else if (bmi>=18.5&&bmi<24.9) {
                    category.setText("Normal");
                }else if (bmi==25&&bmi<29.9) {
                    category.setText("Overweight");
                }else {
                    category.setText("Obese");
                }
        };

    });
}
}