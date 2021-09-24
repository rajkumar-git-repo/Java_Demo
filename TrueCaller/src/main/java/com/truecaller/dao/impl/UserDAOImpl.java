package com.truecaller.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.truecaller.dao.BaseDAO;
import com.truecaller.dao.UserDAO;
import com.truecaller.entity.User;


@Repository
@Transactional
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("phoneNumber", phoneNumber));
        return (User) criteria.uniqueResult();
    }

    @Override
    public User findByUserName(String userName) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("name", userName));
        return (User) criteria.uniqueResult();
    }
}