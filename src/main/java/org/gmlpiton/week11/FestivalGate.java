package org.gmlpiton.week11;

public class FestivalGate extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Running in "+ this.getClass().getName());
    }
}
