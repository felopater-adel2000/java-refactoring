package com.refactoring.java.split_phase_refactoring.finish;

import com.refactoring.java.split_phase_refactoring.Invoice;
import com.refactoring.java.split_phase_refactoring.Performance;

import java.text.NumberFormat;
import java.util.Locale;

public class TheatricalPlayers {

    public String print(Invoice invoice) {
        var totalAmount = 0;
        var volumeCredits = 0;



        for (var perf : invoice.performances) {
            var play = perf.play;
            var amount = calculateAmount(perf);
            totalAmount += amount;


            var credits = Math.max(perf.audience - 30, 0);
            if ("comedy".equals(play.type)) credits += Math.floor((double) perf.audience / 5);
            volumeCredits += credits;
        }

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        var result = String.format("Statement for %s\n", invoice.customer);
        result += String.format("Amount owed is %s\n", format.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }

    private static int calculateAmount(Performance perf) {
        var amount = 40000;
        if (perf.audience > 30) {
            amount += 1000 * (perf.audience - 30);
        }
        return amount;
    }

}
