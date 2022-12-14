package com.bridgelabz.censusanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {

	public static int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException{
	try {
		Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
		CsvToBeanBuilder<IndiaCensusCsv> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
		csvToBeanBuilder.withType(IndiaCensusCsv.class);
		csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
		CsvToBean<IndiaCensusCsv> csvToBean = csvToBeanBuilder.build();
		Iterator<IndiaCensusCsv> censusCsvIterator = csvToBean.iterator();
		Iterable<IndiaCensusCsv> csvIterable = () -> censusCsvIterator;
		int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(),false).count();
		return numOfEntries;
	}
	catch(IOException e) {
		throw new CensusAnalyserException(e.getMessage(),
				                         CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	catch(IllegalStateException e) {
		throw new CensusAnalyserException(e.getMessage(),
				                         CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
		}
	
	}
}