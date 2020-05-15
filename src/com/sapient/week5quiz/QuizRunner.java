package com.sapient.week5quiz;

public class QuizRunner {
	public static void main(String[] args) {
		Quiz newQuiz = new Quiz();
		QuestionDisplay demo= new QuestionDisplay(null);
		System.out.println("Welcome to Quiz! If you dont answer each question in 10s, the quiz will be terminated!");
		System.out.println("There are 5 Questions. Try and Answer All!");
		for (Question question: newQuiz.quizList) {
			boolean timerStatus = newQuiz.startQuestion(question);
			if (timerStatus == true) {
				System.out.println("Quiz terminated due to timeout! Thanks");
				break;
			}
		}
		System.out.println("Your Final Score is " + demo.score + " out of 5!");
	}
}
