package Processors;

import Beans.CompanyBean;
import Beans.ExpensesBean;
import sun.jvm.hotspot.opto.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CompanyObjectListBuilder {
    public static BlockingQueue<String> companyUrlsQueue;
    public static BlockingQueue<CompanyBean> companyBeansQueue;

    public static List<CompanyBean> buildCompanyObjectList(BlockingQueue<String> companyUrls){
        long startTime = System.currentTimeMillis();
        companyUrlsQueue = companyUrls;
        companyBeansQueue = new ArrayBlockingQueue<CompanyBean>(10000);

        ExecutorService executorService = Executors.newFixedThreadPool(25);
        for(int i = 0; i < 25; i++) {
            executorService.execute(new CompanyObjectBuilder());
        }
        executorService.shutdown();
        boolean finished = false;
        try {
            finished = executorService.awaitTermination(1000, TimeUnit.MINUTES);
        }
        catch(Exception e){
            System.out.println("Caught an exception");
            e.printStackTrace();
        }
        if(finished){
            System.out.println("total process took "+ (System.currentTimeMillis()-startTime));
        }
        List<CompanyBean> companyBeanList = new ArrayList<CompanyBean>();
        while(companyBeansQueue.size()>0)
            companyBeanList.add(companyBeansQueue.poll());
        return companyBeanList;
    }
}
