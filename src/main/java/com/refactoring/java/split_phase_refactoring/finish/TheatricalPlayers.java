package com.refactoring.java.split_phase_refactoring.finish;

import java.text.NumberFormat;
import java.util.Locale;

public class TheatricalPlayers {

    public String print(Invoice invoice) {
        InvoiceData data = getInvoiceData(invoice);

        return presentInvoiceData(data);
    }

    private String presentInvoiceData(InvoiceData data) {
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
            totalAmount += perf.calculateAmount();

            volumeCredits += calculateCredits(perf);
        }

        return new InvoiceData(totalAmount, volumeCredits, invoice.customer);
    }

    private int calculateCredits(Performance perf) {
        var play = perf.play;
        var credits = Math.max(perf.audience - 30, 0);
        if ("comedy".equals(play.type)) credits += Math.floor((double) perf.audience / 5);
        return credits;
    }

}
