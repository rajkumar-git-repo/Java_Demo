package com.truecaller.service;

import com.truecaller.model.LoginModel;
import com.truecaller.model.ResponseModel;
import com.truecaller.model.UserLoginResponseModel;
import com.truecaller.model.UserRegisterModel;
import com.truecaller.model.UserUpdateModel;

public interface UserService {

	ResponseModel<?> saveUser(UserRegisterModel userRegisterModel);

	 ResponseModel<UserLoginResponseModel> login(LoginModel loginModel);

	ResponseModel<?> updateEmail(UserUpdateModel userUpdateModel);

	ResponseModel<?> importContact(LoginModel loginModel);
}
