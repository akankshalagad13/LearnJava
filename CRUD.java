package Employee_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD extends  Thread {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		char ch;
		try {
			System.out.println("\t\t\t***WELCOME !! TO THE WORLD OF JDBC***");
			Thread.sleep(1000);
			System.out.println("\t\t\t***WE ARE HAPPY TO SEE YOU HERE***");
			do {
				Thread.sleep(1000);
				System.out.println("\t\t\t\t***MENU***");
				System.out.println("\t\t\t\t1.INSERT DATA");
				System.out.println("\t\t\t\t2.FETCH DATA");
				System.out.println("\t\t\t\t3.UPDATE DATA");
				System.out.println("\t\t\t\t4.SEARCH DATA");
				System.out.println("\t\t\t\t5.DELETE DATA");
				System.out.println("\t\t\t please...ENTER YOUR CHOICE NUMBER:->");
				Thread.sleep(1000);
				int a=sc.nextInt();
				if(a==1) {
					try {
					System.out.println("INSERT");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					PreparedStatement ps=con.prepareStatement("insert into employee_info values(?,?,?,?,?,?)");
					System.out.println("database connected");
					System.out.println();
					System.out.println("enter employee id:");
					int id=sc1.nextInt();
					System.out.println("enter employee name:");
					sc.nextLine();
					String name=sc.nextLine();
					System.out.println("enter employee email");
					String email=sc.nextLine();
					System.out.println("enter employee salary");
					int salary=sc1.nextInt();
					System.out.println("enter employee designation:");
					String designation=sc.nextLine();
					System.out.println("enter your address");
					String address=sc.nextLine();
					ps.setInt(1,id);
					ps.setString(2,name);
					ps.setString(3,email);
					ps.setInt(4,salary);
					ps.setString(5,designation);
					ps.setString(6,address);
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
					System.out.println("FATCHING");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					Statement st=con.createStatement();
					 ResultSet rs= st.executeQuery("select * from employee_info");
					   while(rs.next())
					   {
						   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+
								   rs.getString(5)+"\t"+rs.getString(6));
					   }
					}
					catch (Exception e) {
						System.out.println(e);
					}
					
				}
				else if(a==3) {
					try {
						Thread.sleep(1000);
					System.out.println("UPDATE");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					PreparedStatement ps=con.prepareStatement("update employee_info set address=? where id=?");
					System.out.println("enter your city:");
					sc.nextLine();
					String address=sc.nextLine();
					System.out.println("enter your id:");
					int id=sc.nextInt();
					ps.setString(1, address);
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
					System.out.println("SEARCHING");
					System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					
					System.out.println("Database connected");
					
					System.out.println("enter your  employee id:");
					int id=sc.nextInt();
				
				
				String query="select * from employee_info where id="+id;
			  PreparedStatement ps= con.prepareStatement(query);
			  ResultSet rs=ps.executeQuery(); 
			  while(rs.next())
			   {
				   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+
						   rs.getString(5)+"\t"+rs.getString(6));
			   }
					}
					catch (Exception e) {
						System.out.println(e);
					}
			 
				}
				else if(a==5) {
					try {
						Thread.sleep(1000);
						System.out.println("DELETE");
						System.out.println("--------------------------------");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_batch","root","root");
					
					System.out.println("Database connected");
					
					System.out.println("enter your  employee id:");
					int id=sc.nextInt();
				
				
				String query="delete from employee_info where id="+id;
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
