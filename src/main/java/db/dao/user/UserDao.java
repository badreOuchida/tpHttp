package db.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.conn.DbInteractor;
import db.models.User;

public class UserDao implements IUser{
	
	private DbInteractor db ;
	
	public UserDao() {
		db = DbInteractor.getInstance();
	}

	@Override
	public int updateOrAddUser(User user) {
		User _user = getUser(user);
		if( _user == null)
		{
			String sql = "INSERT INTO user_table (nom,gain) VALUES ('"+user.getNom()+"','"+user.getGain()+"');";
			int res = db.maj(sql);
			return res;
		}else {
			String sql = "UPDATE user_table SET gain = " + user.getGain() + " WHERE nom =  '"+user.getNom()+"' ;";
			int res = db.maj(sql);
			return res;
		}
		
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		
		User user = null ; 
		String sql = "SELECT * FROM user_table ;";
		ResultSet res = db.select(sql);
		
		try {
			while(res.next())
			{
				//System.out.println(res.getString(1));
				//System.out.println(res.getInt(2));
				user = new User(res.getString(2),res.getInt(3),res.getBoolean(4));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	@Override
	public User getUser(int id) {
		String sql = "SELECT * FROM user_table WHERE id = " + id ;
		ResultSet res = db.select(sql);
		User user = null;
		try {
			if(res.next())
			{
				user =  new User(res.getString(2),res.getInt(3),res.getBoolean(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User getUser(User user) {
		String sql = "SELECT * FROM user_table WHERE nom = '" + user.getNom()+"' ;" ;
		ResultSet res = db.select(sql);
		User _user = null;
		try {
			if(res.next())
			{
				_user =  new User(res.getString(2),res.getInt(3),res.getBoolean(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return _user;
	}

}
