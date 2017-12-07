package Queries;

import Beans.CompanyBean;

import java.util.Date;
import java.util.List;

public class DebtSafeQuery {
    private List<CompanyBean> companyBeanList;
    private Date queryDate;
    private Double debtEquityRatioBar;
    private Double debtToEquityReductionDegree;

    public DebtSafeQuery(Date queryDate, Double debtEquityRatioBar, Double debtToEquityReductionDegree) {
        this.queryDate = queryDate;
        this.debtEquityRatioBar = debtEquityRatioBar;
        this.debtToEquityReductionDegree = debtToEquityReductionDegree;


    }
}
