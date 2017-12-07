package Beans;

import java.io.Serializable;

public class PAndLOthersBean implements Serializable {
    private Double pAndL;
    private Double basicEPS;
    private Double dilutedEPS;
    private Double equityShareDividend;
    private Double equityDividendRate;

    public PAndLOthersBean(Double pAndL, Double basicEPS, Double dilutedEPS, Double equityShareDividend, Double equityDividendRate) {
        this.pAndL = pAndL;
        this.basicEPS = basicEPS;
        this.dilutedEPS = dilutedEPS;
        this.equityShareDividend = equityShareDividend;
        this.equityDividendRate = equityDividendRate;
    }

    public Double getpAndL() {
        return pAndL;
    }

    public Double getBasicEPS() {
        return basicEPS;
    }

    public Double getDilutedEPS() {
        return dilutedEPS;
    }

    public Double getEquityShareDividend() {
        return equityShareDividend;
    }

    public Double getEquityDividendRate() {
        return equityDividendRate;
    }

    @Override
    public String toString() {
        return "pAndL=" + pAndL +
                ", basicEPS=" + basicEPS +
                ", dilutedEPS=" + dilutedEPS +
                ", equityShareDividend=" + equityShareDividend +
                ", equityDividendRate=" + equityDividendRate;
    }
}
