package com.example.zack.cameraandseekbar;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekbarActivity extends AppCompatActivity {

    private SeekBar loanAmountSeekBar;
    private TextView loanAmountTextView;
    private SeekBar interestRateSeekBar;
    private TextView interestRateTextView;
    private SeekBar loanTenureSeekBar;
    private TextView loanTenureTextView;
    private TextView resultsTextView;
    private double iRate = .01;
    private int lAmount = 10000;
    private int lMonths = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);



        resultsTextView = (TextView) findViewById(R.id.resultTextView);
        loanAmountTextView = (TextView) findViewById(R.id.loanAmountTextView);
        loanAmountSeekBar = (SeekBar) findViewById(R.id.loanAmountSeekBar);
        loanAmountSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            String loanAmount;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                switch (progressValue){
                    case 0: loanAmount = "$10,000";
                        lAmount = 10000;
                        break;
                    case 1: loanAmount = "$20,000";
                        lAmount = 20000;
                        break;
                    case 2: loanAmount = "$30,000";
                        lAmount = 30000;
                        break;
                    case 3: loanAmount = "$40,000";
                        lAmount = 40000;
                        break;
                    case 4: loanAmount = "$50,000";
                        lAmount = 50000;
                        break;
                    case 5: loanAmount = "$60,000";
                        lAmount = 60000;
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                loanAmountTextView.setText(loanAmount);
                resultsTextView.setText(getResult());
            }

        });


        interestRateTextView = (TextView) findViewById(R.id.interestRateTextView);
        interestRateSeekBar = (SeekBar) findViewById(R.id.interestRateSeekBar);
        interestRateSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            String interestRate;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                switch (progressValue){
                    case 0: interestRate = "1%";
                        iRate = .01;
                        break;
                    case 1: interestRate = "2%";
                        iRate = .02;
                        break;
                    case 2: interestRate = "3%";
                        iRate = .03;
                        break;
                    case 3: interestRate = "4%";
                        iRate = .04;
                        break;
                    case 4: interestRate = "5%";
                        iRate = .05;
                        break;
                    case 5: interestRate = "6%";
                        iRate = .06;
                        break;
                }
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                interestRateTextView.setText(interestRate);
                resultsTextView.setText(getResult());
            }

        });

        loanTenureTextView = (TextView) findViewById(R.id.loanTenureTextView);
        loanTenureSeekBar = (SeekBar) findViewById(R.id.loanTenureSeekBar);
        loanTenureSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            String loanTenure;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                switch (progressValue){
                    case 0: loanTenure = "1 Month";
                        lMonths = 1;
                        break;
                    case 1: loanTenure = "2 Months";
                        lMonths = 2;
                        break;
                    case 2: loanTenure = "3 Months";
                        lMonths = 3;
                        break;
                    case 3: loanTenure = "4 Months";
                        lMonths = 4;
                        break;
                    case 4: loanTenure = "5 Months";
                        lMonths = 5;
                        break;
                    case 5: loanTenure = "6 Months";
                        lMonths = 6;
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                loanTenureTextView.setText(loanTenure);
                resultsTextView.setText(getResult());
            }

        });
    }

    public void goToCamera(View view) {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getResult (){
        NumberFormat formatter = new DecimalFormat("#0.00");
        Double result = ((lAmount*iRate*Math.pow(1+iRate,lMonths))/(Math.pow(1+iRate,lMonths)-1));
        return ("EMI: $" + formatter.format(result));
    }

}
