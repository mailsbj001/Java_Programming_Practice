package com.kashi.udacity.software.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class MatchingWordLines {

	void printLinesThatMatch(InputStreamReader text, ArrayList<String> patterns){
			BufferedReader br = new BufferedReader(text);
			String line;
			int totalCount =0 ;
			StringBuffer outputText = new StringBuffer();
			try {
				while(null!=(line=br.readLine())){
					int findCount = findTotalMatches(line,patterns);
					if(findCount>0){
						outputText.append(line);
						totalCount += findCount;
					}			
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(outputText);
				
	}

	private int findTotalMatches(String line, ArrayList<String> patterns) {
		HashSet<String> patternsHset =  new HashSet<String>(patterns);
		int matches = 0;
		String[] words = line.split("\\s");
		for(String word:words){
			if(patternsHset.contains(word))
				++matches;
		}
		return matches;
	}
	
	void testPrintLinesThatMatch(){
		InputStreamReader is = new InputStreamReader(System.in);
		ArrayList<String> patterns = new ArrayList<String>();
		patterns.add("blind");
		patterns.add("three");
		printLinesThatMatch(is,patterns);
		
	}
}
