package com.example.myapplication.Practice;

public class Countries {
    String state;
    String currency;
    String time;
    public Countries(String state,String currency,String time)
    {
        this.currency=currency;
        this.state=state;
        this.time=time;
    }

    public String getCurrency() {
        return currency;
    }

    public String getState() {
        return state;
    }

    public String getTime() {
        return time;
    }
}
