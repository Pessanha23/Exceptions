package interfacedefaultmethod.application.entities;

import java.time.LocalDate;

public class Program {
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Program(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }


    public LocalDate getCheckOut() {
        return checkOut;
    }

}
