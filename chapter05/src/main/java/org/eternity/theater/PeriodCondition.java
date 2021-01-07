package org.eternity.theater;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class PeriodCondition {
    private DayOfWeek dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalDateTime startTime, LocalDateTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // public boolean isSatisfiedBy(Screening screening){
    //     return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
    //             startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
    //             endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    // }
}