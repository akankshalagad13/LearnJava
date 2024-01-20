package library_management_sytem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class library extends  Thread {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		char ch;
		try {
			System.out.println("\t\t\t\t\t\t***WELCOME!! TO THE LIBRARY MANAGEMENT SYSTEM***");
			Thread.sleep(1000);
			System.out.println("\t\t\t\t\t\t***WE ARE HAPPY TO SEE YOU HERE***");
			do {
				Thread.sleep(1000);
				System.out.println("\t\t\t\t\t\t\t***MENU***");
				System.out.println("\t\t\t\t\t\t\t1.ADD BOOKS DATA");
				System.out.println("\t\t\t\t\t\t\t2.VIEW LIST OF BOOKS");
				System.out.println("\t\t\t\t\t\t\t3.EDIT BOOK DATA");
				System.out.println("\t\t\t\t\t\t\t4.SEARCH BOOK");
				System.out.println("\t\t\t\t\t\t\t5.DELETE BOOK DATA");
				System.out.println("\t\t\t\t\t\t please...ENTER YOUR CHOICE NUMBER:->");
				Thread.sleep(1000);
				int a=sc.nextInt();
				if(a==1) {
					try {
					System.out.println("Librarian can add book information, including the book title, author, ISBN, genre, and publication year.");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					PreparedStatement ps=con.prepareStatement("insert into library values(?,?,?,?,?)");
					System.out.println("database connected");
					System.out.println();
					System.out.println("enter title of book:");
					sc.nextLine();
					String title=sc.nextLine();
					System.out.println("enter author of book:");
					String author=sc.nextLine();
					System.out.println("enter ISBN Number of book:");
					int ISBN=sc.nextInt();
					System.out.println("enter Genre of book:");
					String Genre=sc1.nextLine();
					System.out.println("enter book publication year:");
					int publish_year=sc.nextInt();
					ps.setString(1,title);
					ps.setString(2,author);
					ps.setInt(3,ISBN);
					ps.setString(4,Genre);
					ps.setInt(5,publish_year);
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
					System.out.println(" Librarian can view the list of books in the library.");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					Statement st=con.createStatement();
					 ResultSet rs= st.executeQuery("select * from  library");
					   while(rs.next())
					   {
						   System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+
								   rs.getInt(5));
					   }
					}
					catch (Exception e) {
						System.out.println(e);
					}
					
				}
				else if(a==3) {
					try {
						Thread.sleep(1000);
					System.out.println("Librarian can edit book information (e.g., update title, author, ISBN, genre, or publication year).");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					PreparedStatement ps=con.prepareStatement("update library set publish_year=? where title=?");
					System.out.println("enter your publish year:");
					sc.nextLine();
					String city=sc.nextLine();
					System.out.println("enter your title:");
					String title=sc.nextLine();
					ps.setString(1,city);
					ps.setString(2, title);
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
					System.out.println("Users can search for books by title, author, or genre");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					
					System.out.println("Database connected");
					
					System.out.println("enter your  publish year:");
					int publish_year=sc.nextInt();
				
				
				String query="select * from library where publish_year="+publish_year;
			  PreparedStatement ps= con.prepareStatement(query);
			  ResultSet rs=ps.executeQuery(); 
			  while(rs.next())
			   {
				  System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+
						   rs.getInt(5));
			   }
					}
					catch (Exception e) {
						System.out.println(e);
					}
			 
				}
				else if(a==5) {
					try {
						Thread.sleep(1000);
						System.out.println("Librarian can delete a book from the library."
								+ "");
						System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					
					System.out.println("Database connected");
					
					System.out.println("enter your  publish year:");
					int publish_year=sc.nextInt();
				
				
				String query="delete from library where publish_year="+publish_year;
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
