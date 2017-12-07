package Beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by krishna.go on 28/11/17.
 */
public class BalanceSheetBean implements Serializable{
    private Date date;
    private EquityBean equityBean;
    private LiabilitiesBean liabilitiesBean;
    private AssetsBean assetsBean;

    public BalanceSheetBean(Date date, EquityBean equityBean, LiabilitiesBean liabilitiesBean, AssetsBean assetsBean) {
        this.date = date;
        this.equityBean = equityBean;
        this.liabilitiesBean = liabilitiesBean;
        this.assetsBean = assetsBean;
    }

    public Date getDate(){
        return date;
    }

    public EquityBean getEquityBean() {
        return equityBean;
    }

    public LiabilitiesBean getLiabilitiesBean() {
        return liabilitiesBean;
    }

    public AssetsBean getAssetsBean() {
        return assetsBean;
    }

    @Override
    public String toString() {
        return "Date=" + date +
                ", equityBean=" + equityBean +
                ", liabilitiesBean=" + liabilitiesBean +
                ", assetsBean=" + assetsBean;
    }
}
