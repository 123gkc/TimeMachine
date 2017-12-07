package DataExtraction;

import Beans.*;
import Utils.MiscellaneousFunctions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuarterlyResultsExtractor {
    public static HashMap<Date, QuarterlyResultsBean> extractAllQuarterlyResultsData(List<String> htmlList){
        HashMap<Date, QuarterlyResultsBean> quarterlyResultsDataMap = new HashMap<Date, QuarterlyResultsBean>();
        HashMap<Date, HashMap<String, Double>> quarterlyResultsAllDataMap = new HashMap<Date, HashMap<String, Double>>();
        for(String html : htmlList){
            HashMap<Date, HashMap<String, Double>> temp = MiscellaneousFunctions.getAllDataMapMoneycontrolHtml(html);
            for(Map.Entry<Date, HashMap<String, Double>> entry : temp.entrySet())
                quarterlyResultsAllDataMap.put(entry.getKey(),entry.getValue());
        }
        for(Map.Entry<Date, HashMap<String, Double>> entry : quarterlyResultsAllDataMap.entrySet())
            quarterlyResultsDataMap.put(entry.getKey(), getQuarterlyResultsBeanFromAllData(entry.getKey(),entry.getValue()));

        return quarterlyResultsDataMap;
    }

    public static QuarterlyResultsBean getQuarterlyResultsBeanFromAllData(Date date,HashMap<String,Double> allDataMap){
        IncomeBean incomeBean= new IncomeBean(allDataMap.get("net sales/income from operations"),allDataMap.get("other operating income"));
        QuarterlyExpensesBean quarterlyExpensesBean = new QuarterlyExpensesBean(allDataMap.get("consumption of raw materials"), allDataMap.get("purchase of traded goods"),allDataMap.get("increase/decrease in stocks"),allDataMap.get("power & fuel"), allDataMap.get("employees cost"), allDataMap.get("depreciation"), allDataMap.get("r & d expenses"), allDataMap.get("other expenses"));
        TaxesAndExceptionsBean taxesAndExceptionsBean = new TaxesAndExceptionsBean(allDataMap.get("exceptional items"), allDataMap.get("tax"));
        PAndLOthersBean pAndLOthersBean = new PAndLOthersBean(allDataMap.get("net profit/(loss) for the period"), allDataMap.get("basic eps"), allDataMap.get("diluted eps"), allDataMap.get("equity share capital"), allDataMap.get("equity dividend rate (%)"));
        PledgedSharesBean pledgedSharesBean = null;
        if(allDataMap.get("- per. of shares (as a % of the total sh. of prom. and promoter group)") == null)
            pledgedSharesBean = new PledgedSharesBean(new Double(100),new Double(100));
        else
            pledgedSharesBean = new PledgedSharesBean(allDataMap.get("- per. of shares (as a % of the total sh. of prom. and promoter group)"),allDataMap.get("- per. of shares (as a % of the total share cap. of the company)"));

        return new QuarterlyResultsBean(date,incomeBean,quarterlyExpensesBean,taxesAndExceptionsBean,pAndLOthersBean, pledgedSharesBean);
    }
}
