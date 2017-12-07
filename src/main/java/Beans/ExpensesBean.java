package Beans;

import java.io.Serializable;

public class ExpensesBean implements Serializable {
    private Double costOfMaterialsConsumed;
    private Double employeeBenefitExpenses;
    private Double financeCosts;
    private Double depreciationAndAmortisation;
    private Double otherExpenses;
    private Double totalExpenses;

    public ExpensesBean(Double costOfMaterialsConsumed, Double employeeBenefitExpenses, Double financeCosts, Double depreciationAndAmortisation, Double otherExpenses, Double totalExpenses) {
        this.costOfMaterialsConsumed = costOfMaterialsConsumed;
        this.employeeBenefitExpenses = employeeBenefitExpenses;
        this.financeCosts = financeCosts;
        this.depreciationAndAmortisation = depreciationAndAmortisation;
        this.otherExpenses = otherExpenses;
        this.totalExpenses = totalExpenses;
    }

    public Double getCostOfMaterialsConsumed() {
        return costOfMaterialsConsumed;
    }

    public Double getEmployeeBenefitExpenses() {
        return employeeBenefitExpenses;
    }

    public Double getFinanceCosts() {
        return financeCosts;
    }

    public Double getDepreciationAndAmortisation() {
        return depreciationAndAmortisation;
    }

    public Double getOtherExpenses() {
        return otherExpenses;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    @Override
    public String toString() {
        return "costOfMaterialsConsumed=" + costOfMaterialsConsumed +
                ", employeeBenefitExpenses=" + employeeBenefitExpenses +
                ", financeCosts=" + financeCosts +
                ", depreciationAndAmortisation=" + depreciationAndAmortisation +
                ", otherExpenses=" + otherExpenses +
                ", totalExpenses=" + totalExpenses;
    }
}
