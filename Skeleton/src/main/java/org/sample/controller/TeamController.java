package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidTeamException;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupTeam;
import org.sample.controller.service.SampleService;
import org.sample.model.Team;
import org.sample.model.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TeamController{
	
	@Autowired SampleService sampleService;
	@Autowired TeamDao teamDao;
	
	@RequestMapping(value = "/new-team", method = RequestMethod.GET)
	public ModelAndView team(){
		ModelAndView model = new ModelAndView("new-team");
		model.addObject("signupTeam", new SignupTeam());
		return model;
	}
	
	@RequestMapping(value = "/createTeam", method = RequestMethod.POST)
    public ModelAndView createTeam(@Valid SignupTeam signupTeam, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model;    	
    	if (!result.hasErrors()) {
            try {
            	sampleService.saveFrom(signupTeam);
            	model = new ModelAndView("show");
            } catch (InvalidTeamException e) {
            	model = new ModelAndView("new-team");
            	model.addObject("page_error", e.getMessage());
            }
        } else {
        	model = new ModelAndView("new-team");
        }
    	return model;
    }
}