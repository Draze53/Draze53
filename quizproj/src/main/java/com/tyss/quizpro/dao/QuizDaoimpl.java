package com.tyss.quizpro.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.quizpro.bean.ExamTopic;
import com.tyss.quizpro.bean.Options;
import com.tyss.quizpro.bean.Questions;
import com.tyss.quizpro.bean.UserInfo;

public class QuizDaoimpl implements IQuizDao {

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int flag;
	Scanner sc = new Scanner(System.in);

	public void entityMethod() {
		factory = Persistence.createEntityManagerFactory("QuizData");
		manager = factory.createEntityManager();
	}

	@Override
	public UserInfo login(String email, String password) {
		try {
			entityMethod();
			// to take dynamic values we have to go for jpql queries
			String data = "from UserInfo where email=:email1 and password=:password1";
			Query query = manager.createQuery(data);
			query.setParameter("email1", email);
			query.setParameter("password1", password);
			// to get multiple records we need to use query.getResultList()
			// and to get the single record we need to use query.getSingleRecord();
			UserInfo user = (UserInfo) query.getSingleResult();
			if (user != null) {
				System.out.println("Login Successfully");
			} else {
				System.out.println("Incorrect Password");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}

	@Override
	public UserInfo registration(int user_id, String name, int age, String email, String password) {

		UserInfo user = new UserInfo();
		user.setUser_id(user_id);
		user.setName(name);
		user.setAge(age);
		user.setEmail(email);
		user.setPassword(password);
		try {
			entityMethod();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			System.out.println("Data Inserted Successfully");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}

	@Override
	public ExamTopic exam(String language) {
		try {
			entityMethod();
			String data = "from ExamTopic where exam_name=:language";
			Query query = manager.createQuery(data);
			query.setParameter("language", language);
			ExamTopic exam = (ExamTopic) query.getSingleResult();
			if (exam != null) {
				return exam;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String options_ans(int questionid) {
		String answer = null;
		try {
			entityMethod();
			String data = "from Options where question_id=:question_id1";
			Query query = manager.createQuery(data);
			query.setParameter("question_id1", questionid);
			List<Options> options = query.getResultList();
			for (int i = 0; i < options.size(); i++) {
				System.out.println((i + 1) + "." + options.get(i).getOptions());
			}
			System.out.println("Enter your ans");
			int ans = sc.nextInt();
			answer = options.get(ans - 1).getOptions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}

	@Override
	public Object questions(String language) {
		try {
			entityMethod();
			int exam_id = exam(language).getExam_id();
			String data = "from Questions where exam_id=:exam_id1";
			Query query = manager.createQuery(data);
			query.setParameter("exam_id1", exam_id);
			List<Questions> question = query.getResultList();
			for (int i = 0; i < question.size(); i++) {
				System.out.println(question.get(i).getQuestion());
				int question_id = question.get(i).getQuestion_id();
				String result = options_ans(question_id);
				if (question.get(i).getAnswer().equalsIgnoreCase(result)) {
					flag++;
					System.out.println("-----------------");
				}
			}
			System.out.println("Your Final Score is " + flag + " in the " + language + " exam");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}
}