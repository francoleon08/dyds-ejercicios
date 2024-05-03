package dyds.act2.parte2;

import java.awt.*;
import java.util.List;

public class Club {
	
	private int id; // unique identifier
	private String name; // team name
	private String home; // stadium name
	private int year; // founding year
	private Image colours; // image depicting a shirt or the shield of the club
	private List<Player> roster; // A list with the players of the first division team
	private int wins; //The amount of matches that the team has won in the current season
	private int loses; //The amount of matches that the team has lost in the current season
	private int goalsf; //The amount of goals that the team made in the current season
	private int goalsa; //The amount of goals that the team received in the current season

	private long timeStamp; // local repo time stamp
	
	public Club(int id, String name, String home, int year) {
		super();
		this.id = id;
		this.name = name;
		this.home = home;
		this.year = year;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Image getColours() {
		return colours;
	}
	public void setColours(Image colours) {
		this.colours = colours;
	}
	public List<Player> getRoster() {
		return roster;
	}
	public void setRoster(List<Player> roster) {
		this.roster = roster;
	}

	public void addMatchInfo(boolean win, int gf, int ga){
		if(win) wins++;
		else loses++;
		goalsa += ga;
		goalsf += gf;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
