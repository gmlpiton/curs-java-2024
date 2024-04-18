package org.gmlpiton.week11;


public class Main {

    final static int ATTENDEE_THREADS = 10000;

    public static void main(String[] args) throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        statsThread.start();
        System.out.println("Now I'm in thread " + Main.class.getName());
        gate.start();

        for (int i = 0; i < ATTENDEE_THREADS; i++) {

            TicketType ticketType = GenerateRandomInt.getTT(5);

            FestivalAttendeeThread attendee = null;
            try {
                attendee = new FestivalAttendeeThread(ticketType, gate);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            attendee.start();
            attendee.validate();


        }


    }
}
