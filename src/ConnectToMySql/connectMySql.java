package ConnectToMySql;

import java.sql.*;

public class connectMySql {
	private static String URL = "jdbc:mysql://localhost:3306/testdb";
	private static String USER = "root";
	private static String PASSWORD = "";
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement =  connection.createStatement();
			ResultSet resultSet =  statement.executeQuery("SELECT * FROM student");
			while (resultSet.next()) {
				 System.out.println(
	                		resultSet.getString(1) 
	                		+ "  " + resultSet.getString(2) 
	                        + "  " + resultSet.getString(3)
	                        + "  " + resultSet.getString(4) 
	                        + "  " + resultSet.getDate(5)
	                        + "  " + resultSet.getString(6)
	                        + "  " + resultSet.getString(7)
	                        + "  " + (long)resultSet.getDouble(8)
	                        + "  " + resultSet.getInt(9)
	                        + "  " + resultSet.getInt(10)
	                       );
            }
            // close connection
            connection.close();
			System.out.println("connect successfully!");
		}
		catch (Exception e) {
			// TODO: handle exception
			 System.out.println("connect failure!");
			e.printStackTrace();
		}
	}
}
