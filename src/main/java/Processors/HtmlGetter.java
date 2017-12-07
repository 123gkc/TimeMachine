package Processors;


import Utils.Constants;
import Utils.MiscellaneousFunctions;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by krishna.go on 27/11/17.
 */
public class HtmlGetter {
    public static String getMoneyControlHtml(Integer startYear, Integer endYear, String urlString, String nav) throws Exception {
        URL url = new URL(urlString);
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        params.put("nav", nav);
        params.put("start_year", startYear);
        params.put("end_year", endYear);

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }

        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String html = IOUtils.toString(in);

        return html;
    }

    public static String getHtmlFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String inputLine;
        String html= "";
        while ((inputLine = br.readLine()) != null) {
            html = html.concat(inputLine);
        }
        br.close();
        return html;
    }

    public static List<String> getAllHistoricalHtmlsFromUrlOfMoneyControl(String url){
        String baseHtml = "";
        List<String> allHistoricalHtmlsList = new ArrayList<String>();
        try {
            baseHtml = getHtmlFromUrl(url);
        } catch (Exception e) {
            System.out.println("Caught an exception while trying to fetch the base HTML");
            e.printStackTrace();
        }
        String currentHtml = baseHtml;
        Integer currentYear = Constants.BASE_YEAR;
        Integer currentMonth = Constants.BASE_MONTH;
        while(hasDataForMoneyControl(currentHtml)){
            allHistoricalHtmlsList.add(currentHtml);
            try {
                if(url.contains("quarterly")){
                    currentHtml = getMoneyControlHtml(currentYear*100+currentMonth, (currentYear - 1)*100+currentMonth,url,"next");
                    if(currentMonth == 3){
                        currentYear -= 2;
                        currentMonth = 12;
                    }
                    currentYear -= 1;
                    currentMonth -= 3;
                }
                else {
                    currentHtml = getMoneyControlHtml(currentYear * 100 + 3, (currentYear - 4) * 100 + 3, url, "next");
                    currentYear -= 5;
                }
            } catch (Exception e) {
                System.out.println("Caught an exception trying to fetch the subsequent history ");
                e.printStackTrace();
            }
        }
        return allHistoricalHtmlsList;
    }

    public static boolean hasDataForMoneyControl(String html){
        Document document = Jsoup.parse(html);
        if(document.select(".table4").size() <= MiscellaneousFunctions.getTableIndexContainingData(document))
            return false;
        Element dataContainingElement = document.select(".table4").get(MiscellaneousFunctions.getTableIndexContainingData(document));
        Elements tableRows = dataContainingElement.select("tr");
        if(tableRows.size()<10)
            return false;
        return true;
    }
}
