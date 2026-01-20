package com.refactoring.java.split_phase_refactoring.finish;

import java.text.NumberFormat;
import java.util.Locale;

public class TheatricalPlayers {

    public String print(Invoice invoice) {
        InvoiceData data = getInvoiceData(invoice);

        return presentInvoiceData(data);
    }

    private static String presentInvoiceData(InvoiceData data) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        var result = String.format("Statement for %s\n", data.getCustomerName());
        result += String.format("Amount owed is %s\n", format.format(data.getTotalAmount() / 100));
        result += String.format("You earned %s credits\n", data.getVolumeCredits());
        return result;
    }

    private InvoiceData getInvoiceData(Invoice invoice) {
        var totalAmount = 0;
        var volumeCredits = 0;

        for (var perf : invoice.performances) {
            totalAmount += calculateAmount(perf);

            volumeCredits += calculateCredits(perf, perf.play);
        }

        return new InvoiceData(totalAmount, volumeCredits, invoice.customer);
    }

    private static int calculateCredits(Performance perf, Play play) {
        var credits = Math.max(perf.audience - 30, 0);
        if ("comedy".equals(play.type)) credits += Math.floor((double) perf.audience / 5);
        return credits;
    }

    private static int calculateAmount(Performance perf) {
        var amount = 40000;
        if (perf.audience > 30) {
            amount += 1000 * (perf.audience - 30);
        }
        return amount;
    }

}
