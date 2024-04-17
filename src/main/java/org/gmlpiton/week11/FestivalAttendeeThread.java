package org.gmlpiton.week11;

public class FestivalAttendeeThread implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() + " Running in "+ this.getClass().getName());
    }
}
