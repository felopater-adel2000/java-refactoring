package com.refactoring.java.split_phase_refactoring.finish;

public class Performance {

    public Play play;
    public int audience;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }

    int calculateAmount() {
        var amount = 40000;
        if (audience > 30) {
            amount += 1000 * (audience - 30);
        }
        return amount;
    }

    int calculateCredits() {
        var play = this.play;
        var credits = Math.max(audience - 30, 0);
        if ("comedy".equals(play.type)) credits += Math.floor((double) audience / 5);
        return credits;
    }
}
