package jdb;
import java.sql.*;

public class LaunchApp2 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String url="jdbc:mysql://localhost:3306/COLLEGE";
//		String user="root";
//		String password="####";
//		//Establish Connection
//		Connection connect = DriverManager.getConnection(url,user,password);
		Connection connect=JdbcUtil.getConnection();		//create statement
		Statement statement=connect.createStatement();
		
		//execute query
		String sql= "UPDATE from student set fees_paid=11000 where id=2";
		int rowAffected=statement.executeUpdate(sql);
		//process the result
		
		if(rowAffected==0) {
			System.out.println("Query Not Updated");
		}
		else {
			System.out.println("Query Updated");
		}
		
		//close the resources
		JdbcUtil.closeConnection(connect, statement);
//		statement.close();
//		connect.close();
	}

}
