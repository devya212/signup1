package com.nucleus.dao;

import java.sql.SQLException;

import com.nucleus.entity.User;

public interface UserDao {

	public void signUp(User user)throws SQLException;
	public void signIn(User user)throws SQLException;
}
