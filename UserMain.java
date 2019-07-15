package com.nucleus.exec;

import java.sql.SQLException;
import java.util.Scanner;

import com.nucleus.dao.UserDao;
import com.nucleus.dao.UserRDBMSDaoImpl;
import com.nucleus.entity.User;

public class UserMain {
	public static void main(String[] args) throws SQLException {
		
		Scanner scanner=new Scanner(System.in);
		UserDao userdao=new UserRDBMSDaoImpl();
		User user=new User();
		System.out.println("welcome to application");
		String choice;
		do {
		System.out.println("please enter your  choice");
		System.out.println("press 1 for Sign Up (for creating a new account)");
		System.out.println("press 2 for Sign In (for logging in to your account)");
		int ch=scanner.nextInt();
		String email,pass,gender,username;
		
		switch(ch)
		{
		case 1:
			 System.out.println("enter the email id");
			 email=scanner.next();
			 System.out.println("enter the password");
			 pass=scanner.next();
			 System.out.println("enter the user name");
			 username=scanner.next();
			 System.out.println("enter the gender");
			 gender=scanner.next();
			 user.setEmailId(email);
			 user.setPassword(pass);
			 user.setGender(gender);
			 user.setUsername(username);
			 userdao.signUp(user);
			break;
		case 2:
			System.out.println("enter the email id");
			 email=scanner.next();
			 System.out.println("enter the password");
			 pass=scanner.next();
			 user.setEmailId(email);
			 user.setPassword(pass);
			 userdao.signIn(user);
			break;
	    default:
	    	System.out.println("please enter right choice");
	    	
		}
		System.out.println("want to enter more choices yes/no");
		choice=scanner.next();
		}while(choice.equalsIgnoreCase("yes"));
		
		
	}

}
