package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainPresenter mPresenter;
    private Button ButtonLeft;
    private Button ButtomCancel;
    private Button ButtonRight;
    private TextView mCounter;
    private TextView MiddleClick;
    public Chronometer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           mPresenter = new MainPresenter(this);
        ButtonLeft = (Button)findViewById(R.id.b_reduce); //уменьшить
        ButtomCancel = (Button)findViewById(R.id.b_cancel); //сброс
        ButtonRight = (Button)findViewById(R.id.b_increase);//Увеличить
        mCounter = (TextView)findViewById(R.id.Counter); //кол-во нажатий

        MiddleClick= (TextView)findViewById(R.id.middleClick) ;
        mTimer  = (Chronometer)findViewById(R.id.chrohonTimer);
        ButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Ha = mTimer.getText().toString();
               mPresenter.onButtomClickMinus(mCounter,Ha);
                mTimer.start();
            }
        });
        ButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Ha = mTimer.getText().toString();
               mPresenter.onButtomClickPlus(mCounter, Ha);
                mTimer.start();
            }

        });
        ButtomCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onButtomClickDischarge();

            }
        });


    }




    @Override
    public void showCounter(String temp) {
        mCounter.setText(temp);
    }
    @Override
    public String runTimer(){
       mTimer.start();
        String Ha = mTimer.getText().toString(); //вернем значение секундомера

      //  mTimer.start();
        return Ha;


    }
    @Override
    public void stopTimer(){
        mTimer.setBase(SystemClock.elapsedRealtime()); //сброс
    }
    @Override
    public void showMiddleClick(String Middle){
        Middle = "ASF";
        MiddleClick.setText(Middle);

    }

}
