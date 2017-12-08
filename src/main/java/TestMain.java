import Beans.AllDataBean;
import Beans.CompanyBean;
import Queries.NotNullQuery;

import java.util.Date;


/**
 * Created by krishna.go on 28/11/17.
 */
public class TestMain {
    public static void main(String[] args) throws Exception{
        NotNullQuery notNullQuery = new NotNullQuery(new Date());
        Integer count = 0;
        for(Integer i : notNullQuery.getQueryOutput())
            count+=i;
        System.out.println(count);

        /*long startTime = System.currentTimeMillis();
        HashMap<String, String> urlMap = new HashMap<String, String>();
        urlMap.put("balanceSheet","http://www.moneycontrol.com/financials/acesoftware/balance-sheetVI/AS23");
        urlMap.put("pAndLSheet","http://www.moneycontrol.com/financials/acesoftware/profit-lossVI/AS23#AS23");
        urlMap.put("cashFlowSheet","http://www.moneycontrol.com/financials/acesoftware/cash-flow/AS23#AS23");
        urlMap.put("quarterlyResults","http://www.moneycontrol.com/financials/acesoftware/results/quarterly-results/AS23#AS23");
        urlMap.put("keyRatios","http://www.moneycontrol.com/financials/acesoftware/ratiosVI/AS23#AS23");
        System.out.println(new CompanyBean("Ace Software",urlMap));
        long endTime = System.currentTimeMillis();
        System.out.println("Time : "+(endTime-startTime)/1000.0);
*/
    }
}
