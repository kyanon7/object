package org.eternity.movie;

public class AmountDiscountPolicy extends DefaultDiscountPolicy{
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ... conditions){
        super(conditions);
        this.discountAmount = discountAmount;
    }

    public Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
    
}
