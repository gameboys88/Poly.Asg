package edu.poly.dao;

import edu.poly.model.User;

public class UserDao extends AbstractEntityDao<User> {
	public UserDao() {
		super(User.class);
	}
}
