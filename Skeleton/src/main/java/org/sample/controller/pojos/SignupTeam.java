package org.sample.controller.pojos;

public class SignupTeam{
	
	private long id;
	private String teamName;
	
	public String getTeamName(){
		return teamName;
	}
	
	public void setTeamName(String teamName){
		this.teamName = teamName;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
}