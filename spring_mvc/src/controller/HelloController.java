package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController{

	 @Override
	   protected ModelAndView handleRequestInternal(HttpServletRequest request,
	      HttpServletResponse response) throws Exception {
		 ModelAndView model = new ModelAndView();
			Map<String, String> map = new HashMap<String, String>();
			map.put("msg", "Hello controller executed..Using SimpleUrlHandlerMapping....");
			return new ModelAndView("success_hello", map);
	   }

}
