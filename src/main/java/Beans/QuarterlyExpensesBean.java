package Beans;

import java.io.Serializable;

public class QuarterlyExpensesBean implements Serializable {
    private Double rawMaterialsConsumption;
    private Double purchaseOfTradedGoods;
    private Double stockChange;
    private Double powerAndFuel;
    private Double employeeCost;
    private Double depreciation;
    private Double rAndD;
    private Double otherExpenses;

    public QuarterlyExpensesBean(Double rawMaterialsConsumption, Double purchaseOfTradedGoods, Double stockChange, Double powerAndFuel, Double employeeCost, Double depreciation, Double rAndD, Double otherExpenses) {
        this.rawMaterialsConsumption = rawMaterialsConsumption;
        this.purchaseOfTradedGoods = purchaseOfTradedGoods;
        this.stockChange = stockChange;
        this.powerAndFuel = powerAndFuel;
        this.employeeCost = employeeCost;
        this.depreciation = depreciation;
        this.rAndD = rAndD;
        this.otherExpenses = otherExpenses;
    }

    public Double getRawMaterialsConsumption() {
        return rawMaterialsConsumption;
    }

    public Double getPurchaseOfTradedGoods() {
        return purchaseOfTradedGoods;
    }

    public Double getStockChange() {
        return stockChange;
    }

    public Double getPowerAndFuel() {
        return powerAndFuel;
    }

    public Double getEmployeeCost() {
        return employeeCost;
    }

    public Double getDepreciation() {
        return depreciation;
    }

    public Double getrAndD() {
        return rAndD;
    }

    public Double getOtherExpenses() {
        return otherExpenses;
    }

    @Override
    public String toString() {
        return "rawMaterialsConsumption=" + rawMaterialsConsumption +
                ", purchaseOfTradedGoods=" + purchaseOfTradedGoods +
                ", stockChange=" + stockChange +
                ", powerAndFuel=" + powerAndFuel +
                ", employeeCost=" + employeeCost +
                ", depreciation=" + depreciation +
                ", rAndD=" + rAndD +
                ", otherExpenses=" + otherExpenses;
    }
}
