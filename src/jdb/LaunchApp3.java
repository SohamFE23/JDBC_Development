package jdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchApp3 {

	public static void main(String args[]){
		Connection connect=null;
		Statement statement=null;
		
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connect=JdbcUtil.getConnection();
//			String url="jdbc:mysql://localhost:3306/COLLEGE--.";
//			String user="root";
//			String password="####";
//			connect = DriverManager.getConnection(url,user,password);
			statement = connect.createStatement();
			
			String sql= "INSERT INTO STUDENT(id, Name, fees_paid, admission_date) VALUES(5,'Prashik Suradkar',900,'2025-07-27')";
			
			int rows = statement.executeUpdate(sql);
			if(rows>0) {
				System.out.println("Record Inserted");
			}
			else {
				System.out.println("Record Not Inserted");
			}
			
			String sql1="Select * from STUDENT";
			ResultSet rs= statement.executeQuery(sql1);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getDate(4));
			}
			rs.close();
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
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
