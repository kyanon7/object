package org.eternity.theater;

public class ReservationAgency {
    
    // public Reservation reserve(Screening screening, Customer customer, int audienceCount){
    //     Movie movie = screening.getMovie();

    //     boolean discountable = false;
    //     for(DiscountCondition condition : movie.getDiscountConditions()){
    //         if(condition.getType() == DiscountConditionType.PERIOD){
    //             discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) && 
    //             condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 && 
    //             condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    //         }else{
    //             discountable = condition.getSequence() == screening.getSequence();
    //         }

    //         if(discountable){
    //             break;
    //         }
    //     }

    //     Money fee;
    //     if(discountable){
    //         Money discountAmount = Money.ZERO;
    //         switch(movie.getMovieType()){
    //             case AMOUNT_DISCOUNT:
    //             discountAmount = movie.getDiscountAmount();
    //             break;
    //             case PERCENT_DISCOUNT:
    //             discountAmount = movie.getFee().times(movie.getDiscountPercent());
    //             break;
    //             case NONE_DISCOUNT:
    //             discountAmount = Money.ZERO;
    //             break;
    //         }

    //         fee = movie.getFee().minus(discountAmount).times(audienceCount);
    //     }else{
    //         fee = movie.getFee();
    //     }

    //     Money fee = screening.calculateFee(audienceCount);
    //     return new Reservation(customer, screening, fee, audienceCount);
    // }

    public Reservation reserve(Screening screening, Customer customer, int audienceCount){

        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        return createReservation(screening, customer, audienceCount, fee);
    }

    private boolean checkDiscountable(Screening screening){
        return screening.getMovie().getDiscountConditions().stream().anyMatch(condition -> condition.isDiscountable(screening));
    }

    // private boolean isDiscountable(DiscountCondition condition, Screening screening){
    //     if(condition.getType() == DiscountConditionType.PERIOD){
    //         return isSatisfiedByPeriod(condition, screening);
    //     }

    //     return isSatisfiedBySequence(condition, screening);
    // }

    // private boolean isSatisfiedByPeriod(DiscountCondition condition, Screening screening){
    //     return screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) && 
    //     condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 && 
    //     condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    // }

    // private boolean isSatisfiedBySequence(DiscountCondition condition, Screening screening){
    //     return condition.getSequence() == screening.getSequence();
    // }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount){
        if(discountable){
            return screening.getMovie().getFee().minus(calculateDiscountedFee(screening.getMovie())).times(audienceCount);
        }

        return screening.getMovie().getFee();
    }
       
    private Money calculateDiscountedFee(Movie movie){
        switch(movie.getMovieType()){
            case AMOUNT_DISCOUNT:
            return calculateAmountDiscountedFee(movie);
            case PERCENT_DISCOUNT:
            return calculatePercentDiscountedFee(movie);
            case NONE_DISCOUNT:
            return calculateNoneDiscountedFee(movie);
        }

        throw new IllegalArgumentException();
    }

    private Money calculateAmountDiscountedFee(Movie movie){
        return movie.getDiscountAmount();
    }

    private Money calculatePercentDiscountedFee(Movie movie){
        return movie.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateNoneDiscountedFee(Movie movie){
        return movie.getFee();
    }

    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee){
        return new Reservation(customer, screening, fee, audienceCount);
    }
}