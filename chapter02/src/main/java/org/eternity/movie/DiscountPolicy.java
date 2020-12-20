package org.eternity.movie;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
