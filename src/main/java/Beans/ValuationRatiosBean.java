package Beans;

import java.io.Serializable;

public class ValuationRatiosBean implements Serializable {
    private Double enterpriseValue;
    private Double EVPerOperatingRevenue;
    private Double EVPerEBITDA;
    private Double marketCapPerNetOperatingRevenue;
    private Double retentionRatio;
    private Double pricePerBV;
    private Double pricePerOperatingRevenue;
    private Double earningsYield;

    public ValuationRatiosBean(Double enterpriseValue, Double EVPerOperatingRevenue, Double EVPerEBITDA, Double marketCapPerNetOperatingRevenue, Double retentionRatio, Double pricePerBV, Double pricePerOperatingRevenue, Double earningsYield) {
        this.enterpriseValue = enterpriseValue;
        this.EVPerOperatingRevenue = EVPerOperatingRevenue;
        this.EVPerEBITDA = EVPerEBITDA;
        this.marketCapPerNetOperatingRevenue = marketCapPerNetOperatingRevenue;
        this.retentionRatio = retentionRatio;
        this.pricePerBV = pricePerBV;
        this.pricePerOperatingRevenue = pricePerOperatingRevenue;
        this.earningsYield = earningsYield;
    }

    public Double getEnterpriseValue() {
        return enterpriseValue;
    }

    public Double getEVPerOperatingRevenue() {
        return EVPerOperatingRevenue;
    }

    public Double getEVPerEBITDA() {
        return EVPerEBITDA;
    }

    public Double getMarketCapPerNetOperatingRevenue() {
        return marketCapPerNetOperatingRevenue;
    }

    public Double getRetentionRatio() {
        return retentionRatio;
    }

    public Double getPricePerBV() {
        return pricePerBV;
    }

    public Double getPricePerOperatingRevenue() {
        return pricePerOperatingRevenue;
    }

    public Double getEarningsYield() {
        return earningsYield;
    }

    @Override
    public String toString() {
        return "enterpriseValue=" + enterpriseValue +
                ", EVPerOperatingRevenue=" + EVPerOperatingRevenue +
                ", EVPerEBITDA=" + EVPerEBITDA +
                ", marketCapPerNetOperatingRevenue=" + marketCapPerNetOperatingRevenue +
                ", retentionRatio=" + retentionRatio +
                ", pricePerBV=" + pricePerBV +
                ", pricePerOperatingRevenue=" + pricePerOperatingRevenue +
                ", earningsYield=" + earningsYield;
    }
}
