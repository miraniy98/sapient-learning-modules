package com.sapient.week5quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class QuestionDisplay implements Runnable {

	Question question;
	Scanner scanner;
	public static int score = 0;
	
	public QuestionDisplay(Question q) {
		this.question = q;
	}
	
	@Override
	public void run() {
		System.out.println(this.question);
		System.out.println("Enter your choice of Option.");
		scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		if(this.question.verifyAnswer(inputString)) {
			System.out.println("You Got it Right!");
			score++;
			System.out.println("Your Score: "+score);
		}
		else {
			System.out.println("Afsos! Yeh galat uttar hai!");
			System.out.println("Your Score: "+score);
		}
	}
	
}



public class Quiz {
	public List<Question> quizList = new ArrayList<Question>();
	
	public Quiz() {
		Question q1 = new Question("question 1", "Correct Answer", "Wrong Answer", "Wrong Answer", "Wrong Answer", "a");
		Question q2 = new Question("question 2", "Wrong Answer", "Wrong Answer", "Correct Answer", "Wrong Answer", "c");
		Question q3 = new Question("question 3", "Wrong Answer", "Correct Answer", "Wrong Answer", "Wrong Answer", "b");
		Question q4 = new Question("question 4", "Wrong Answer", "Wrong Answer", "Wrong Answer", "Correct Answer", "d");
		Question q5 = new Question("question 5", "Correct Answer", "Wrong Answer", "Wrong Answer", "Wrong Answer", "a");
		this.quizList.add(q1);
		this.quizList.add(q2);
		this.quizList.add(q3);
		this.quizList.add(q4);
		this.quizList.add(q5);
	}
	
	public boolean startQuestion(Question q) {
		Thread startQuestionThread = new Thread(new QuestionDisplay(q));
		startQuestionThread.setDaemon(true);
		startQuestionThread.start();
		boolean timerUp = false;
		try {
			startQuestionThread.join(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (startQuestionThread.isAlive()) {
			timerUp = true;
		}
		startQuestionThread.interrupt();
		return timerUp;
	}
}
