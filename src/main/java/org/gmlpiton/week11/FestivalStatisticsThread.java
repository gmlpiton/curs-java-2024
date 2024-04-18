package org.gmlpiton.week11;

import java.util.ConcurrentModificationException;
import java.util.HashMap;

public class FestivalStatisticsThread extends Thread {
    private int total;
    private int iteration;
    private HashMap<TicketType, Integer> stats = new HashMap<>();
    private FestivalGate fg;

    FestivalStatisticsThread(FestivalGate fg) {
        this.total = 0;
        this.iteration = 0;
        this.fg = fg;
    }

    public void beautifyStats() {

        System.out.println(total + " people entered");
        System.out.println(stats.getOrDefault(TicketType.TT1, 0) + " have full tickets");
        System.out.println(stats.getOrDefault(TicketType.TT2, 0) + " have free passes");
        System.out.println(stats.getOrDefault(TicketType.TT3, 0) + " have full VIP passes");
        System.out.println(stats.getOrDefault(TicketType.TT4, 0) + " have one-day passes");
        System.out.println(stats.getOrDefault(TicketType.TT5, 0) + " have one-day VIP passes");


    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Running in a loop " + this.getClass().getName());
        while (true) {
            try {
                this.iteration++;
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " Running in a loop " +
                        this.getClass().getName() + " iteration " + this.iteration);

                    for (TicketType tt : fg.getQueue()) {
                        int count = stats.getOrDefault(tt, 0);
                        stats.put(tt, count + 1);
                    }

                    total += fg.getQueueNo();

                    beautifyStats();
                    fg.emptyQueue();



            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int getTotal() {
        return this.total;
    }
}
