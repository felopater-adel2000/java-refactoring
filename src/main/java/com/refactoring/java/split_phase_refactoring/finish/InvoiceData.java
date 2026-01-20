package com.refactoring.java.split_phase_refactoring.finish;

public class InvoiceData {
    private int totalAmount = 0;
    private int volumeCredits = 0;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private String customerName = "";

    public InvoiceData(int totalAmount, int volumeCredits, String customerName) {
        this.totalAmount = totalAmount;
        this.volumeCredits = volumeCredits;
        this.customerName = customerName;
    }

    public int getVolumeCredits() {
        return volumeCredits;
    }

    public void setVolumeCredits(int volumeCredits) {
        this.volumeCredits = volumeCredits;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
