package studentmanagementsytem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDoperation extends  Thread {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		char ch;
		try {
			System.out.println("\t\t\t\t\t\t***WELCOME!! TO THE STUDENT MANAGEMENT SYSTEM***");
			Thread.sleep(1000);
			System.out.println("\t\t\t\t\t\t***WE ARE HAPPY TO SEE YOU HERE***");
			do {
				Thread.sleep(1000);
				System.out.println("\t\t\t\t\t\t\t***MENU***");
				System.out.println("\t\t\t\t\t\t\t1.CREATE DATA");
				System.out.println("\t\t\t\t\t\t\t2.RETRIEVE DATA");
				System.out.println("\t\t\t\t\t\t\t3.UPDATE DATA");
				System.out.println("\t\t\t\t\t\t\t4.SEARCH DATA");
				System.out.println("\t\t\t\t\t\t\t5.DELETE DATA");
				System.out.println("\t\t\t\t\t\t please...ENTER YOUR CHOICE NUMBER:->");
				Thread.sleep(1000);
				int a=sc.nextInt();
				if(a==1) {
					try {
					System.out.println("Admin can add the Student information:");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					PreparedStatement ps=con.prepareStatement("insert into studentmanagemnet values(?,?,?,?,?,?)");
					System.out.println("database connected");
					System.out.println();
					System.out.println("enter student id:");
					int id=sc1.nextInt();
					System.out.println("enter student name:");
					sc.nextLine();
					String name=sc.nextLine();
					System.out.println("enter student course");
					String course=sc.nextLine();
					System.out.println("enter student city");
					String city=sc.nextLine();
					System.out.println("enter student total_marks:");
					int total_marks=sc1.nextInt();
					System.out.println("enter your phone_no:");
					String phone_no=sc.nextLine();
					ps.setInt(1,id);
					ps.setString(2,name);
					ps.setString(3,course);
					ps.setString(4,city);
					ps.setInt(5,total_marks);
					ps.setString(6,phone_no);
					ps.executeUpdate();
					System.out.println("data inserted successfully");
					con.close();
					}
					catch (Exception e) {
						System.out.println(e);
					}
				}
				else if(a==2) {
					try {
						Thread.sleep(1000);
					System.out.println("Admin can view the list of Students in tabular form");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					Statement st=con.createStatement();
					 ResultSet rs= st.executeQuery("select * from studentmanagemnet");
					   while(rs.next())
					   {
						   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+
								   rs.getInt(5)+"\t"+rs.getString(6));
					   }
					}
					catch (Exception e) {
						System.out.println(e);
					}
					
				}
				else if(a==3) {
					try {
						Thread.sleep(1000);
					System.out.println("Admin can edit the Student information");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					PreparedStatement ps=con.prepareStatement("update studentmanagemnet set city=? where id=?");
					System.out.println("enter your city:");
					sc.nextLine();
					String city=sc.nextLine();
					System.out.println("enter your id:");
					int id=sc.nextInt();
					ps.setString(1,city);
					ps.setInt(2, id);
					int status=ps.executeUpdate();
					if(status>0) {
						System.out.println("data updated successfully");
					}
					else {
						System.out.println("not updated");
					}
					}
					catch (Exception e) {
						System.out.println(e);
					}
				}
				else if(a==4) {
					try {
						Thread.sleep(1000);
					System.out.println("Admin can search the Student by their ID");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					
					System.out.println("Database connected");
					
					System.out.println("enter your  student id:");
					int id=sc.nextInt();
				
				
				String query="select * from studentmanagemnet where id="+id;
			  PreparedStatement ps= con.prepareStatement(query);
			  ResultSet rs=ps.executeQuery(); 
			  while(rs.next())
			   {
				  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+
						   rs.getInt(5)+"\t"+rs.getString(6));
			   }
					}
					catch (Exception e) {
						System.out.println(e);
					}
			 
				}
				else if(a==5) {
					try {
						Thread.sleep(1000);
						System.out.println("Admin can delete the Student information."
								+ "");
						System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					
					System.out.println("Database connected");
					
					System.out.println("enter your  student id:");
					int id=sc.nextInt();
				
				
				String query="delete from studentmanagemnet where id="+id;
			  PreparedStatement ps= con.prepareStatement(query);
			  
			 int status=0;
			  
			  status= ps.executeUpdate();
			 
			 if(status>0)
			 {
				 System.out.println("data deleted sucessfully");
			 }
			 else
			 {
				 System.out.println("not deleted..try again...");
			 }
					
				}
					catch (Exception e) {
						System.out.println(e);
					}
				
				
			}
				else {
					System.out.println("please select correct option..");
				}
			System.out.println("DO You want to continue,press Y");	
			
		ch=sc.next().charAt(0);	
		}
			while(ch=='Y');
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
