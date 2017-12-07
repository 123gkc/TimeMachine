package DataExtraction;

import Beans.*;
import Utils.MiscellaneousFunctions;

import java.util.*;

public class CashFlowSheetExtractor {
    public static HashMap<Date, CashFlowSheetBean> extractAllCashFlowSheetsData(List<String> htmlList){
        HashMap<Date, CashFlowSheetBean> cashFlowSheetDataMap = new HashMap<Date, CashFlowSheetBean>();
        HashMap<Date, HashMap<String, Double>> cashFlowSheetAllDataMap = new HashMap<Date, HashMap<String, Double>>();
        for(String html : htmlList){
            HashMap<Date, HashMap<String, Double>> temp = MiscellaneousFunctions.getAllDataMapMoneycontrolHtml(html);
            for(Map.Entry<Date, HashMap<String, Double>> entry : temp.entrySet())
                cashFlowSheetAllDataMap.put(entry.getKey(),entry.getValue());
        }
        for(Map.Entry<Date, HashMap<String, Double>> entry : cashFlowSheetAllDataMap.entrySet())
            cashFlowSheetDataMap.put(entry.getKey(), getCashFlowSheetBeanFromAllData(entry.getKey(),entry.getValue()));

        return cashFlowSheetDataMap;
    }

    public static CashFlowSheetBean getCashFlowSheetBeanFromAllData(Date date, HashMap<String,Double> allDataMap){
        return new CashFlowSheetBean(date, allDataMap.get("net profit before tax"),
                allDataMap.get("net cash from operating activities"),
                allDataMap.get("net cash (used in)/from investing activities"),
                allDataMap.get("net cash (used in)/from financing activities"),
                allDataMap.get("closing cash & cash equivalents"));
    }
}
