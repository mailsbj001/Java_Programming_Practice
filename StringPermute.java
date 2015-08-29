package com.kashi.udacity.software.testing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringPermute {

	public ArrayList<String> permute(String s) {
		ArrayList<String> permutaions = new ArrayList<String>();

		if (s.length() <= 1) {
			permutaions.add(s);
			return permutaions;
		}

		// find permutations of string[1 to n-1]
		ArrayList<String> temp = permute(s.substring(1));
		char token = s.charAt(0);
		
		
		for (String tempResult : temp) {
			// add char at every position in subResults
			for(int i=0;i<=tempResult.length();i++){
				StringBuffer sb = new StringBuffer();
				int j=0;
				while(j<i){
					sb.append(tempResult.charAt(j++));
				}
				sb.append(token);
				while(j<tempResult.length()){
					sb.append(tempResult.charAt(j++));
				}
				permutaions.add(sb.toString());	
			}
		}
		return permutaions;
	}
	
	public ArrayList<String> combineIterative(String s){
		ArrayList <String> combinations = new ArrayList<String>();
		
		for(int i =0;i<s.length();i++)
			combinations.add(s.charAt(i)+"");
		int k =0;
		for(int i=1;i<s.length();i++){
			ArrayList<String> combinations2 = new ArrayList<String>();
		
			System.out.println(k+"*"+combinations.size());
			for(;k<combinations.size();k++){
				String setString = combinations.get(k);
				for(int j=k+1;j<s.length();j++){
					combinations2.add(setString+s.charAt(j));
				}
			}
			for(String str: combinations2){
				combinations.add(str);
			}
		
		}
		combinations.add(s);
		
		return combinations;
	}
	
	public ArrayList<String> combineRecursive(String s ){
		ArrayList<String> results = new ArrayList<String>();
		if(s.length()==1)
		{
			results.add(s);
			return results;
		}
		String subString = s.substring(1);
		results = combineRecursive(subString);
		char c = s.charAt(0);
		ArrayList<String> temp = new ArrayList<String>();
		for(String string :results){
			String newString = c+string;
			temp.add(newString);
		}
		temp.add(c+"");
		for(String string:temp){
			results.add(string);
		}
		return results;
		
	}
	

}
