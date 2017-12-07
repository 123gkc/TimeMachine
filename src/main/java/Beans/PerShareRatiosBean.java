package Beans;

import java.io.Serializable;

public class PerShareRatiosBean implements Serializable {
    private Double basicEPS;
    private Double dilutedEPS;
    private Double cashEPS;
    private Double bookValuePerShare;
    private Double dividendPerShare;
    private Double revenuePerShare;
    private Double pBDITPerShare;
    private Double pBITPerShare;
    private Double pBTPerShare;
    private Double netProfitPerShare;

    public PerShareRatiosBean(Double basicEPS, Double dilutedEPS, Double cashEPS, Double bookValuePerShare, Double dividendPerShare, Double revenuePerShare, Double pBDITPerShare, Double pBITPerShare, Double pBTPerShare, Double netProfitPerShare) {
        this.basicEPS = basicEPS;
        this.dilutedEPS = dilutedEPS;
        this.cashEPS = cashEPS;
        this.bookValuePerShare = bookValuePerShare;
        this.dividendPerShare = dividendPerShare;
        this.revenuePerShare = revenuePerShare;
        this.pBDITPerShare = pBDITPerShare;
        this.pBITPerShare = pBITPerShare;
        this.pBTPerShare = pBTPerShare;
        this.netProfitPerShare = netProfitPerShare;
    }

    public Double getBasicEPS() {
        return basicEPS;
    }

    public Double getDilutedEPS() {
        return dilutedEPS;
    }

    public Double getCashEPS() {
        return cashEPS;
    }

    public Double getBookValuePerShare() {
        return bookValuePerShare;
    }

    public Double getDividendPerShare() {
        return dividendPerShare;
    }

    public Double getRevenuePerShare() {
        return revenuePerShare;
    }

    public Double getpBDITPerShare() {
        return pBDITPerShare;
    }

    public Double getpBITPerShare() {
        return pBITPerShare;
    }

    public Double getpBTPerShare() {
        return pBTPerShare;
    }

    public Double getNetProfitPerShare() {
        return netProfitPerShare;
    }

    @Override
    public String toString() {
        return "basicEPS=" + basicEPS +
                ", dilutedEPS=" + dilutedEPS +
                ", cashEPS=" + cashEPS +
                ", bookValuePerShare=" + bookValuePerShare +
                ", dividendPerShare=" + dividendPerShare +
                ", revenuePerShare=" + revenuePerShare +
                ", pBDITPerShare=" + pBDITPerShare +
                ", pBITPerShare=" + pBITPerShare +
                ", pBTPerShare=" + pBTPerShare +
                ", netProfitPerShare=" + netProfitPerShare;
    }
}
