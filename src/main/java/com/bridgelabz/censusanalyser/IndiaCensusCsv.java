package com.bridgelabz.censusanalyser;

import java.util.Comparator;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCsv implements Comparable<IndiaCensusCsv> {

    @CsvBindByName(column = "State")
    private String stateName;

    @CsvBindByName(column = "Population",required = true)
    private String population;

    @CsvBindByName(column = "AreaInSqKm")
    private String areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    private String densityPerSqKm;

    public IndiaCensusCsv() {

    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public String getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setDensityPerSqKm(String densityPerSqKm) {
        this.densityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return  "stateName='" + stateName + '\'' +
                ", population='" + population + '\'' +
                ", areaInSqKm='" + areaInSqKm + '\'' +
                ", densityPerSqKm='" + densityPerSqKm + '\''
                +"\n";
    }
    @Override
    public int compareTo(IndiaCensusCsv indiaCensusCsv) {
        return this.stateName.compareTo(indiaCensusCsv.stateName);
    }

    static class StateCensusComparator implements Comparator<IndiaCensusCsv> {
        public int compare(IndiaCensusCsv obj1, IndiaCensusCsv obj2) {
            return obj1.getStateName().compareTo(obj2.getStateName());
        }
    }

	
}
