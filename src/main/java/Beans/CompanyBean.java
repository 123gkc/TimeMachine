package Beans;

import DataExtraction.*;
import Processors.HtmlGetter;
import Utils.MiscellaneousFunctions;

import java.io.Serializable;
import java.util.*;

/**
 * Created by krishna.go on 28/11/17.
 */
public class CompanyBean implements Serializable {
    private String compnayName;
    private String codeBSE;
    private String codeNSE;
    private String ISIN;
    private String sector;
    private List<BalanceSheetBean> balanceSheetBeanList = new ArrayList<BalanceSheetBean>();
    private List<PAndLSheetBean> pAndLSheetBeanList = new ArrayList<PAndLSheetBean>();
    private List<CashFlowSheetBean> cashFlowSheetBeanList = new ArrayList<CashFlowSheetBean>();
    private List<QuarterlyResultsBean> quarterlyResultsBeanList = new ArrayList<QuarterlyResultsBean>();
    private List<KeyRatiosBean> keyRatiosBeanList = new ArrayList<KeyRatiosBean>();

    public CompanyBean(List<BalanceSheetBean> balanceSheetBeanList, List<PAndLSheetBean> pAndLSheetBeanList, List<CashFlowSheetBean> cashFlowSheetBeanList, List<QuarterlyResultsBean> quarterlyResultsBeanList, List<KeyRatiosBean> keyRatiosBeanList) {
        this.balanceSheetBeanList = balanceSheetBeanList;
        this.pAndLSheetBeanList = pAndLSheetBeanList;
        this.cashFlowSheetBeanList = cashFlowSheetBeanList;
        this.quarterlyResultsBeanList = quarterlyResultsBeanList;
        this.keyRatiosBeanList = keyRatiosBeanList;
    }

    public CompanyBean(HashMap<Date, BalanceSheetBean> balanceSheetDataMap, HashMap<Date, PAndLSheetBean> pAndLSheetDataMap, HashMap<Date, CashFlowSheetBean> cashFlowSheetDataMap, HashMap<Date, QuarterlyResultsBean> quarterlyResultsDataMap, HashMap<Date, KeyRatiosBean> keyRatiosDataMap){
        for(Date key : balanceSheetDataMap.keySet())
            this.balanceSheetBeanList.add(balanceSheetDataMap.get(key));
        for(Date key : pAndLSheetDataMap.keySet())
            this.pAndLSheetBeanList.add(pAndLSheetDataMap.get(key));
        for(Date key : cashFlowSheetDataMap.keySet())
            this.cashFlowSheetBeanList.add(cashFlowSheetDataMap.get(key));
        for(Date key : quarterlyResultsDataMap.keySet())
            this.quarterlyResultsBeanList.add(quarterlyResultsDataMap.get(key));
        for(Date key : keyRatiosDataMap.keySet())
            this.keyRatiosBeanList.add(keyRatiosDataMap.get(key));

        sortAllListsByDate();
    }

