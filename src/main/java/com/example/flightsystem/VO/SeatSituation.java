package com.example.flightsystem.VO;

import java.io.Serializable;
import java.util.Arrays;

public class SeatSituation implements Serializable {
    private int[][] structure;
    private boolean[] first;
    private boolean[] business;
    private boolean[] economy;
    private boolean[] costlyEconomy;

    public SeatSituation() {
    }

    public int[][] getStructure() {
        return structure;
    }

    public void setStructure(int[][] structure) {
        this.structure = structure;
    }

    public boolean[] getFirst() {
        return first;
    }

    public void setFirst(boolean[] first) {
        this.first = first;
    }

    public boolean[] getBusiness() {
        return business;
    }

    public void setBusiness(boolean[] business) {
        this.business = business;
    }

    public boolean[] getEconomy() {
        return economy;
    }

    public void setEconomy(boolean[] economy) {
        this.economy = economy;
    }

    public boolean[] getCostlyEconomy() {
        return costlyEconomy;
    }

    public void setCostlyEconomy(boolean[] costlyEconomy) {
        this.costlyEconomy = costlyEconomy;
    }

    @Override
    public String toString() {
        return "SeatSituation{" +
                "structure=" + Arrays.toString(structure) +
                ", first=" + Arrays.toString(first) +
                ", business=" + Arrays.toString(business) +
                ", economy=" + Arrays.toString(economy) +
                ", costlyEconomy=" + Arrays.toString(costlyEconomy) +
                '}';
    }
}
