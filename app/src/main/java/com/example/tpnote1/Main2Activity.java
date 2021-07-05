package com.example.tpnote1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    protected TextView activity;
    protected TextView revenue;
    protected TextView cotisation;
    protected TextView benefice;
    protected Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        activity = findViewById(R.id.activityTextView);
        revenue = findViewById(R.id.revenueTextView);
        cotisation = findViewById(R.id.cotisationTextView);
        benefice = findViewById(R.id.beneficeTextView);
        returnButton = findViewById(R.id.returnButton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        if (intent != null) {
            Data d = intent.getParcelableExtra("DATASEND");
            activity.setText(d.getActivity());
            revenue.setText("Chiffre d'affaire : " + d.getRevenue().toString());
            Double resultCotis;
            Double resultBenef;
            switch (d.getActivity()){
                case "Vente de marchandise":
                    resultCotis = (d.getRevenue()*0.128);
                    cotisation.setText("Cotisations : " + d.getRevenue().toString() + " * 0,128 = " + resultCotis.toString());
                    resultBenef = (d.getRevenue() - resultCotis);
                    benefice.setText("Bénéfice : " + d.getRevenue().toString() + " - " + resultCotis.toString() + " = " + resultBenef.toString());
                    break;
                case "Location d'habitation meublée":
                    resultCotis = (d.getRevenue()*0.22);
                    cotisation.setText("Cotisations : " + d.getRevenue().toString() + " * 0,22 = " + resultCotis.toString());
                    resultBenef = (d.getRevenue() - resultCotis);
                    benefice.setText("Bénéfice : " + d.getRevenue().toString() + " - " + resultCotis.toString() + " = " + resultBenef.toString());
                    break;
                case "Location d'habitation meublée de tourisme":
                    resultCotis = (d.getRevenue()*0.06);
                    cotisation.setText("Cotisations : " + d.getRevenue().toString() + " * 0,06 = " + resultCotis.toString());
                    resultBenef = (d.getRevenue() - resultCotis);
                    benefice.setText("Bénéfice : " + d.getRevenue().toString() + " - " + resultCotis.toString() + " = " + resultBenef.toString());
                    break;
                case "Prestation de service":
                    resultCotis = (d.getRevenue()*0.22);
                    cotisation.setText("Cotisations : " + d.getRevenue().toString() + " * 0,22 = " + resultCotis.toString());
                    resultBenef = (d.getRevenue() - resultCotis);
                    benefice.setText("Bénéfice : " + d.getRevenue().toString() + " - " + resultCotis.toString() + " = " + resultBenef.toString());
                    break;
                case "Profession libérale":
                    resultCotis = (d.getRevenue()*0.22);
                    cotisation.setText("Cotisations : " + d.getRevenue().toString() + " * 0,22 = " + resultCotis.toString());
                    resultBenef = (d.getRevenue() - resultCotis);
                    benefice.setText("Bénéfice : " + d.getRevenue().toString() + " - " + resultCotis.toString() + " = " + resultBenef.toString());
                    break;
            }
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
