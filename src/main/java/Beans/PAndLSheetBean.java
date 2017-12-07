package Beans;

import java.io.Serializable;
import java.util.Date;

public class PAndLSheetBean implements Serializable {
    private Date date;
    private IncomeBean incomeBean;
    private ExpensesBean expensesBean;
    private TaxesAndExceptionsBean taxesAndExceptionsBean;
    private PAndLOthersBean pAndLOthersBean;

    public PAndLSheetBean(Date date, IncomeBean incomeBean, ExpensesBean expensesBean, TaxesAndExceptionsBean taxesAndExceptionsBean, PAndLOthersBean pAndLOthersBean) {
        this.date = date;
        this.incomeBean = incomeBean;
        this.expensesBean = expensesBean;
        this.taxesAndExceptionsBean = taxesAndExceptionsBean;
        this.pAndLOthersBean = pAndLOthersBean;
    }

    public Date getDate() {
        return date;
    }

    public IncomeBean getIncomeBean() {
        return incomeBean;
    }

    public ExpensesBean getExpensesBean() {
        return expensesBean;
    }

    public TaxesAndExceptionsBean getTaxesAndExceptionsBean() {
        return taxesAndExceptionsBean;
    }

    public PAndLOthersBean getpAndLOthersBean() {
        return pAndLOthersBean;
    }

    @Override
    public String toString() {
        return "Date=" + date +
                ", incomeBean=" + incomeBean +
                ", expensesBean=" + expensesBean +
                ", taxesAndExceptionsBean=" + taxesAndExceptionsBean +
                ", pAndLOthersBean=" + pAndLOthersBean;
    }
}
