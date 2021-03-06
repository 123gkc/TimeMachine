package Queries;

import Beans.AllDataBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Query {
    AllDataBean allDataBean = AllDataBean.getInstance();
    List<Integer> queryOutput = new ArrayList<Integer>();
    Boolean isExecuted = false;
    Date queryDate = new Date();

    public final List<Integer> getQueryOutput() {
        if(isExecuted)
            return queryOutput;
        else{
            run();
            return queryOutput;
        }

    }

    public Boolean getExecuted() {
        return isExecuted;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public abstract void run();
}
