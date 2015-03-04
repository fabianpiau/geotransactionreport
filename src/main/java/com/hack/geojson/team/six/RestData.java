package com.hack.geojson.team.six;

public class RestData {
    String region;
    String totalAmount;
    String nbTransactions;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getNbTransactions() {
        return nbTransactions;
    }

    public void setNbTransactions(String nbTransactions) {
        this.nbTransactions = nbTransactions;
    }

    @Override
    public String toString() {
        return "RestData{" +
                "region='" + region + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", nbTransactions='" + nbTransactions + '\'' +
                '}';
    }
}