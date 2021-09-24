package com.truecaller.dao;

import com.truecaller.entity.User;

public interface UserDAO extends GenericDAO<User> {

	User findByPhoneNumber(String phoneNumber);

	User findByUserName(String name);
    
}