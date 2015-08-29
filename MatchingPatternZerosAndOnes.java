package com.kashi.udacity.software.testing;

import java.util.ArrayList;

public class MatchingPatternZerosAndOnes {

	void printAllMatchingPatterns(String string){
		try {
			ArrayList<String> patterns = getMatchingPatterns(string);
			for(String pattern :patterns){
				System.out.println(pattern);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if(string.length()==0)
			return;
		char[] chars = string.toCharArray();
		try {
			ArrayList<char[]> patterns = getMatchingPatterns(chars);
			for(char[] pattern :patterns){
				System.out.println(pattern);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	private ArrayList<char[]> getMatchingPatterns(char[] chars) throws Exception {
		//if char is != 48 or 49 print error
		if(chars==null)
			return null;
		if(chars.length==0)
			return null;
		ArrayList<char[]> patterns = new ArrayList<char[]>();
		if(chars.length==1){
			char c = chars[0];
			if((c=='0')||(c=='1')){
				patterns.add(chars);
				return patterns;
			}
			else if(c=='?'){
				char[] pattern1 = {'0'};
				char[] pattern2 ={'1'};
				patterns.add(pattern1);
				patterns.add(pattern2);
				return patterns;
			}
			else
				throw new Exception("Invalid pattern. Can contain only 0s and 1s char is "+c); //is an error
		}
		//get last character
		char lastChar = chars[chars.length-1];
		//construct a n-1 string
		char[] prevString = new char[chars.length-1];
		System.arraycopy(chars, 0, prevString, 0, chars.length-1);
		//get patterns for rest n-1 chars
		ArrayList<char[]> prevPatterns =  getMatchingPatterns(prevString);
		for(char[] prevPattern : prevPatterns){
			
			if((lastChar=='0')||(lastChar=='1')){
				char[] newPattern = new char[prevPattern.length+1];
				System.arraycopy(prevPattern, 0, newPattern, 0, prevPattern.length);
				newPattern[newPattern.length-1] = lastChar;
				patterns.add(newPattern);
			}
			else if(lastChar=='?'){
				char[] newPattern1 = new char[prevPattern.length+1];
				System.arraycopy(prevPattern, 0, newPattern1, 0, prevPattern.length);
				newPattern1[newPattern1.length-1] = lastChar;
				char[] newPattern2 = new char[prevPattern.length+1];
				System.arraycopy(prevPattern, 0, newPattern2, 0, prevPattern.length);
				newPattern2[newPattern2.length-1] = lastChar;
				newPattern1[newPattern1.length-1] = '1';
				patterns.add(newPattern1);
				newPattern2[newPattern2.length-1] = '0';
				patterns.add(newPattern2);
			}
			else
				throw new Exception("Invalid pattern. Can contain only 0s and 1s char is "+lastChar); //is an error
		}
		
		return patterns;
	}
	
	private ArrayList<String> getMatchingPatterns(String word) throws Exception {
		//if char is != 48 or 49 print error
		ArrayList<String> patterns = new ArrayList<String>();
		if(word ==null)
			return patterns;
		int wordLength = word.length();
		if(wordLength==0)
			return patterns;
		//if only one char is there is word return 0 , 1 or both 0 and 1
		if(wordLength==1){
			char c = word.charAt(0);
			if((c=='0')||(c=='1')){
				patterns.add(""+c);
			}
			else if(c=='?'){
				patterns.add("0");
				patterns.add("1");
			}
			else
				throw new Exception("Invalid Char found. Char is "+c);
		}
		//if more than one char is present
		else{
			System.out.println("word "+word);
			System.out.println("wl "+wordLength);
			//get the last char out 
			char lastChar = word.charAt(wordLength-1);
			
			System.out.println("lastChar "+lastChar);
			int wordLength1 =wordLength-1;
			System.out.println("wordLength-1 "+ wordLength1);
			System.out.println("substring "+word.substring(0, wordLength-1));
			//calculate pattern for wordlength -1
			ArrayList<String> prevPatterns = getMatchingPatterns(word.substring(0, wordLength-1));
			//for each prevPattern add 0 , 1 or 0 and 1
			for(String prevPattern: prevPatterns){
				if((lastChar=='0')||(lastChar=='1')){
					StringBuffer newPattern = new StringBuffer(prevPattern);
					//newPattern.append(prevPattern);
					newPattern.append(lastChar);
					patterns.add(newPattern.toString());
				}
				else if(lastChar=='?'){
					StringBuffer newPattern1 = new StringBuffer(prevPattern);
					//newPattern.append(prevPattern);
					newPattern1.append('0');
					patterns.add(newPattern1.toString());
					StringBuffer newPattern2 = new StringBuffer(prevPattern);
					//newPattern.append(prevPattern);
					newPattern2.append('1');
					patterns.add(newPattern2.toString());
				}
				else
					throw new Exception("Invalid Char found. Char is "+lastChar);
			}
		}
		return patterns;
		
	}
}
