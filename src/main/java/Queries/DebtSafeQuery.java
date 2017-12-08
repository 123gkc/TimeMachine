package Queries;

import Beans.CompanyBean;

import java.util.Date;

public class DebtSafeQuery extends Query {
    private Double debtEquityRatioBar;
    private Double debtToEquityReductionDegree;

    public DebtSafeQuery(Date queryDate, Double debtEquityRatioBar, Double debtToEquityReductionDegree) {
        this.queryDate = queryDate;
        this.debtEquityRatioBar = debtEquityRatioBar;
        this.debtToEquityReductionDegree = debtToEquityReductionDegree;
    }

    public DebtSafeQuery(Double debtEquityRatioBar, Double debtToEquityReductionDegree) {
        this.debtEquityRatioBar = debtEquityRatioBar;
        this.debtToEquityReductionDegree = debtToEquityReductionDegree;
    }

    public Double getDebtEquityRatioBar() {
        return debtEquityRatioBar;
    }

    public Double getDebtToEquityReductionDegree() {
        return debtToEquityReductionDegree;
    }

    public void run() {

    }
}
