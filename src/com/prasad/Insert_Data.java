package com.prasad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert_Data {
	
	public static void main(String[] args) {
		Insert_Data data = new Insert_Data();
		data.insertData();	
	}
	
	public void insertData() {
		try {
			// step 1: load the driver class -- translator
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step 2: established the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","root");
			
			// step 3: create the statement
			Statement statement = connection.createStatement();
			
			//step 4: prepare the sql statement
			String sqlQuary ="insert into studentdata(id,firstname,lastname,address,city,salary,grade) "
					+ "values(1,'Prasad','ghegade','Ozar','Pune','20000','A')";
			
			//step 5: submit the sql statement and execute
//			statement.execute(sqlQuary);
			int i = statement.executeUpdate(sqlQuary);
			
			System.out.println("executed successfully");
			
			// close the resource
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
