package DataExtraction;

import Beans.*;
import Utils.Constants;
import Utils.MiscellaneousFunctions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class PAndLSheetExtractor {
    public static HashMap<Date, PAndLSheetBean> extractAllPAndLSheetsData(List<String> htmlList){
        HashMap<Date, PAndLSheetBean> pAndLSheetDataMap = new HashMap<Date, PAndLSheetBean>();
        HashMap<Date, HashMap<String, Double>> pAndLSheetAllDataMap = new HashMap<Date, HashMap<String, Double>>();
        for(String html : htmlList){
            HashMap<Date, HashMap<String, Double>> temp = MiscellaneousFunctions.getAllDataMapMoneycontrolHtml(html);
            for(Map.Entry<Date, HashMap<String, Double>> entry : temp.entrySet())
                pAndLSheetAllDataMap.put(entry.getKey(),entry.getValue());
        }
        for(Map.Entry<Date, HashMap<String, Double>> entry : pAndLSheetAllDataMap.entrySet())
            pAndLSheetDataMap.put(entry.getKey(), getPAndLBeanFromAllData(entry.getKey(),entry.getValue()));

        return pAndLSheetDataMap;
    }

    public static PAndLSheetBean getPAndLBeanFromAllData(Date date,HashMap<String,Double> allDataMap){
        IncomeBean incomeBean = new IncomeBean(allDataMap.get("total operating revenues"), allDataMap.get("other income"));
        ExpensesBean expensesBean = new ExpensesBean(allDataMap.get("cost of materials consumed"), allDataMap.get("employee benefit expenses"), allDataMap.get("finance costs"), allDataMap.get("depreciation and amortisation expenses"), allDataMap.get("other expenses"), allDataMap.get("total expenses"));
        TaxesAndExceptionsBean taxesAndExceptionsBean = new TaxesAndExceptionsBean(allDataMap.get("exceptional items"), allDataMap.get("total tax expenses"));
        PAndLOthersBean pAndLOthersBean = new PAndLOthersBean(allDataMap.get("profit/loss for the period"),allDataMap.get("basic eps (rs.)"), allDataMap.get("diluted eps (rs.)"), allDataMap.get("equity share dividend"), allDataMap.get("equity dividend rate (%)"));
        return new PAndLSheetBean(date, incomeBean, expensesBean, taxesAndExceptionsBean, pAndLOthersBean);
    }

}
