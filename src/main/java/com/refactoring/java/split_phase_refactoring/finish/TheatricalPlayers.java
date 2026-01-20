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

            volumeCredits += perf.calculateCredits();
        }

        return new InvoiceData(totalAmount, volumeCredits, invoice.customer);
    }

}
