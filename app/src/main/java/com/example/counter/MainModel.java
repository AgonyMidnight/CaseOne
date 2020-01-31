package com.example.counter;

import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.Chronometer;

import java.util.logging.LogRecord;

public class MainModel implements MainContract.Model {
    String Value,Valuetime;
    public String getCalculation(String temp, String temp2){ //новое значение счетчика
        int getNumber = Integer.parseInt(temp2);
        if (temp == "+"){ //если передан +, то увеличим
            getNumber++;
        }
        else {
            getNumber--; //и наоборот
        }
        Value = Integer.toString(getNumber);
        return Value;  //вернем значение
    };
    public String setNull(){
        return Value = "0";

    };
    public String getMiddleClick (String Value, String mTimer){ //вычисление среднего кол-ва кликов
        int stoppedMilliseconds = 0;

        //String haa = mTimer.replace(':','.'); //заменим : на .

        String myTimer = mTimer;
        char ChroArray [] = myTimer.toCharArray();

        String znsm = ChroArray [0] + "." +ChroArray [1] ;
        //myTimer = myTimer.replace(':','.');

        //String ChroArray [] = mTimer.split (":");

        float dsgber= (Integer.parseInt(Value))/(Integer.parseInt(ChroArray [0] + "." +ChroArray [1]));
        String sdcgv= Float.toString (dsgber);
        return sdcgv; //возвращаем результат вычисления
    }
}
