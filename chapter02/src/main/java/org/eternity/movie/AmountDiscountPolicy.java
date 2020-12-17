package org.eternity.movie;

public class AmountDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAnoubt, DiscountCondition ... conditions){
        super(conditions);
        this.discountAmount = discountAmount;
    }

    public Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
    
}
