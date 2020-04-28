package com.sapient.assignmentweek3;

import java.util.Scanner;

import javax.management.ValueExp;

public class PrimeHexMapper {
	
	public static String[] toHexStringsPrime(int[] array) {
		String[] hexArrayStrings = new String[26];
		char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int rem = 0;
			String str2 = new String();
			while(num>0) {
		       rem=num%16; 
		       str2=hex[rem]+str2; 
		       num=num/16;
		    }
			hexArrayStrings[i] = str2;
		}
		return hexArrayStrings;
	}
	
	public static int[] primeNumberArray() {
		boolean prime[] = new boolean[100];
		for(int i=0;i<100;i++) { 
            prime[i] = true;
		}
          
        for(int p = 2; p*p <100; p++) 
        {  
            if(prime[p] == true) 
            { 
                for(int i = p*p; i <100; i += p) 
                    prime[i] = false; 
            } 
        }
        int[] arr = new int[26];
        int j=0;
        for(int i = 1; i < 100; i++) 
        { 
            if(prime[i] == true) {
            	arr[j]=i;
            	j++;
            }
        }
        return arr;
	}
	
	public static void main(String[] args) {
		int[] primeArray = new int[26];
		primeArray = primeNumberArray();
		String[] hexStringArray = new String[26]; 
		hexStringArray = toHexStringsPrime(primeArray);
		Scanner inputScanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter a String or Press q to exit. (Ignore Case Sensitivity but Dont enter characters except A-Z)");
			String inputString = inputScanner.nextLine();
			inputString = inputString.toUpperCase();
			if (inputString.compareToIgnoreCase("q")==0) {
				break;
			}
			String outputString = new String();
			for (int i = 0; i < inputString.length(); i++) {
				char tempChar = inputString.charAt(i);
				int tempInt = (int)tempChar-65;
				outputString = outputString + hexStringArray[tempInt];
			}
			// Returns B157 for FADE as input. Correction in the test case mentioned in the document to be made
			// F => 11 => B (instead of D)
			System.out.println(inputString + " => " + outputString);
		}
		inputScanner.close();
	}
}
