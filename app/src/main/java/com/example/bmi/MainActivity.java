package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText weightRe, heightRe;
        final TextView bmiDet, bmiDis;
        final Button bmiCalc, bmiRes;

        weightRe = findViewById(R.id.weight_result);
        heightRe = findViewById(R.id.height_result);
        bmiDet = findViewById(R.id.bmi_detail);
        bmiDis = findViewById(R.id.bmi_display);
        bmiCalc = findViewById(R.id.bmi_calculate);
        bmiRes = findViewById(R.id.bmi_reset);

        bmiCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strWeg = weightRe.getText().toString();
                String strHei = heightRe.getText().toString();

                if(strWeg.equals("")){
                    weightRe.setError("Please Enter Your Weight");
                    weightRe.requestFocus();
                    return;
                }
                if(strHei.equals("")){
                    heightRe.setError("Please Enter your Height");
                    heightRe.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(strWeg);
                float height = Float.parseFloat(strHei) / 100;

                float bmiValue = BMICalculator(weight, height);
                bmiDet.setText(interpretBMI(bmiValue));
                bmiDis.setText("BMI =" + bmiValue);

            }
        });
        bmiRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heightRe.setText("");
                weightRe.setText("");
                bmiDis.setText("");
                bmiDet.setText("");
            }
        });
    }
    public float BMICalculator(float weight, float height){
        return weight /(height * height);
    }
    public String interpretBMI(float bmiValue){
        if(bmiValue < 16){
            return "Severely Underweight";
        }
        else if(bmiValue < 18.5){
            return "Underweight";
        }
        else if(bmiValue < 25){
            return "Normal";
        }
        else if(bmiValue < 30){
            return "Overweight";
        }
        else
            return "Obese";
    }
}