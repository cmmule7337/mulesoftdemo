package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class sqlite 
{

	public static void main(String args[])
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:C:/Users/DELL/Documents/EclipseProjects/Project/bollywood.db";
			Connection conn = DriverManager.getConnection(url);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Movie Name : ");
			String movie = sc.next();
			System.out.print("Enter Actor Name : ");
			String actor = sc.next();
			System.out.print("Enter Actress Name : ");
			String actress = sc.next();
			System.out.print("Enter Director Name : ");
			String director = sc.next();
			System.out.print("Enter Year : ");
			int year = sc.nextInt();
			
			String query = String.format("INSERT INTO movies values(\"%s\", \"%s\", \"%s\", \"%s\", %d);", movie, actor, actress, director, year);
			Statement stmt = conn.createStatement();
			
			stmt.execute(query);
			
			System.out.println("\nRecord Added Successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}