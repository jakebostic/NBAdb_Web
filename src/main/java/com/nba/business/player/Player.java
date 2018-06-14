package com.nba.business.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.nba.business.team.Team;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="teamID")
	private Team team;
	private String firstName;
	private String lastName;
	private int number;
	private String position;
	private String height;
	private int weight;
	private int age;
	@Column(name = "YearsInLeague")
	private int years;
	
	public Player() {
		
	}

	public Player(int id, Team team, String firstName, String lastName, int number, String position, String height,
			      int weight, int age, int years) {
		this.id = id;
		this.team = team;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.years = years;
	}

	public Player(Team team, String firstName, String lastName, int number, String position, String height, int weight,
			      int age, int years) {
		this.team = team;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.years = years;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", team=" + team + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", number=" + number + ", position=" + position + ", height="
				+ height + ", weight=" + weight + ", age=" + age + ", years=" + years + "]";
	}
	

}
