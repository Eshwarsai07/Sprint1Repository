package com.multiplex.bookingsystem.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiplex.bookingsystem.users.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users getUserByUserName(String username);

}
