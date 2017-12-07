package Beans;

import java.io.Serializable;

public class TaxesAndExceptionsBean implements Serializable {
    private Double exceptionalItems;
    private Double taxExpenses;

    public TaxesAndExceptionsBean(Double exceptionalItems, Double taxExpenses) {
        this.exceptionalItems = exceptionalItems;
        this.taxExpenses = taxExpenses;
    }

    public Double getExceptionalItems() {
        return exceptionalItems;
    }

    public Double getTaxExpenses() {
        return taxExpenses;
    }

    @Override
    public String toString() {
        return "exceptionalItems=" + exceptionalItems +
                ", taxExpenses=" + taxExpenses;
    }
}
