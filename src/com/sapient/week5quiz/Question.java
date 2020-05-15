package com.sapient.week5quiz;

public class Question {

	private String questionString;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String correctOption;
	
	public Question(String questionString, String optionA, String optionB, String optionC, String optionD, String correctOption) {
		this.questionString = questionString;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctOption = correctOption;
	}
	
	public String getQuestionString() {
		return questionString;
	}
	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getcorrectOption() {
		return correctOption;
	}
	public void setcorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	
	public boolean verifyAnswer (String selectedOption) {
		selectedOption = selectedOption.toLowerCase().trim();
		if (selectedOption.equals(this.correctOption)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Question: \n"+questionString+"\na."+optionA+"\nb."+optionB+"\nc."+optionC+"\nd."+optionD+"\n";
	}

}
