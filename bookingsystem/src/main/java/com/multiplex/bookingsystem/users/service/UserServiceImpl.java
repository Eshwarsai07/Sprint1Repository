package com.multiplex.bookingsystem.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.bookingsystem.users.entity.Users;
import com.multiplex.bookingsystem.users.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository rep;

	@Override
	public void addUser(Users u) {
		// TODO Auto-generated method stub
                  rep.save(u);		
	}

	@Override
	public Users getUser(String username) {
		// TODO Auto-generated method stub
		return rep.getUserByUserName(username);
	}

}
