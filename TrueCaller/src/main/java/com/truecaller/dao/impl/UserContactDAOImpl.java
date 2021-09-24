package com.truecaller.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.truecaller.dao.BaseDAO;
import com.truecaller.dao.UserContactDAO;
import com.truecaller.entity.UserContact;

@Repository
@Transactional
public class UserContactDAOImpl extends BaseDAO<UserContact> implements UserContactDAO {

    public UserContactDAOImpl() {
        super(UserContact.class);
    }
}
