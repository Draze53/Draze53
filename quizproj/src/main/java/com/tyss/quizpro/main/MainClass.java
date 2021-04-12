package com.tyss.quizpro.main;

import java.util.Scanner;

import com.tyss.quizpro.service.IQuizService;
import com.tyss.quizpro.service.QuizServiceImpl;

public class MainClass {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("=================================================");
		System.out.println("|| Enter your choice                           ||");
		System.out.println("|| 1.Login                                     ||");
		System.out.println("|| 2.Register if you are not a member          ||");
		System.out.println("=================================================");
		int n1=sc.nextInt();
		switch (n1) {
		case 1:
			IQuizService iService1=new QuizServiceImpl();
			iService1.login();
			System.out.println("==========================================");
			System.out.println("||Which quiz do you want to attend now? ||");
			System.out.println("||1.Java                                ||");
			System.out.println("||2.Html                                ||");
			System.out.println("||3.JS                                  ||");
			System.out.println("||Enter your choice                     ||");
			System.out.println("==========================================");
			int n2=sc.nextInt();
			switch (n2) {
			case 1:
				String exam_type1="java";
				IQuizService iService3=new QuizServiceImpl();
				iService3.questions(exam_type1);
				break;
			case 2:
				String exam_type2="html";
				IQuizService iService4=new QuizServiceImpl();
				iService4.questions(exam_type2);
				break;
			case 3:
				String exam_type3="js";
				IQuizService iService5=new QuizServiceImpl();
				iService5.questions(exam_type3);
				break;
			default:
				System.out.println("It is not at all possible");
				break;
			}
			break;
		case 2:
			IQuizService iService2=new QuizServiceImpl();
			iService2.registration();
			break;
		default:
			break;
		}
	}
}
