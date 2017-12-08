package Mains;

import Beans.CompanyBean;
import Processors.CompanyObjectListBuilder;

import java.io.*;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DataSerializeFromNetMain {
    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
        BlockingQueue companyUrlsQueue = new ArrayBlockingQueue(10000);
        File file = new File("/Users/krishna.go/myProjects/Extractor/CompanyFinancialsLinksMoneyControl.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            companyUrlsQueue.put(line);
        }
        fileReader.close();

        List<CompanyBean> companyBeanList = (CompanyObjectListBuilder.buildCompanyObjectList(companyUrlsQueue));

        for(CompanyBean companyBean : companyBeanList){
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/krishna.go/myProjects/TimeMachineData/testingObjectCreation/"+companyBean.getCompanyName()+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

            out.writeObject(companyBean);

            out.close();
            fileOutputStream.close();
        }

        System.out.println("Objects have been serialized");

        long endTime = System.currentTimeMillis();
        System.out.println("Time : "+(endTime-startTime)/1000.0);
    }
}
