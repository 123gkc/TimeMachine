package Beans;

import java.io.Serializable;

/**
 * Created by krishna.go on 28/11/17.
 */
public class AssetsBean implements Serializable{
    private Double fixedAssets;
    private Double nonCurrentAssets;
    private Double currentAssets;

    public AssetsBean(Double fixedAssets, Double nonCurrentAssets, Double currentAssets) {
        this.fixedAssets = fixedAssets;
        this.nonCurrentAssets = nonCurrentAssets;
        this.currentAssets = currentAssets;
    }

    public Double getFixedAssets() {
        return fixedAssets;
    }

    public Double getNonCurrentAssets() {
        return nonCurrentAssets;
    }

    public Double getCurrentAssets() {
        return currentAssets;
    }

    @Override
    public String toString() {
        return  "fixedAssets=" + fixedAssets +
                ", nonCurrentAssets=" + nonCurrentAssets +
                ", currentAssets=" + currentAssets;
    }
}
