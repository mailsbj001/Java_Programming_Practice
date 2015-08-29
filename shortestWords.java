package com.kashi.udacity.software.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class shortestWords {

	ArrayList<String> dictionary;
	HashMap<String,ArrayList<String>> lexToWord; 
	
	shortestWords(ArrayList<String> dictionary){
		this.dictionary = dictionary;
		lexToWord = new HashMap<String,ArrayList<String>>();
		buildLexToWordMap();
		for(String key: lexToWord.keySet()){
			ArrayList<String> words = lexToWord.get(key);
			System.out.print(key+" - ");
			for(String word:words){
				System.out.print(word+", ");
			}
			System.out.println("");
		}
	}
	
	void buildLexToWordMap(){
		for(String string: dictionary){
			String lexicallyOrderedStr = lexOrderString(string);
			if(lexToWord.containsKey(lexicallyOrderedStr)){
				ArrayList<String> words = lexToWord.get(lexicallyOrderedStr);
				words.add(string);
				lexToWord.put(lexicallyOrderedStr, words);
			}
			else{
				ArrayList<String> words = new ArrayList<String>();
				words.add(string);
				lexToWord.put(lexicallyOrderedStr, words);
			}
		}
	}
	
	String lexOrderString(String string){
	if((string!=null)&&(!string.equals(""))){
		ArrayList<Character> chars = new ArrayList<Character>();
		for(int i=0;i<string.length();i++){
			chars.add(string.charAt(i));
		}
		Collections.sort(chars);
		StringBuilder finalw = new StringBuilder();
		for(char c : chars){
			finalw.append(c);
		}
		//System.out.println(string+"-"+finalw.toString());
		return finalw.toString();
	}

	return string;
	}
	
	ArrayList<String> findShortestWords(String str){
		String lexOrderStr = lexOrderString(str);
		int min = 180;
		ArrayList<String> shortestWords =null ;
		for(String key:lexToWord.keySet()){
			if((key.length()<min)&&(lexOrderStr.contains(key))){
				shortestWords = lexToWord.get(key);
				min = key.length();
			}
		}
		for(String strde: shortestWords){
			System.out.println(strde);
		}
		return shortestWords;
	}
}
