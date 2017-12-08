package Utils;

import Beans.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class MiscellaneousFunctions {

    public static <T extends FinancialsReportBean> void sortFinancialsReportListByDate(List<T> financialsReportBeanList){
        Collections.sort(financialsReportBeanList, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }

    public static Date convertDateFormat(Element dateAsElement){
        String dateAsString = dateAsElement.ownText();
        String[] monthAndYear = dateAsString.split(" ");
        if(monthAndYear[1].length()==3)
            monthAndYear[1] = monthAndYear[1].substring(1);
        Integer year = Integer.parseInt(monthAndYear[1].trim());
        Integer month = getMonthIndex(monthAndYear[0].trim());
        Integer date;
        if(monthAndYear.length<3)
            date = 1;
        else
            date = Integer.parseInt(monthAndYear[2].trim());
        Date dateAsDate;
        if(year <50)
            dateAsDate = new Date(2000+year-1900, month, date);
        else
            dateAsDate = new Date(year,month,date);
        return dateAsDate;
    }

    public static Integer getMonthIndex(String month){
        if(month.equalsIgnoreCase("jan") || month.equalsIgnoreCase("january"))
            return 0;
        if(month.equalsIgnoreCase("feb") || month.equalsIgnoreCase("february"))
            return 1;
        if(month.equalsIgnoreCase("mar") || month.equalsIgnoreCase("march"))
            return 2;
        if(month.equalsIgnoreCase("apr") || month.equalsIgnoreCase("april"))
            return 3;
        if(month.equalsIgnoreCase("may") || month.equalsIgnoreCase("may"))
            return 4;
        if(month.equalsIgnoreCase("jun") || month.equalsIgnoreCase("june"))
            return 5;
        if(month.equalsIgnoreCase("jul") || month.equalsIgnoreCase("july"))
            return 6;
        if(month.equalsIgnoreCase("aug") || month.equalsIgnoreCase("august"))
            return 7;
        if(month.equalsIgnoreCase("sep") || month.equalsIgnoreCase("september"))
            return 8;
        if(month.equalsIgnoreCase("oct") || month.equalsIgnoreCase("october"))
            return 9;
        if(month.equalsIgnoreCase("nov") || month.equalsIgnoreCase("november"))
            return 10;
        if(month.equalsIgnoreCase("dec") || month.equalsIgnoreCase("december"))
            return 11;
        return -1;
    }

    public static Integer getTableIndexContainingData(Document document){
        Integer dataInTableIndex = 0;
        while(true){
            if(document.select(".table4").size() <= dataInTableIndex)
                break;
            if(document.select(".table4").get(dataInTableIndex).select("tr").size()>10)
                break;
            dataInTableIndex++;
        }
        return dataInTableIndex;
    }

    public static HashMap<Date, HashMap<String, Double>> getAllDataMapMoneycontrolHtml(String html){
        HashMap<Date, HashMap<String, Double>> allDataMap = new HashMap<Date, HashMap<String, Double>>();
        List<Date> datesList = new ArrayList<Date>();
        Document document = Jsoup.parse(html);
        Element dataContainingElement = document.select(".table4").get(getTableIndexContainingData(document));
        Elements tableRows = dataContainingElement.select("tr");
        Integer datesIndex = getIndexOfDatesFromMoneyControl(tableRows);
        Elements dates = tableRows.get(datesIndex).select("td");
        dates.remove(0);
        for(Element date : dates){
            Date formattedDate = MiscellaneousFunctions.convertDateFormat(date);
            datesList.add(formattedDate);
            allDataMap.put(formattedDate,new HashMap<String, Double>());
        }
        for(int i = 0 ; i< datesIndex; i++)
            tableRows.remove(0);
        for(Element row : tableRows){
            String rowName = row.select("td").get(0).ownText().toLowerCase().trim();
            if(rowName.equalsIgnoreCase(""))
                continue;
            else{
                Elements tableDataPoints = row.select("td");
                tableDataPoints.remove(0);
                Integer counter = 0;
                for(Element tableDataPoint : tableDataPoints){
                    if(!tableDataPoint.ownText().equalsIgnoreCase("-") && !tableDataPoint.ownText().equalsIgnoreCase("--") && tableDataPoint.ownText().length()>0){
                        HashMap<String, Double> tempMapBean = allDataMap.get(datesList.get(counter));
                        tempMapBean.put(rowName,Double.parseDouble(tableDataPoint.ownText().trim().replaceAll(",","")));
                        allDataMap.put(datesList.get(counter),tempMapBean);
                    }
                    counter++;
                }
            }
        }
        return allDataMap;
    }

    public static String formatStringNumbers(String number){
        if(number.contains("("))
            return "-" + number.substring(1,number.indexOf(")"));
        else
            return number;
    }

    public static void writeHtmlsToFiles(List<String> htmlList, String fileName){
        String outputFolderPath = "/Users/krishna.go/myProjects/TimeMachineData/TestData/";
        Integer counter = 1;
        for(String html : htmlList){
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(outputFolderPath+fileName+counter.toString()+".html", "UTF-8");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            counter++;
            writer.print(html);
            writer.close();
        }
    }

    private static Integer getIndexOfDatesFromMoneyControl(Elements tableRows){
        Integer currentRow = 0;
        while(true) {
            if(tableRows.get(currentRow).select("td").size()<2) {
                currentRow++;
                continue;
            }
            if (tableRows.get(currentRow).select("td").get(1).ownText().length() > 0)
                break;
            currentRow++;
        }
        return currentRow;
    }

    public static Integer getNumberOfYearsOfDataAvailable(Date fromDate, CompanyBean companyBean, Integer consideringBeansMode){
        Integer numberOfYearsOfDataAvailable = 0;
        if(consideringBeansMode==0){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 1; i < 6; i++)
                list.add(getNumberOfYearsOfDataAvailable(fromDate, companyBean,i));
            Integer min = list.get(0);
            for(Integer current : list)
                if(current < min)
                    min = current;
            return min;

        }
        if(consideringBeansMode==1){
            List<BalanceSheetBean> balanceSheetBeanList = companyBean.getBalanceSheetBeanList();
            numberOfYearsOfDataAvailable = getNumberOfYearsOfDataAvailableHelper(fromDate, balanceSheetBeanList);
        }
        if(consideringBeansMode==2){
            List<CashFlowSheetBean> cashFlowSheetBeanList = companyBean.getCashFlowSheetBeanList();
            numberOfYearsOfDataAvailable = getNumberOfYearsOfDataAvailableHelper(fromDate, cashFlowSheetBeanList);
        }
        if(consideringBeansMode==3){
            List<PAndLSheetBean> pAndLSheetBeanList = companyBean.getPAndLSheetBeanList();
            numberOfYearsOfDataAvailable = getNumberOfYearsOfDataAvailableHelper(fromDate, pAndLSheetBeanList);
        }
        if(consideringBeansMode==4){
            List<KeyRatiosBean> keyRatiosBeanList = companyBean.getKeyRatiosBeanList();
            numberOfYearsOfDataAvailable = getNumberOfYearsOfDataAvailableHelper(fromDate, keyRatiosBeanList);
        }
        if(consideringBeansMode==5){
            List<QuarterlyResultsBean> quarterlyResultsBeanList = companyBean.getQuarterlyResultsBeanList();
            if(quarterlyResultsBeanList.size() == 0 || quarterlyResultsBeanList.get(0).getDate().after(fromDate))
                return -1;
            Date lastBeanDate = quarterlyResultsBeanList.get(0).getDate();
            for(int i = 1; i< quarterlyResultsBeanList.size(); i+=4){
                QuarterlyResultsBean quarterlyResultsBean = quarterlyResultsBeanList.get(i);
                if(!areQuarterApart(quarterlyResultsBean.getDate(), lastBeanDate))
                    lastBeanDate = quarterlyResultsBean.getDate();
                if(quarterlyResultsBean.getDate().after(fromDate))
                    break;
                numberOfYearsOfDataAvailable++;
            }
        }
        return numberOfYearsOfDataAvailable+1;
    }

    private static <T extends FinancialsReportBean> Integer getNumberOfYearsOfDataAvailableHelper(Date fromDate, List<T> financialsReportBeanList){
        Integer numberOfYearsOfDataAvailable = 0;
        if(financialsReportBeanList.size() == 0 || financialsReportBeanList.get(0).getDate().after(fromDate))
            return -2;
        Date lastBeanDate = financialsReportBeanList.get(0).getDate();
        for(int i = 1; i< financialsReportBeanList.size(); i++){
            FinancialsReportBean financialsReportBean = financialsReportBeanList.get(i);
            if(!areOneYearApart(financialsReportBean.getDate(), lastBeanDate))
                lastBeanDate = financialsReportBean.getDate();
            if(financialsReportBean.getDate().after(fromDate))
                break;
            numberOfYearsOfDataAvailable++;
        }
        return numberOfYearsOfDataAvailable;
    }

    public static boolean areOneYearApart(Date date1, Date date2){
        if(date1.getYear() - date2.getYear() == 1 || date1.getYear() - date2.getYear() == -1)
            return true;
        else
            return false;
    }

    public static boolean areQuarterApart(Date date1, Date date2){
        if(date1.getMonth() - date2.getMonth() == 3 || date1.getMonth() - date2.getMonth() == -3)
            return true;
        else
            return false;
    }
}
