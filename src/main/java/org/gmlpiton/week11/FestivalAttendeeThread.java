package org.gmlpiton.week11;

public class FestivalAttendeeThread extends Thread
{

    TicketType ticketType;
    FestivalGate festivalGate;

    FestivalAttendeeThread(TicketType ticketType,FestivalGate gate ) throws InterruptedException {
        this.ticketType = ticketType;
        this.festivalGate = gate;
        System.out.println("Attendee with ticket type "+ ticketType + " goes to gate "+ gate);
        Thread.sleep(GenerateRandomInt.get(100));

    }

    public boolean validate()
    {
        System.out.println("Validating ticket");
        festivalGate.addUser(ticketType);
        return true;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() + " Running in "+ this.getClass().getName());
    }
}
