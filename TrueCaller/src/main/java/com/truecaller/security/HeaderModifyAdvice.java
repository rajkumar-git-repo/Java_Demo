package com.truecaller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/***
 * @author haripal
 * Refreshing token on API call for session expire.
 * @description Modify response header by refresh token.
 *  
 *
 */

@ControllerAdvice
public class HeaderModifyAdvice implements ResponseBodyAdvice<Object> {
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (request.getHeaders().containsKey("Authorization")) {
			String oldToken = request.getHeaders().get("Authorization").get(0);
			String newToken = jwtTokenUtil.refreshToken(oldToken);
			response.getHeaders().add("Authorization", newToken);
			//response.getHeaders().add("Access-Control-Expose-Headers", "Authorization");
		}
		response.getHeaders().add("Access-Control-Expose-Headers", "fileName");
		return body;
	}

}