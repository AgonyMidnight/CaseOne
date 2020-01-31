package com.example.counter;

import android.widget.Chronometer;
import android.widget.TextView;

public interface MainContract {
    interface  View{
        void showCounter(String ValueCount);
        void showMiddleClick(String Middle);
        String runTimer();
        void stopTimer();
    }
    interface Presenter {

        void onButtomClickDischarge();
        void Destroy();

        void onButtomClickMinus(TextView mCounter, String Ha);

        void onButtomClickPlus(TextView mCounter, String Ha);
    }
    interface Model{
        String getCalculation(String temp, String temp2);
        String setNull();
        String getMiddleClick (String Value, String mTimer);

    }
}
