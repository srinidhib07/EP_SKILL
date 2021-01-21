package com.klu.main;
import java.sql.SQLException;
import java.util.Scanner;

import com.klu.Bean.StudentBean;
import com.klu.connections.DBUtil;
import com.klu.insert.DAO;
public class StudentMain {
	public static void main(String args[])
	{
		StudentBean sb = new StudentBean();
		
		DAO dao = new DAO();
		Scanner s= new Scanner(System.in);
		System.out.println("Menu");
		System.out.println("1. Insert ");
		System.out.println("2. Delete ");
		System.out.println("3. Display ");
		System.out.println("4. Update ");
		System.out.println("Enter choice ");
		int ch=s.nextInt();
		switch(ch) {
		case 1: try {
			System.out.println("Enter id: ");
			int id=s.nextInt();
			System.out.println("Enter name: ");
			String name=s.next();
			System.out.println("Enter email: ");
			String email=s.next();
			sb.setRegNo(id);
			sb.setName(name);
			sb.setEmail(email);
			int i=dao.StudentInsert(sb);
			if(i>0)
				System.out.println("Your insertion was successfull");
			else
				System.out.println("Insertion failed");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		break;
	
		
		case 2: try {
			System.out.println("Enter the reg no to be deleted: ");
			int id=s.nextInt();
			dao.StudentDelete(sb,id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		
		case 3: try {
			System.out.println("The table is : ");
			dao.StudentDisplay(sb);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		case 4: try {
			System.out.println("Enter reg no");
			int id=s.nextInt();
			System.out.println("Enter updated email: ");
			String email=s.next();
			dao.StudentUpdate(sb,id,email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		
		default: System.out.println("Enter valid choice");
			
		}
		
	
		
	}
	

}
