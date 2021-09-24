package com.truecaller.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.truecaller.config.ContactJsonModelData;
import com.truecaller.constant.TCConstant;
import com.truecaller.dao.UserContactDAO;
import com.truecaller.dao.UserDAO;
import com.truecaller.entity.User;
import com.truecaller.entity.UserContact;
import com.truecaller.enums.UserType;
import com.truecaller.model.ContactJsonModel;
import com.truecaller.model.CustomUserDetail;
import com.truecaller.model.LoginModel;
import com.truecaller.model.PersonJsonModel;
import com.truecaller.model.ResponseModel;
import com.truecaller.model.TokenModel;
import com.truecaller.model.UserLoginResponseModel;
import com.truecaller.model.UserRegisterModel;
import com.truecaller.model.UserUpdateModel;
import com.truecaller.security.JwtTokenUtil;
import com.truecaller.service.UserService;
import com.truecaller.util.DateUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private ContactJsonModelData contactJsonModelData; 
	
	@Autowired
	private UserContactDAO userContactDAO;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	@Transactional
	@Override
	public ResponseModel<?> saveUser(UserRegisterModel userRegisterModel) {
		ResponseModel<?> response = new ResponseModel<>();
		try {
			String phoneNumber = userRegisterModel.getPhoneNumber();
			User user = userDao.findByPhoneNumber(phoneNumber);
			if(!ObjectUtils.isEmpty(user)) {
				response.setMessage("User with given number already exist");
				response.setStatus(TCConstant.FAILURE);
			}else {
				user = new User();
				user.setName(userRegisterModel.getName());
				user.setPhoneNumber(phoneNumber);
				user.setEmail(userRegisterModel.getEmail());
				user.setUserRole(UserType.ROLE_USER);
				user.setActive(true);
				user.setCreatedBy(userRegisterModel.getName());
				user.setCreatedOn(DateUtil.toCurrentUTCTimeStamp());
				userDao.saveOrUpdate(user);
				response.setMessage("User Register succesfully");
				response.setStatus(TCConstant.SUCCESS);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Transactional
	@Override
	public ResponseModel<UserLoginResponseModel> login(LoginModel loginModel) {
		ResponseModel<UserLoginResponseModel> response = new ResponseModel<UserLoginResponseModel>();
		UserLoginResponseModel loginResponseModel = new UserLoginResponseModel();
		try {
			final CustomUserDetail userDetails =  (CustomUserDetail)userDetailsService
					.loadUserByUsername(loginModel.getUserName());
			final String token = jwtTokenUtil.generateToken(userDetails);
			TokenModel tokenDetails = new TokenModel(token, userDetails.getUserRoles(), expiration);
			loginResponseModel.setTokenDetails(tokenDetails);
			loginResponseModel.setUserName(loginModel.getUserName());
			loginResponseModel.setUserRoles(jwtTokenUtil.getUserRoleFromToken(token));
			System.out.println("User:"+jwtTokenUtil.getUsernameFromToken(token));
			System.out.println("ROLE:"+jwtTokenUtil.getUserRoleFromToken(token));
			response.setData(loginResponseModel);;
			response.setMessage("User Login Successfully");
			response.setStatus(TCConstant.SUCCESS);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Transactional
	@Override
	public ResponseModel<?> updateEmail(UserUpdateModel userUpdateModel) {
		ResponseModel<?> response = new ResponseModel<>();
		try {
			String phoneNumber = userUpdateModel.getPhoneNumber();
			User user = userDao.findByPhoneNumber(phoneNumber);
			if(!ObjectUtils.isEmpty(user)) {
				user.setEmail(userUpdateModel.getEmail());
				user.setModifiedBy(user.getName());
				user.setModifiedOn(DateUtil.toCurrentUTCTimeStamp());
				userDao.saveOrUpdate(user);
				response.setMessage("User Update succesfully");
				response.setStatus(TCConstant.SUCCESS);
			}else {
				response.setMessage("User with given number is not exist");
				response.setStatus(TCConstant.FAILURE);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Transactional
	@Override
	public ResponseModel<?> importContact(LoginModel loginModel) {
		ResponseModel<?> response = new ResponseModel<>();
		try {
			List<ContactJsonModel> jsonList = contactJsonModelData.getContactJsonModelList();
			ContactJsonModel currentUserContact = jsonList.stream().filter(contactJsonModel -> contactJsonModel.getPhone().equals(loginModel.getUserName())).findFirst().orElse(null);
			if(!ObjectUtils.isEmpty(currentUserContact) && !CollectionUtils.isEmpty(currentUserContact.getContactList())) {
				for(PersonJsonModel contact : currentUserContact.getContactList()){
				   User user = userDao.findByPhoneNumber(currentUserContact.getPhone());
				   UserContact userContact = new UserContact();
				   userContact.setName(contact.getPersonName());
				   userContact.setPhoneNumber(contact.getPhoneNumber());
				   userContact.setUser(user);
				   userContact.setCreatedBy(user.getName());
				   userContact.setCreatedOn(DateUtil.toCurrentUTCTimeStamp());
				   User personIsUser = userDao.findByPhoneNumber(contact.getPhoneNumber());
				   if(!ObjectUtils.isEmpty(personIsUser)) {
					   userContact.setUser(true);
				   }else {
					   userContact.setUser(false);
				   }
				   userContactDAO.saveOrUpdate(userContact);
				};
				response.setMessage("User Contact import successfully");
				response.setStatus(TCConstant.SUCCESS);
			}else {
				response.setMessage("User has no contact");
				response.setStatus(TCConstant.FAILURE);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	
}
