package Beans;

import java.io.Serializable;

/**
 * Created by krishna.go on 28/11/17.
 */
public class EquityBean implements Serializable {
    private Double shareCapital;
    private Double reservesAndSurplus;

    public EquityBean(Double shareCapital, Double reservesAndSurplus) {
        this.shareCapital = shareCapital;
        this.reservesAndSurplus = reservesAndSurplus;
    }

    public Double getShareCapital() {
        return shareCapital;
    }

    public Double getReservesAndSurplus() {
        return reservesAndSurplus;
    }

    @Override
    public String toString() {
        return "shareCapital=" + shareCapital +
                ", reservesAndSurplus=" + reservesAndSurplus;
    }
}
