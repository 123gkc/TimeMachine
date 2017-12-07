package Beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class AllDataBean {
    private static AllDataBean allDataBean = null;
    private static boolean isInstantiated = false;
    private List<CompanyBean> companyBeanList;

    private AllDataBean(){
        long startTime = System.currentTimeMillis();
        try {
            companyBeanList = new ArrayList<CompanyBean>();
            File dir = new File("/Users/krishna.go/myProjects/TimeMachineData/testingObjectCreation");
            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
                for (File file : directoryListing) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                    CompanyBean companyBean = (CompanyBean) objectInputStream.readObject();
                    companyBeanList.add(companyBean);
                }
            }
        }catch (Exception e){
            System.out.println("Caught an exception while trying to deserialize the compnayBeanList");
            e.printStackTrace();
        }
        isInstantiated = true;
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by the whole loading process : "+(endTime-startTime)/1000.0);
    }

    public static AllDataBean getInstance(){
        if(isInstantiated == false)
            allDataBean = new AllDataBean();

        return allDataBean;
    }

    public List<CompanyBean> getCompanyBeanList() {
        if(isInstantiated == true)
            return companyBeanList;
        else{
            new AllDataBean();
            return companyBeanList;
        }
    }
}
