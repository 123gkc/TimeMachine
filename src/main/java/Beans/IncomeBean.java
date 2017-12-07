package Beans;

import java.io.Serializable;

public class IncomeBean implements Serializable {
    private Double operatingRevenues;
    private Double otherIncome;

    public IncomeBean(Double operatingRevenues, Double otherIncome) {
        this.operatingRevenues = operatingRevenues;
        this.otherIncome = otherIncome;
    }

    public Double getOperatingRevenues() {
        return operatingRevenues;
    }

    public Double getOtherIncome() {
        return otherIncome;
    }

    @Override
    public String toString() {
        return "operatingRevenues="+operatingRevenues+", otherIncome="+otherIncome;
    }
}
