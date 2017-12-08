package Beans;

import java.io.Serializable;
import java.util.Date;

public class CashFlowSheetBean extends FinancialsReportBean implements Serializable {
    private Double PAndLBeforeTax;
    private Double cashFromOperating;
    private Double cashUsedInInvesting;
    private Double cashUsedFromFinancing;
    private Double cashAtYearEnd;

    public CashFlowSheetBean(Date date, Double PAndLBeforeTax, Double cashFromOperating, Double cashUsedInInvesting, Double cashUsedFromFinancing, Double cashAtYearEnd) {
        this.date = date;
        this.PAndLBeforeTax = PAndLBeforeTax;
        this.cashFromOperating = cashFromOperating;
        this.cashUsedInInvesting = cashUsedInInvesting;
        this.cashUsedFromFinancing = cashUsedFromFinancing;
        this.cashAtYearEnd = cashAtYearEnd;
    }

    public Double getPAndLBeforeTax() {
        return PAndLBeforeTax;
    }

    public Double getCashFromOperating() {
        return cashFromOperating;
    }

    public Double getCashUsedInInvesting() {
        return cashUsedInInvesting;
    }

    public Double getCashUsedFromFinancing() {
        return cashUsedFromFinancing;
    }

    public Double getCashAtYearEnd() {
        return cashAtYearEnd;
    }

    @Override
    public String toString() {
        return "Date=" + date +
                ", PAndLBeforeTax=" + PAndLBeforeTax +
                ", cashFromOperating=" + cashFromOperating +
                ", cashUsedInInvesting=" + cashUsedInInvesting +
                ", cashUsedFromFinancing=" + cashUsedFromFinancing +
                ", cashAtYearEnd=" + cashAtYearEnd;
    }
}
