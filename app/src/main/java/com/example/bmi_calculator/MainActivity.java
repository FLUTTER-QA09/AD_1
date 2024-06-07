package com.example.bmi_calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        TextView txtResult;
        EditText edtWT, edtHTFT, edtHTIN;
        Button btnCal;
        LinearLayout llMain;
        int ovW = ContextCompat.getColor(this, R.color.ovW);
        int unW = ContextCompat.getColor(this, R.color.unW);
        int hW = ContextCompat.getColor(this, R.color.hW);

        edtWT = findViewById(R.id.edtWeight);
        edtHTFT = findViewById(R.id.edtHeightFT);
        edtHTIN = findViewById(R.id.edtHeightIN);
        btnCal = findViewById(R.id.btnCal);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWT.getText().toString());
                int htFT = Integer.parseInt(edtHTFT.getText().toString());
                int htIN = Integer.parseInt(edtHTIN.getText().toString());

                int totalIN = htFT * 12 + htIN;
                double totalCm = totalIN * 2.53;
                double totalM = totalCm / 100;


                double bmi = wt / (totalM * totalM);

                if (bmi > 25) {
                    txtResult.setText("U R overweight");
                    llMain.setBackgroundColor(ovW);
                } else if (bmi < 18) {
                    txtResult.setText("U R Underweight");
                    llMain.setBackgroundColor(unW);
                } else {
                    txtResult.setText("U R  healthy");
                    llMain.setBackgroundColor(hW);
                }


            }
        });
    }
}