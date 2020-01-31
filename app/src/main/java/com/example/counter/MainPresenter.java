package com.example.counter;

import android.widget.TextView;

public class MainPresenter implements MainContract.Presenter {
    String rValue;
    String wsaf;
    private MainContract.View mView;
    private MainModel mModel;
    public MainPresenter(MainActivity mView) { //объекты
        this.mView = (MainContract.View) mView;
        this.mModel = new MainModel();

    }

    @Override
    public void onButtomClickMinus(TextView Value, String Ha) { //кнопка увеличения
        String Temp2 = Value.getText().toString(); //получаем значение счетчика
        rValue=mModel.getCalculation("-", Temp2); //отправляем в расчет с соответ знаком
        mView.showCounter(rValue);

        wsaf = mModel.getMiddleClick(rValue,Ha);
        mView.showMiddleClick(wsaf);
    }

    @Override
    public void onButtomClickPlus(TextView Value,String Ha) {

        String Temp2 = Value.getText().toString();
        rValue=mModel.getCalculation("+", Temp2); //аналогично
        mView.showCounter(rValue);
        String wsa = mView.runTimer();
        wsaf = mModel.getMiddleClick(rValue,Ha);
        mView.showMiddleClick(wsaf);

    }

    public void onButtomClickDischarge(){
        rValue = mModel.setNull();
        mView.showCounter(rValue);
        mView.stopTimer();

    }
    public void Destroy(){}



}
