package com.nba.business.team;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String teamName;
	private String city;
	private String state;
	private int seasons;
	private String totalRecord;
	private int playoffApps;
	private int championships;
	
	public Team() {
		
	}

	public Team(int id, String teamName, String city, String state, int seasons, String totalRecord, int playoffApps,
			    int championships) {
		this.id = id;
		this.teamName = teamName;
		this.city = city;
		this.state = state;
		this.seasons = seasons;
		this.totalRecord = totalRecord;
		this.playoffApps = playoffApps;
		this.championships = championships;
	}

	public Team(String teamName, String city, String state, int seasons, String totalRecord, int playoffApps,
			int championships) {
		this.teamName = teamName;
		this.city = city;
		this.state = state;
		this.seasons = seasons;
		this.totalRecord = totalRecord;
		this.playoffApps = playoffApps;
		this.championships = championships;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSeasons() {
		return seasons;
	}

	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}

	public String getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(String totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPlayoffApps() {
		return playoffApps;
	}

	public void setPlayoffApps(int playoffApps) {
		this.playoffApps = playoffApps;
	}

	public int getChampionships() {
		return championships;
	}

	public void setChampionships(int championships) {
		this.championships = championships;
	}
	
	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", city=" + city + ", state=" + state
				+ ", seasons=" + seasons + ", totalRecord=" + totalRecord + ", playoffApps=" + playoffApps + ", championships="
				+ championships + "]";
	}
	
}
