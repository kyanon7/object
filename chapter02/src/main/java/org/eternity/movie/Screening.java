package org.eternity.movie;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened){
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getSrartTime(){
        return whenScreened;
    }
    
    public boolean isSequence(int sequence){
        return this.sequence == sequence;
    }

    public Money getMoviwFee(){
        return movie.getFee();
    }
}
