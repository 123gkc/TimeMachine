package Beans;

import java.io.Serializable;

public class ProfitabilityRatiosBean implements Serializable {
    private Double PBDITMargin;
    private Double PBITMargin;
    private Double PBTMargin;
    private Double netProfitMargin;
    private Double returnOnNetWorth;
    private Double returnOnCapitalEmployed;
    private Double returnOnAssets;
    private Double debtToEquity;
    private Double assetTurnoverRatio;

    public ProfitabilityRatiosBean(Double PBDITMargin, Double PBITMargin, Double PBTMargin, Double netProfitMargin, Double returnOnNetWorth, Double returnOnCapitalEmployed, Double returnOnAssets, Double debtToEquity, Double assetTurnoverRatio) {
        this.PBDITMargin = PBDITMargin;
        this.PBITMargin = PBITMargin;
        this.PBTMargin = PBTMargin;
        this.netProfitMargin = netProfitMargin;
        this.returnOnNetWorth = returnOnNetWorth;
        this.returnOnCapitalEmployed = returnOnCapitalEmployed;
        this.returnOnAssets = returnOnAssets;
        this.debtToEquity = debtToEquity;
        this.assetTurnoverRatio = assetTurnoverRatio;
    }

    public Double getPBDITMargin() {
        return PBDITMargin;
    }

    public Double getPBITMargin() {
        return PBITMargin;
    }

    public Double getPBTMargin() {
        return PBTMargin;
    }

    public Double getNetProfitMargin() {
        return netProfitMargin;
    }

    public Double getReturnOnNetWorth() {
        return returnOnNetWorth;
    }

    public Double getReturnOnCapitalEmployed() {
        return returnOnCapitalEmployed;
    }

    public Double getReturnOnAssets() {
        return returnOnAssets;
    }

    public Double getDebtToEquity() {
        return debtToEquity;
    }

    public Double getAssetTurnoverRatio() {
        return assetTurnoverRatio;
    }

    @Override
    public String toString() {
        return "PBDITMargin=" + PBDITMargin +
                ", PBITMargin=" + PBITMargin +
                ", PBTMargin=" + PBTMargin +
                ", netProfitMargin=" + netProfitMargin +
                ", returnOnNetWorth=" + returnOnNetWorth +
                ", returnOnCapitalEmployed=" + returnOnCapitalEmployed +
                ", returnOnAssets=" + returnOnAssets +
                ", debtToEquity=" + debtToEquity +
                ", assetTurnoverRatio=" + assetTurnoverRatio;
    }
}
