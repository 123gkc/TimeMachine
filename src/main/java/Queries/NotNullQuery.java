package Queries;

import Beans.CompanyBean;

import java.util.ArrayList;
import java.util.Date;

public class NotNullQuery extends Query {
    public NotNullQuery() {
        queryOutput = new ArrayList<Integer>();
        isExecuted = false;
    }

    public NotNullQuery(Date queryDate){
        this.queryDate = queryDate;
        queryOutput = new ArrayList<Integer>();
        isExecuted = false;
    }

    public void run() {
        for(CompanyBean companyBean : allDataBean.getCompanyBeanList()){
            if(companyBean.getBalanceSheetBeanList().size()>0)
                queryOutput.add(1);
            else
                queryOutput.add(0);
        }
        isExecuted = true;
    }
}
