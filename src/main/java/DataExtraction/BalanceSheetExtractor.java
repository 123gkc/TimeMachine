package DataExtraction;

import Beans.AssetsBean;
import Beans.BalanceSheetBean;
import Beans.EquityBean;
import Beans.LiabilitiesBean;
import Utils.Constants;
import Utils.MiscellaneousFunctions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

/**
 * Created by krishna.go on 28/11/17.
 */
public class BalanceSheetExtractor{
    public static HashMap<Date, BalanceSheetBean> extractAllBalanceSheetsData(List<String> htmlList){
        HashMap<Date, BalanceSheetBean> balanceSheetDataMap = new HashMap<Date, BalanceSheetBean>();
        HashMap<Date, HashMap<String, Double>> balanceSheetAllDataMap = new HashMap<Date, HashMap<String, Double>>();
        for(String html : htmlList){
            HashMap<Date, HashMap<String, Double>> temp = MiscellaneousFunctions.getAllDataMapMoneycontrolHtml(html);
            for(Map.Entry<Date, HashMap<String, Double>> entry : temp.entrySet())
                balanceSheetAllDataMap.put(entry.getKey(),entry.getValue());
        }
        for(Map.Entry<Date, HashMap<String, Double>> entry : balanceSheetAllDataMap.entrySet())
            balanceSheetDataMap.put(entry.getKey(), getBalanceSheetBeanFromAllData(entry.getKey(),entry.getValue()));

        return balanceSheetDataMap;
    }

    public static BalanceSheetBean getBalanceSheetBeanFromAllData(Date date,HashMap<String,Double> allDataMap){
        EquityBean equityBean = new EquityBean(allDataMap.get("total share capital"),allDataMap.get("total reserves and surplus"));
        LiabilitiesBean liabilitiesBean = new LiabilitiesBean(allDataMap.get("total non-current liabilities"), allDataMap.get("total current liabilities"));
        AssetsBean assetsBean = new AssetsBean(allDataMap.get("fixed assets"), allDataMap.get("total non-current assets"), allDataMap.get("total current assets"));
        return new BalanceSheetBean(date,equityBean,liabilitiesBean,assetsBean);
    }
}
