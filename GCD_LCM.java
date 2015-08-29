package com.kashi.udacity.software.testing;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/* 
 * Program to find GCD and LCM of two numbers
 */
public class GCD_LCM {

	public static Hashtable<Integer, Integer> findPrimeFactors(int num) {
		int temp =num;
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		for (int i = 2; i <= num; i++) {
			if ((num % i) == 0) {
				if(ht.get(i)==null)
					ht.put(i, 1);
				else{
					int n = ht.get(i)+1;
					ht.put(i, n);
				}
					
				num = num / i;
				i--;
			}
		}
		System.out.println("prime factorization for "+temp);
		Set<Integer> keys =ht.keySet();
		
		for(int key:keys)
		System.out.println(key+"^"+ht.get(key));
		System.out.println("-----------");
		return ht;
	}

	public static int findLCM(int num1, int num2) {
		Hashtable<Integer, Integer> pfs1 = findPrimeFactors(num1);
		Hashtable<Integer, Integer> pfs2 = findPrimeFactors(num2);
		Set<Integer> keys1 = pfs1.keySet();
		int lcm = 1;
		for (int key1 : keys1) {
			if (pfs2.containsKey(key1)) {
				int pow1 = pfs1.get(key1);
				int pow2 = pfs2.get(key1);
				int maxpow = (pow1 > pow2 ? pow1 : pow2);
				lcm = lcm * (int)(Math.pow(key1, maxpow));
				pfs1.remove(key1);
			}
			else{
				lcm=lcm*(int)(Math.pow(key1, pfs1.get(key1)));
			}
		}
		for(int key2: pfs2.keySet()){
			lcm= lcm*(int)(Math.pow(key2, pfs2.get(key2)));
		}
		return lcm;
	}

	public static int findGCD(int num1, int num2) {
		Hashtable<Integer, Integer> pfs1 = findPrimeFactors(num1);
		Hashtable<Integer, Integer> pfs2 = findPrimeFactors(num2);

		Set<Integer> keys1 = pfs1.keySet();
		int gcd = 1;
		for (int key1 : keys1) {
			if (pfs2.containsKey(key1)) {
				int pow1 = pfs1.get(key1);
				int pow2 = pfs2.get(key1);
				int minpow = (pow1 < pow2 ? pow1 : pow2);
				gcd = gcd * (int)(Math.pow(key1, minpow));
			}
		}
		return gcd;
	}
	
	public static void main(){
		System.out.println("GCD of 4,2 is" +findGCD(7,8));
		System.out.println("LCM of 4,2 is" +findGCD(7,8));
		
	}
}
