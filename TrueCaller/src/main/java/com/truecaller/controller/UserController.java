package com.truecaller.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.truecaller.model.LoginModel;
import com.truecaller.model.ResponseModel;
import com.truecaller.model.UserLoginResponseModel;
import com.truecaller.model.UserRegisterModel;
import com.truecaller.model.UserUpdateModel;
import com.truecaller.service.UserService;
import com.truecaller.util.CustomResponse;


@RestController
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody UserRegisterModel userRegisterModel) {
		ResponseModel<?> response = userService.saveUser(userRegisterModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseModel<UserLoginResponseModel>> login(@Valid @RequestBody LoginModel loginModel) {
		ResponseModel<UserLoginResponseModel> response = userService.login(loginModel);
		return new ResponseEntity<ResponseModel<UserLoginResponseModel>>(response, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/update")
	public ResponseEntity<ResponseModel<?>> updateEmail(@Valid @RequestBody UserUpdateModel userUpdateModel) {
		ResponseModel<?> response = userService.updateEmail(userUpdateModel);
		return new ResponseEntity<ResponseModel<?>>(response, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/import")
	public ResponseEntity<ResponseModel<?>> importContact(@Valid @RequestBody LoginModel loginModel) {
		ResponseModel<?> response = userService.importContact(loginModel);
		return new ResponseEntity<ResponseModel<?>>(response, HttpStatus.OK);
	}
}
