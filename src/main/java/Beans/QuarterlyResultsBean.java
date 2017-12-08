package Beans;

import java.io.Serializable;
import java.util.Date;

public class QuarterlyResultsBean extends FinancialsReportBean implements Serializable {
    private IncomeBean incomeBean;
    private QuarterlyExpensesBean quarterlyExpensesBean;
    private TaxesAndExceptionsBean taxesAndExceptionsBean;
    private PAndLOthersBean pAndLOthersBean;
    private PledgedSharesBean pledgedSharesBean;

    public QuarterlyResultsBean(Date date, IncomeBean incomeBean, QuarterlyExpensesBean quarterlyExpensesBean, TaxesAndExceptionsBean taxesAndExceptionsBean, PAndLOthersBean pAndLOthersBean, PledgedSharesBean pledgedSharesBean) {
        this.date = date;
        this.incomeBean = incomeBean;
        this.quarterlyExpensesBean = quarterlyExpensesBean;
        this.taxesAndExceptionsBean = taxesAndExceptionsBean;
        this.pAndLOthersBean = pAndLOthersBean;
        this.pledgedSharesBean = pledgedSharesBean;
    }

    public IncomeBean getIncomeBean() {
        return incomeBean;
    }

    public QuarterlyExpensesBean getQuarterlyExpensesBean() {
        return quarterlyExpensesBean;
    }

    public TaxesAndExceptionsBean getTaxesAndExceptionsBean() {
        return taxesAndExceptionsBean;
    }

    public PAndLOthersBean getpAndLOthersBean() {
        return pAndLOthersBean;
    }

    public PledgedSharesBean getPledgedSharesBean() { return pledgedSharesBean; }

    @Override
    public String toString() {
        return "Date=" + date +
                ", incomeBean=" + incomeBean +
                ", quarterlyExpensesBean=" + quarterlyExpensesBean +
                ", taxesAndExceptionsBean=" + taxesAndExceptionsBean +
                ", pAndLOthersBean=" + pAndLOthersBean +
                ", pledgedSharesBean=" + pledgedSharesBean;
    }
}
