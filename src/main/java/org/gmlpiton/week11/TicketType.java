package org.gmlpiton.week11;

import org.gmlpiton.week8.io.domain.Place;

public enum TicketType {
    TT1("full", 1, "full"),
    TT2("free", 2, "free"),
    TT3("full-vip", 3, "full VIP"),
    TT4("one-day", 4, "one-day"),
    TT5("one-day-vip", 5, " one-day VIP");

    //full, full-vip, free-pass, one-day, one-day-vip

    final String ticketType;
    final int id;
    final String shownTicketType;

    TicketType(final String ticketType, final int id, final String shownTicketType)
    {
        this.ticketType = ticketType;
        this.id = id;
        this.shownTicketType = shownTicketType;


    }

    public String getTicketType() {
        return ticketType;
    }

    public int getId() {
        return id;
    }

    public static TicketType getForValue(int pid){
        for (TicketType tt: TicketType.values()){
            if(tt.getId() == pid){
                return tt;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "ticketType='" + ticketType + '\'' +
                ", id=" + id +
                ", shownTicketType='" + shownTicketType + '\'' +
                '}';
    }
}
