package db.conn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbInteractor {
	
	private static DbInteractor instance = null ;
	
	private Connection con = null;
	private Statement st = null;
	
	
	private DbInteractor() {
		
		
		
        
        String dbDriver = "org.postgresql.Driver";
        String dbUrl = "jdbc:postgresql://localhost/db_jee";
        String dbUsername = "ouchi";
        String dbPassword = "badre"; 
        
        
		try {
			
			Class.forName(dbDriver);
			String url = dbUrl;
			String username = dbUsername;
			String password = dbPassword;
			con = DriverManager.getConnection(url,username,password);
			st = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static DbInteractor getInstance()
	{
		
		if(instance == null)
		{
			System.out.println("Instance created");
			instance = new DbInteractor();
			
		}
		
		return instance ;
	}
	
	public ResultSet select(String query)
	{
		System.out.println(query);
		ResultSet res = null;
		try {
			res = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public int maj(String sql)
	{
		
		System.out.println(sql);
		int nb = 0;
		try {
			nb = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}

	

}
