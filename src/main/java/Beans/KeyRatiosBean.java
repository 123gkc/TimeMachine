package Beans;

import java.io.Serializable;
import java.util.Date;

public class KeyRatiosBean implements Serializable {
    private Date date;
    private PerShareRatiosBean perShareRatiosBean;
    private ProfitabilityRatiosBean profitabilityRatiosBean;
    private LiquidityRatiosBean liquidityRatiosBean;
    private ValuationRatiosBean valuationRatiosBean;

    public KeyRatiosBean(Date date, PerShareRatiosBean perShareRatiosBean, ProfitabilityRatiosBean profitabilityRatiosBean, LiquidityRatiosBean liquidityRatiosBean, ValuationRatiosBean valuationRatiosBean) {
        this.date = date;
        this.perShareRatiosBean = perShareRatiosBean;
        this.profitabilityRatiosBean = profitabilityRatiosBean;
        this.liquidityRatiosBean = liquidityRatiosBean;
        this.valuationRatiosBean = valuationRatiosBean;
    }

    public Date getDate() {
        return date;
    }

    public PerShareRatiosBean getPerShareRatiosBean() {
        return perShareRatiosBean;
    }

    public ProfitabilityRatiosBean getProfitabilityRatiosBean() {
        return profitabilityRatiosBean;
    }

    public LiquidityRatiosBean getLiquidityRatiosBean() {
        return liquidityRatiosBean;
    }

    public ValuationRatiosBean getValuationRatiosBean() {
        return valuationRatiosBean;
    }

    @Override
    public String toString() {
        return "Date=" + date +
                ", perShareRatiosBean=" + perShareRatiosBean +
                ", profitabilityRatiosBean=" + profitabilityRatiosBean +
                ", liquidityRatiosBean=" + liquidityRatiosBean +
                ", valuationRatiosBean=" + valuationRatiosBean;
    }
}
