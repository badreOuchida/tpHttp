package db.dao.user;

import java.util.List;

import db.models.User;

public interface IUser {
	public int updateOrAddUser(User user);
	public User getUser(User user);
	public List<User> getUsers();
	public User getUser(int id);
	public int updateUser(User user);
	public int deleteUser(User user);

}
