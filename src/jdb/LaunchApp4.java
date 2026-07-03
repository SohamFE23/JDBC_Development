package jdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LaunchApp4 {

	public static void main(String args[]){
		Connection connect=null;
		PreparedStatement statement=null;
		
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connect=JdbcUtil.getConnection();
//			String url="jdbc:mysql://localhost:3306/COLLEGE--.";
//			String user="root";
//			String password="####";
//			connect = DriverManager.getConnection(url,user,password);
			String query="INSERT into STUDENT(id, Name, fees_paid, admission_date) VALUES(?,?,?,?)";
			statement = connect.prepareStatement(query);
			
			 System.out.println("Please enter the following details to be stored in db");
			 Scanner scan = new Scanner(System.in);
			 
			 System.out.println("Enter your id");
			 Integer id=scan.nextInt();
			 
			 System.out.println("Enter your Name");
			 String name=scan.next();
			 
			 System.out.println("Enter your fees_paid");
			 Integer fees=scan.nextInt();
			 
			 System.out.print("Enter Admission Date (yyyy-MM-dd): ");
			 String date = scan.next();
			 
			 statement.setInt(1, id);
			 statement.setString(2, name);
			 statement.setInt(3, fees);
			 statement.setDate(4,java.sql.Date.valueOf(date));
			 
			int rows=statement.executeUpdate();
			if(rows>0) {
				System.out.println("Record Inserted");
			}
			else {
				System.out.println("Record Not Inserted");
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.closeConnection(connect, statement);
//				statement.close();
//				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
