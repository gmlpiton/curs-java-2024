package org.gmlpiton.week11;

public class Main {

    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        System.out.println("Now I'm in thread "+ Main.class.getName());
        gate.start();
    }
}
