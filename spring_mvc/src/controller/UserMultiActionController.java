package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserMultiActionController extends MultiActionController {

	public ModelAndView home(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView model = new ModelAndView("home");
		model.addObject("message", "Home page executed...*************");
		return model;
	}
	
	
	public ModelAndView add(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView model = new ModelAndView("user");
		model.addObject("message", "User ADD page executed...************");
		return model;
	}
	
	
	public ModelAndView remove(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView model = new ModelAndView("user");
		model.addObject("message", "User REMOVE page executed...**********");
		return model;
	}
}
