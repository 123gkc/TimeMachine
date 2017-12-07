package Beans;

import java.io.Serializable;

/**
 * Created by krishna.go on 28/11/17.
 */
public class LiabilitiesBean implements Serializable {
    private Double nonCurrentLiabilities;
    private Double currentLiabilities;

    public LiabilitiesBean(Double nonCurrentLiabilities, Double currentLiabilities) {
        this.nonCurrentLiabilities = nonCurrentLiabilities;
        this.currentLiabilities = currentLiabilities;
    }

    public Double getNonCurrentLiabilities() {
        return nonCurrentLiabilities;
    }

    public Double getCurrentLiabilities() {
        return currentLiabilities;
    }

    @Override
    public String toString() {
        return "nonCurrentLiabilities=" + nonCurrentLiabilities +
                ", currentLiabilities=" + currentLiabilities;
    }
}
