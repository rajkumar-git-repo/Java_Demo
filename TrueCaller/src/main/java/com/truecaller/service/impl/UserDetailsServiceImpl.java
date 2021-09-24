package com.truecaller.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.truecaller.dao.UserDAO;
import com.truecaller.entity.User;
import com.truecaller.model.CustomUserDetail;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Override
    @Transactional
    public CustomUserDetail loadUserByUsername(String username) {
        User user = userDao.findByPhoneNumber(username);
        if(ObjectUtils.isEmpty(user)) {
        	throw new UsernameNotFoundException("User Not Found");
        }
        List<String> list = new ArrayList<String>();
        list.add(user.getUserRole().toString());
        CustomUserDetail customUserDetail = new CustomUserDetail(user.getUserId(), "", user.getPhoneNumber(), user.isActive(),list);
        return customUserDetail;
    }
}
