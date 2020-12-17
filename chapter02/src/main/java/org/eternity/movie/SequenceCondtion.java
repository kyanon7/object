package org.eternity.movie;

public class SequenceCondtion implements DiscountCondition {
    private int sequence;

    public SequenceCondtion(int sequnce){
        this.sequence = sequnce;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}