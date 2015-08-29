package com.kashi.udacity.software.testing;

import java.util.ArrayList;
import java.util.HashMap;

public class telephoneNum {
	
	HashMap<String,String> map;
	
	public telephoneNum() {
		map = new HashMap<String,String>();
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		
	}
	//222, 
	//a ,b, c
	//aa,ab,ac,ba,bb,bc,ca,cb,cc
	//aaa,aab,aac,aba,abb,abc,aca,acb,acc,baa,bab,bac,caa,cab,cac,cba,cbb,cbc,cca,ccb,ccc
	public ArrayList<String> findCombination(String s){
		ArrayList<String> results = new ArrayList<String>();
		if(s.length()==1){
			char[] alpha = map.get(s).toCharArray();
			for(char c: alpha)
				results.add(c+"");
			return results;
		}
		
		ArrayList<String> tempResults = findCombination(s.substring(1));
		char c = s.charAt(0);
		//System.out.println(c);
		//System.out.println(map.get(c+""));
		char[] alpha = map.get(c+"").toCharArray();
		for(String tempStr:tempResults){
			for(char tempChar:alpha){
				String newResult = tempStr+tempChar;
				results.add(newResult);
			}
		}
		return results;
	}
}
