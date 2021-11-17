package com.multiplex.bookingsystem.users.service;

import com.multiplex.bookingsystem.users.entity.Users;

public interface UserService {

  public 	void addUser(Users u);

public Users getUser(String username);

}
