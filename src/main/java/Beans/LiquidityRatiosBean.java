package Beans;

import java.io.Serializable;

public class LiquidityRatiosBean implements Serializable {
    private Double currentRatio;
    private Double quickRatio;
    private Double inventoryTurnoverRatio;
    private Double dividendPayoutRatioNP;
    private Double dividendPayoutRatioCP;
    private Double earningsRetentionRatio;
    private Double cashEarningsRetentionRatio;

    public LiquidityRatiosBean(Double currentRatio, Double quickRatio, Double inventoryTurnoverRatio, Double dividendPayoutRatioNP, Double dividendPayoutRatioCP, Double earningsRetentionRatio, Double cashEarningsRetentionRatio) {
        this.currentRatio = currentRatio;
        this.quickRatio = quickRatio;
        this.inventoryTurnoverRatio = inventoryTurnoverRatio;
        this.dividendPayoutRatioNP = dividendPayoutRatioNP;
        this.dividendPayoutRatioCP = dividendPayoutRatioCP;
        this.earningsRetentionRatio = earningsRetentionRatio;
        this.cashEarningsRetentionRatio = cashEarningsRetentionRatio;
    }

    public Double getCurrentRatio() {
        return currentRatio;
    }

    public Double getQuickRatio() {
        return quickRatio;
    }

    public Double getInventoryTurnoverRatio() {
        return inventoryTurnoverRatio;
    }

    public Double getDividendPayoutRatioNP() {
        return dividendPayoutRatioNP;
    }

    public Double getDividendPayoutRatioCP() {
        return dividendPayoutRatioCP;
    }

    public Double getEarningsRetentionRatio() {
        return earningsRetentionRatio;
    }

    public Double getCashEarningsRetentionRatio() {
        return cashEarningsRetentionRatio;
    }

    @Override
    public String toString() {
        return "currentRatio=" + currentRatio +
                ", quickRatio=" + quickRatio +
                ", inventoryTurnoverRatio=" + inventoryTurnoverRatio +
                ", dividendPayoutRatioNP=" + dividendPayoutRatioNP +
                ", dividendPayoutRatioCP=" + dividendPayoutRatioCP +
                ", earningsRetentionRatio=" + earningsRetentionRatio +
                ", cashEarningsRetentionRatio=" + cashEarningsRetentionRatio;
    }
}