    public CompanyBean(String companyName,HashMap<String, String> dataUrlsMap){
        String balanceSheetBaseUrl = dataUrlsMap.get("balanceSheet");
        String pAndLSheetBaseUrl = dataUrlsMap.get("pAndLSheet");
        String cashFlowSheetBaseUrl = dataUrlsMap.get("cashFlowSheet");
        String quarterlyResultsBaseUrl = dataUrlsMap.get("quarterlyResults");
        String keyRatiosBaseUrl = dataUrlsMap.get("keyRatios");

        String htmlForMetaDataExtraction = null;
        try {
            htmlForMetaDataExtraction = HtmlGetter.getHtmlFromUrl(balanceSheetBaseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, String> metaDataMap = MetaDataExtractor.extractMetaData(htmlForMetaDataExtraction);
        this.compnayName = companyName;
        this.codeBSE = metaDataMap.get("BSE");
        this.codeNSE = metaDataMap.get("NSE");
        this.ISIN = metaDataMap.get("ISIN");
        this.sector = metaDataMap.get("SECTOR");

        List<String> allHistoricalHtmlsList = HtmlGetter.getAllHistoricalHtmlsFromUrlOfMoneyControl(balanceSheetBaseUrl);
        HashMap<Date, BalanceSheetBean> balanceSheetDataMap = BalanceSheetExtractor.extractAllBalanceSheetsData(allHistoricalHtmlsList);
        for(Date key : balanceSheetDataMap.keySet())
            this.balanceSheetBeanList.add(balanceSheetDataMap.get(key));

        allHistoricalHtmlsList = HtmlGetter.getAllHistoricalHtmlsFromUrlOfMoneyControl(pAndLSheetBaseUrl);
        HashMap<Date, PAndLSheetBean> pAndLDataMap = PAndLSheetExtractor.extractAllPAndLSheetsData(allHistoricalHtmlsList);
        for(Date key : pAndLDataMap.keySet())
            this.pAndLSheetBeanList.add(pAndLDataMap.get(key));

        allHistoricalHtmlsList = HtmlGetter.getAllHistoricalHtmlsFromUrlOfMoneyControl(cashFlowSheetBaseUrl);
        HashMap<Date, CashFlowSheetBean> cashFlowDataMap = CashFlowSheetExtractor.extractAllCashFlowSheetsData(allHistoricalHtmlsList);
        for(Date key : cashFlowDataMap.keySet())
            this.cashFlowSheetBeanList.add(cashFlowDataMap.get(key));

        allHistoricalHtmlsList = HtmlGetter.getAllHistoricalHtmlsFromUrlOfMoneyControl(quarterlyResultsBaseUrl);
        HashMap<Date, QuarterlyResultsBean> quarterlyResultsDataMap = QuarterlyResultsExtractor.extractAllQuarterlyResultsData(allHistoricalHtmlsList);
        for(Date key : quarterlyResultsDataMap.keySet())
            this.quarterlyResultsBeanList.add(quarterlyResultsDataMap.get(key));

        allHistoricalHtmlsList = HtmlGetter.getAllHistoricalHtmlsFromUrlOfMoneyControl(keyRatiosBaseUrl);
        HashMap<Date, KeyRatiosBean> keyRatiosDataMap = KeyRatiosExtractor.extractAllKeyRatiosData(allHistoricalHtmlsList);
        for (Date key : keyRatiosDataMap.keySet())
            this.keyRatiosBeanList.add(keyRatiosDataMap.get(key));

        sortAllListsByDate();
    }

    public String getCompnayName() {
        return compnayName;
    }

    public String getCodeBSE() {
        return codeBSE;
    }

    public String getCodeNSE() {
        return codeNSE;
    }

    public String getISIN() {
        return ISIN;
    }

    public String getSector() {
        return sector;
    }

    public List<BalanceSheetBean> getBalanceSheetBeanList() {
        return balanceSheetBeanList;
    }

    public List<PAndLSheetBean> getPAndLSheetBeanList() {
        return pAndLSheetBeanList;
    }

    public List<CashFlowSheetBean> getCashFlowSheetBeanList() {return cashFlowSheetBeanList;}

    public List<QuarterlyResultsBean> getQuarterlyResultsBeanList() { return quarterlyResultsBeanList; }

    public List<KeyRatiosBean> getKeyRatiosBeanList() { return keyRatiosBeanList; }

    public void sortAllListsByDate(){
        MiscellaneousFunctions.sortBalanceSheetListByDate(balanceSheetBeanList);
        MiscellaneousFunctions.sortPAndLSheetListByDate(pAndLSheetBeanList);
        MiscellaneousFunctions.sortCashFlowSheetListByDate(cashFlowSheetBeanList);
        MiscellaneousFunctions.sortQuarterlyResultsByDate(quarterlyResultsBeanList);
        MiscellaneousFunctions.sortKeyRatiosByDate(keyRatiosBeanList);
    }

    @Override
    public String toString() {
        return "companyName="+compnayName+
                ", codeBSE="+codeBSE+
                ", codeNSE="+codeNSE+
                ", ISIN="+ISIN+
                ", sector="+sector+
                ", balanceSheetBeanList="+balanceSheetBeanList+
                ", pAndLSheetBeanList="+pAndLSheetBeanList+
                ", cashFlowBeanList="+cashFlowSheetBeanList+
                ", quarterlyResultsBeanList="+quarterlyResultsBeanList+
                ", keyRatiosBeanList="+keyRatiosBeanList;
    }
}
