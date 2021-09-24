package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WelcomeController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView model = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "Welcome controller executed..Using SimpleUrlHandlerMapping.....");
		return new ModelAndView("success_welcome", map);
	}

}
