package org.eternity.theater;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money calculateMovieFee(Screening screening, DiscountCondition condition){
        if(condition.isDiscountable(screening)){
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    // private boolean isDiscountable(Screening screening){
    //     return discountConditions.stream()
    //             .anyMatch(condition -> condition.isSatisfiedBy(screening));
    // }

    abstract protected Money calculateDiscountAmount();

    protected Money getFee() {
        return fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

}