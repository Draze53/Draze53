package com.tyss.quizpro.service;

import java.util.Scanner;

import com.tyss.quizpro.bean.UserInfo;
import com.tyss.quizpro.dao.IQuizDao;
import com.tyss.quizpro.dao.QuizDaoimpl;
public class QuizServiceImpl implements IQuizService{

	Scanner sc=new Scanner(System.in);
	IQuizDao idao=new QuizDaoimpl();
	@Override
	public UserInfo login() {
		System.out.println("Enter the user_id(email_id)");
		String email=sc.next();
		System.out.println("Enter the password");
		String password=sc.next();
		return idao.login(email,password);
	}

	@Override
	public UserInfo registration() {
		System.out.println("Enter the user_id");
		int user_id=sc.nextInt();
		
		System.out.println("Enter your name");
		String name=sc.nextLine();
		sc.next();
		System.out.println("Enter the email");
		String email=sc.next();
		
		System.out.println("Enter your age");
		int age=sc.nextInt();
		
		System.out.println("Enter the password");
		String password=sc.next();
		return idao.registration(user_id,name,age,email,password);
	}
	
	@Override
	public Object questions(String language) {
		return idao.questions(language);
	}
}
