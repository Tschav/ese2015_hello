package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.sample.model.User;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfileController{
	
	@Autowired UserDao userDao;
	
	@RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
	public ModelAndView profile(@RequestParam("userId") long userId){
		ModelAndView model = new ModelAndView("profile");
		User user = userDao.findById(userId);
		model.addObject("userId", userId);
		model.addObject("user", user);
		return model;
	}
}