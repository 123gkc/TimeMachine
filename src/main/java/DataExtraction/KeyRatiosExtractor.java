package DataExtraction;

import Beans.*;
import Utils.MiscellaneousFunctions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyRatiosExtractor {
    public static HashMap<Date, KeyRatiosBean> extractAllKeyRatiosData(List<String> htmlList){
        HashMap<Date, KeyRatiosBean> keyRatiosDataMap = new HashMap<Date, KeyRatiosBean>();
        HashMap<Date, HashMap<String, Double>> keyRatiosAllDataMap = new HashMap<Date, HashMap<String, Double>>();
        for(String html : htmlList){
            HashMap<Date, HashMap<String, Double>> temp = MiscellaneousFunctions.getAllDataMapMoneycontrolHtml(html);
            for(Map.Entry<Date, HashMap<String, Double>> entry : temp.entrySet())
                keyRatiosAllDataMap.put(entry.getKey(),entry.getValue());
        }
        for(Map.Entry<Date, HashMap<String, Double>> entry : keyRatiosAllDataMap.entrySet())
            keyRatiosDataMap.put(entry.getKey(), getKeyRatiosBeanFromAllData(entry.getKey(),entry.getValue()));

        return keyRatiosDataMap;
    }

    public static KeyRatiosBean getKeyRatiosBeanFromAllData(Date date,HashMap<String,Double> allDataMap){
        PerShareRatiosBean perShareRatiosBean = new PerShareRatiosBean(allDataMap.get("basic eps (rs.)"),allDataMap.get("diluted eps (rs.)"),allDataMap.get("cash eps (rs.)"),allDataMap.get("book value [exclrevalreserve]/share (rs.)"),allDataMap.get("dividend / share(rs.)"),allDataMap.get("revenue from operations/share (rs.)"),allDataMap.get("pbdit/share (rs.)"),allDataMap.get("pbit/share (rs.)"),allDataMap.get("pbt/share (rs.)"),allDataMap.get("net profit/share (rs.)"));
        ProfitabilityRatiosBean profitabilityRatiosBean = new ProfitabilityRatiosBean(allDataMap.get("pbdit margin (%)"), allDataMap.get("pbit margin (%)"), allDataMap.get("pbt margin (%)"), allDataMap.get("net profit margin (%)"), allDataMap.get("return on networth / equity (%)"),allDataMap.get("return on capital employed (%)"), allDataMap.get("return on assets (%)"), allDataMap.get("total debt/equity (x)"), allDataMap.get("asset turnover ratio (%)"));
        LiquidityRatiosBean liquidityRatiosBean = new LiquidityRatiosBean(allDataMap.get("current ratio (x)"), allDataMap.get("quick ratio (x)"), allDataMap.get("inventory turnover ratio (x)"), allDataMap.get("dividend payout ratio (np) (%)"), allDataMap.get("dividend payout ratio (cp) (%)"), allDataMap.get("earnings retention ratio (%)"), allDataMap.get("cash earnings retention ratio (%)"));
        ValuationRatiosBean valuationRatiosBean = new ValuationRatiosBean(allDataMap.get("enterprise value (cr.)"), allDataMap.get("ev/net operating revenue (x)"),allDataMap.get("ev/ebitda (x)"),allDataMap.get("marketcap/net operating revenue (x)"), allDataMap.get("retention ratios (%)"),allDataMap.get("price/bv (x)"),allDataMap.get("price/net operating revenue"),allDataMap.get("earnings yield"));

        return new KeyRatiosBean(date, perShareRatiosBean, profitabilityRatiosBean, liquidityRatiosBean, valuationRatiosBean);
    }
}
