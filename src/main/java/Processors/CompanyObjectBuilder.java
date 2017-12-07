package Processors;

import Beans.CompanyBean;

import java.util.HashMap;

public class CompanyObjectBuilder implements Runnable {
    public CompanyObjectBuilder() {
    }

    public void run(){
        while(CompanyObjectListBuilder.companyUrlsQueue.size()>0){
            if(CompanyObjectListBuilder.companyBeansQueue.size()%100 == 0)
                System.out.println("Completed : " + new Double(CompanyObjectListBuilder.companyBeansQueue.size())/80.0+ "%");
            String s = null;
            try {
                s = CompanyObjectListBuilder.companyUrlsQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String[] stringElements = s.split(",");
            try {
                CompanyObjectListBuilder.companyBeansQueue.put(new CompanyBean(stringElements[0],getCompanyFinancialsUrlMap(stringElements)));
            } catch (InterruptedException e) {
                System.out.println("Caught an exception while processing for the company : "+stringElements[0]);
                e.printStackTrace();
            }
        }
    }

    private HashMap<String, String> getCompanyFinancialsUrlMap(String[] companyUrlStrings){
        HashMap<String, String> companyFinancialsUrlMap = new HashMap<String, String>();
        companyFinancialsUrlMap.put("balanceSheet",getFullUrl(companyUrlStrings[2]));
        companyFinancialsUrlMap.put("pAndLSheet",getFullUrl(companyUrlStrings[3]));
        companyFinancialsUrlMap.put("cashFlowSheet",getFullUrl(companyUrlStrings[6]));
        companyFinancialsUrlMap.put("quarterlyResults",getFullUrl(companyUrlStrings[4]));
        companyFinancialsUrlMap.put("keyRatios",getFullUrl(companyUrlStrings[7]));
        return companyFinancialsUrlMap;
    }

    private String getFullUrl(String url){
        if(url.charAt(0)=='/'){
            url = "http://www.moneycontrol.com" + url;
        }
        return url;
    }
}
