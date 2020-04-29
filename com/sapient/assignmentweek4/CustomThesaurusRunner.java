package com.sapient.assignmentweek4;
import java.util.Scanner;


public class CustomThesaurusRunner {

	public static void main(String[] args) {
		CustomThesaurus newCustomThesaurus = new CustomThesaurus();
		Scanner inputScannerMain = new Scanner(System.in);
		while (true) {
			System.out.println("Thesaurus Menu Options (Press a number to choose) ");
			System.out.println("1. View all words (Keys)");
			System.out.println("2. View Synonyms for a word or Add synonyms for a word");
			System.out.println("3. Exit");
			int choice = inputScannerMain.nextInt();
			if (choice == 1) {
				System.out.println("Displaying All the keys in the Thesaurus");
				System.out.println(newCustomThesaurus.FindKeys());
			}
			else if (choice == 2) {
				System.out.println("Enter a word for which you want to find Synonyms. If that word is not there you will be asked if you want to add synonyms for it.");
				inputScannerMain.nextLine();
				String lookupString = inputScannerMain.nextLine();
				newCustomThesaurus.PrintOrAddSynonyms(lookupString);
			}
			else {
				break;
			}
		}
		inputScannerMain.close();
	}

}
