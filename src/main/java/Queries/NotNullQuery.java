package Queries;

import Beans.CompanyBean;
import Utils.MiscellaneousFunctions;

import java.util.ArrayList;
import java.util.Date;

public class NotNullQuery extends Query {
    public NotNullQuery(Date queryDate){
        this.queryDate = queryDate;
    }

    public void run() {
        for(CompanyBean companyBean : allDataBean.getCompanyBeanList()){
            Integer numberOfYearsOfDataAvailable = MiscellaneousFunctions.getNumberOfYearsOfDataAvailable(queryDate, companyBean, 0);
            if(numberOfYearsOfDataAvailable < 1)
                queryOutput.add(0);
            else
                queryOutput.add(1);
        }
        isExecuted = true;
    }
}
