package Beans;

import java.io.Serializable;

public class PledgedSharesBean implements Serializable {
    private Double pledgedPercentageOfPromoterTotal;
    private Double pledgedPercentageOfCompanyShareCap;

    public PledgedSharesBean(Double pledgedPercentageOfPromoterTotal, Double percentOfPledgedShares) {
        this.pledgedPercentageOfPromoterTotal = pledgedPercentageOfPromoterTotal;
        this.pledgedPercentageOfCompanyShareCap = percentOfPledgedShares;
    }

    public Double getPledgedPercentageOfPromoterTotal() {
        return pledgedPercentageOfPromoterTotal;
    }

    public Double getPledgedPercentageOfCompanyShareCap() {
        return pledgedPercentageOfCompanyShareCap;
    }

    @Override
    public String toString() {
        return "pledgedPercentageOfPromoterTotal=" + pledgedPercentageOfPromoterTotal +
                ", pledgedPercentageOfCompanyShareCap=" + pledgedPercentageOfCompanyShareCap;
    }
}
