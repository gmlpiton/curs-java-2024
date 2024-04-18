package org.gmlpiton.week11;

import java.util.ArrayList;
import java.util.List;

public class FestivalGate extends Thread {
    private int queueNo;
    private boolean empty;

    private List<TicketType> queue =new ArrayList<>();

    FestivalGate() {
        queueNo = 0;
        empty = true;
    }

    public int getQueueNo() {
        return queueNo;
    }

    public void setQueueNo(int queueNo) {
        this.queueNo = queueNo;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public List<TicketType> getQueue() {
        return queue;
    }

    public void setQueue(List<TicketType> queue) {
        this.queue = queue;
    }

    public void addUser(TicketType tt)
    {
        this.queue.add(tt);
        this.queueNo ++;
        System.out.println("There are now "+ queueNo + " users awaiting stats Thread");
    }

    public void emptyQueue()
    {
        this.queueNo = 0;
        this.queue.clear();
        System.out.println("Emptied gate queue");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Running in " + this.getClass().getName());
    }
}
