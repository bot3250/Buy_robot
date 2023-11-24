package com.bot.buy_robot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float robotPrice = 35000;
    float amount = 1700;
    float account = 700;
    int percent = 9;
    int countMonth;
    float[] monthlyPayments;
    TextView textCountOut, textManyMonthOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCountOut = findViewById(R.id.textCountOut);
        textManyMonthOut = findViewById(R.id.textManyMonthOut);

        textCountOut.setText(countMonth()+" месяцев");
        String monthlyPaymentsList = "";
        int i = 0;
        while (i <= monthlyPayments.length-1){
            i++;
            if(i>1){
                monthlyPaymentsList += Float.toString(monthlyPayments[i-1]) + ", ";
            }
        }
        textManyMonthOut.setText("Первоначальный взнос " + account + " монет, ежемесячные накопления:"+monthlyPaymentsList);
    }

    private int countMonth(){
        float total = robotPrice-account;
//        countMonth = (int) (total/amount*(100+percent)/100);
        float mortgageCosts = amount*(percent+100)/100;
        monthlyPayments = new float[30];
        while (total>0){
            countMonth++;
            total = (total-mortgageCosts);
            account +=  countMonth * (percent + 100) / 100;
            if(total>mortgageCosts) {
                monthlyPayments[countMonth - 1] = amount;
            } else {
                monthlyPayments[countMonth-1]=total;
                break;
            }
        }
        return countMonth-1;
    }

}