package org.sample.model.dao;

import org.sample.model.Team;
import org.springframework.data.repository.CrudRepository;


public interface TeamDao  extends CrudRepository<Team,Long>{
	public Team findById(long id);
	public Team findByTeamName(String name);
}
