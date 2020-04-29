package com.sapient.assignmentweek4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CustomThesaurus {

	Map<String, Set<String>> customThesaurusMap = new HashMap<String, Set<String>>();
	
	public CustomThesaurus() {
		this.customThesaurusMap.put("Good Morning", new HashSet<String>());
		this.customThesaurusMap.put("Good Evening", new HashSet<String>());
		Set<String> hashSet = this.customThesaurusMap.get("Good Morning");
		hashSet.add("Good Morning");
		hashSet.add("Shubh Savar");
		hashSet.add("Shubhodaya");
		hashSet.add("Bonjour");
		hashSet.add("Shubh Prabhat");
		hashSet = this.customThesaurusMap.get("Good Evening");
		hashSet.add("Good Evening");
		hashSet.add("Shubh Sange");
		hashSet.add("Susandhya");
		hashSet.add("Bonsoir");
		hashSet.add("Shubh Saanj");
	}
	
	public boolean CheckKey (String lookupKey) {
		if (this.customThesaurusMap.containsKey(lookupKey)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Set<String> LookUpSynonyms (String lookupKey) {
		return this.customThesaurusMap.get(lookupKey);
	}
	
	public void AddSynonyms(String newKey, Set<String> synonymSet) {
		this.customThesaurusMap.put(newKey, synonymSet);
	}
	
	public Set<String> FindKeys() {
		return this.customThesaurusMap.keySet();
	}
	
	public void PrintOrAddSynonyms (String lookupKey) {
		if (CheckKey(lookupKey)) {
			Set<String> synonymSet = LookUpSynonyms(lookupKey);
			System.out.println("Synonyms for " + lookupKey + " are:");
			for (String item : synonymSet) {
				System.out.println(lookupKey + " : " + item);
			}
		}
		else {
			System.out.println("This word does not exist in Thesaurus. Would you like to add it?(Y/N)");
			@SuppressWarnings("resource")
			Scanner inputScanner = new Scanner(System.in);
			char decisiveInput = inputScanner.next().charAt(0);
			if (decisiveInput == 'Y' || decisiveInput == 'y') {
				System.out.println("Great! Write all the Synonyms that you can think of for: " + lookupKey);
				Set<String> hashSet = new HashSet<String>();
				String inputLine;
				inputScanner.nextLine();
				while (!(inputLine = inputScanner.nextLine()).isEmpty()) {
					hashSet.add(inputLine);
				}
				AddSynonyms(lookupKey, hashSet);
				System.out.println("All Right! Synonyms added.");
			}
			else {
				System.out.println("No Problem, You can add 'em later!");
			}
		}
	}

}
