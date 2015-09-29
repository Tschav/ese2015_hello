package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidTeamException;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.SignupTeam;
import org.sample.model.Team;
import org.sample.model.Address;
import org.sample.model.User;
import org.sample.model.dao.TeamDao;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class SampleServiceImpl implements SampleService {

	@Autowired TeamDao teamDao;
    @Autowired UserDao userDao;
    @Autowired AddressDao addDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }
        
        Team team = teamDao.findById(Long.parseLong(signupForm.getTeam()));
        
        Address address = new Address();
        address.setStreet("TestStreet-foo");
        
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
        user.setTeam(team);
        
        
        user = userDao.save(user);   // save object to DB
        
        
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getId());

        return signupForm;

    }

    @Transactional
	public SignupTeam saveFrom(SignupTeam signupTeam)
			throws InvalidTeamException {
		
    	if(teamDao.findByTeamName(signupTeam.getTeamName()) != null)
    		throw new InvalidTeamException("Team already exists!");
    	
		Timestamp currentTimestamp;
		
		Date date = new Date();
		currentTimestamp = new Timestamp(date.getTime());
		
		Team team = new Team();
		team.setTeamName(signupTeam.getTeamName());
		team.setDate(currentTimestamp);
		
		team = teamDao.save(team);
		
		signupTeam.setId(team.getId());
		
		return signupTeam;
	}
}
