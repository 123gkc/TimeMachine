package DataExtraction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;

public class MetaDataExtractor {
    public static HashMap<String, String> extractMetaData(String html){
        HashMap<String, String> metaDataMap = new HashMap<String, String>();
        Document document = Jsoup.parse(html);
        Element element = document.select(".PB10").get(0).children().first();
        String dataString = element.toString();
        dataString = dataString.substring(22,dataString.length()-6);
        String[] dataElements = dataString.split("<span class=\"PR7 PL7\">\\|</span>");
        for(String dataElement : dataElements){
            String[] labelAndValue = dataElement.split(": ");
            metaDataMap.put(labelAndValue[0].trim(),labelAndValue[1].trim());
        }

        return metaDataMap;
    }
}
