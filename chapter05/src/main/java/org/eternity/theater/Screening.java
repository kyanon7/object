package org.eternity.theater;

import java.time.LocalDateTime;

public class Screening{

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    // public Reservation reserve(Customer customer, int audience){
    // }

    // public Money calculateFee(int audience){
    //     return movie.calculateMovieFee(this).times(audience);
    // }

    public Movie getMovie() {
        return movie;
    }

}