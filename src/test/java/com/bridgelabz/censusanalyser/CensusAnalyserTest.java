package com.bridgelabz.censusanalyser;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import junit.framework.Assert;

public class CensusAnalyserTest {

	public final String STATECENSUS_CSVFILE = "C:\\\\Users\\\\LENOVO\\\\Desktop\\\\censusdata.csv";
    public final String WRONG_FILE = "/wrong.txt";

    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
        try {
            int count;
			count = CensusAnalyser.loadIndiaCensusData(STATECENSUS_CSVFILE);
            System.out.println(count);
            Assert.assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
	
}


