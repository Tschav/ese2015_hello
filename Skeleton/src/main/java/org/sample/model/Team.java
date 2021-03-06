package org.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Team{
	
	@Id
	@GeneratedValue
	private long id;
	
	private String teamName;
	private Date date;
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String getTeamName(){
		return teamName;
	}
	
	public void setTeamName(String teamName){
		this.teamName = teamName;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
}