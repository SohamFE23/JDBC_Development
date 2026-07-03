package jdb;
import java.sql.*;

public class LaunchApp1 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		String url="jdbc:mysql://localhost:3306/COLLEGE";
//		String user="root";
//		String password="####";
		
		
		//Establish Connection
//		Connection connect = DriverManager.getConnection(url,user,password);
		Connection connect=JdbcUtil.getConnection()	;
		//create statement
		Statement statement=connect.createStatement();
		
		//execute query
		String sql= "INSERT INTO STUDENT(id, Name, fees_paid, admission_date) VALUES(5,'Shivam',7000,'2025-07-27')";
		int rowAffected=statement.executeUpdate(sql);
		//process the result
		
		if(rowAffected==0) {
			System.out.println("Unable to insert data");
		}
		else {
			System.out.println("Query is executed");
		}
		
		//close the resources
		JdbcUtil.closeConnection(connect, statement);
//		statement.close();
//		connect.close();
	}

}
