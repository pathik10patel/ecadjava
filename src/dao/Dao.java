package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

	static Connection con=null;
	static 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://au-cdbr-sl-syd-01.cleardb.net/ibmx_1f0015926f4491d?user=b69c4ae230aac9&password=36bc6a22");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void createTable() throws SQLException
	{
		String sql="create table employee(eid integer primary key,ename varchar(50),age varchar(50),city varchar(50))";
		PreparedStatement ps=con.prepareStatement(sql);
		int i=ps.executeUpdate();
		if(i==0)
		{
			System.out.println("table created");
		}
	}
	public static ResultSet select(String sql) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	public static void insert(String sql) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps=con.prepareStatement(sql);
		int i=ps.executeUpdate();
	}
	

}
