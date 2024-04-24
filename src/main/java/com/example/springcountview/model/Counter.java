package com.example.springcountview.model;

public class Counter {
    private  static int count=0;

    public Counter() {
    }

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void increment(){
        count++;
    }
}