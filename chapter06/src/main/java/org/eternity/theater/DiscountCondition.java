package org.eternity.theater;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);

	boolean isDiscountable(Screening screening);
}
