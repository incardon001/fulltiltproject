package com.coreservlets.widgets;

import java.util.Random;


public class Player {
	public Targeting target;
	public Defenseive defense;
	public Scoreing score;
	public String name;
	private String[] names={
			"Sir loin","Sir Lee","Sir Jerry",
			"Sir Mise","Sir Pent","Sir Up",
			"Sir Fing","Sir Cumsise"
	};
	Player(){
		int random;
		target=new Targeting();
		defense = new Defenseive();
		score = new Scoreing();
		Random genarator = new Random();
		random=(genarator.nextInt(names.length));
		name=names[random];
	}
	Player(String input){
		target=new Targeting();
		defense = new Defenseive();
		score = new Scoreing();
		name=input;
	}
	public void setScore(Player anotherPlayer, int roll){
		this.score.setOverallScore(this, anotherPlayer, roll,0,0);
	}
	public void setTestScore(Player anotherPlayer, int roll,int rand,int rand2){
		this.score.setOverallScore(this, anotherPlayer, roll,rand,rand2);
	}
	public void setTarget(String input){
		this.target.vaidateSetTarget(input);
	}
	public void setDefense(String input){
		this.defense.vaidateSetDefense(input);
	}
	public String getScore(){		
		return this.score.Scored;
	}
	public int getPoints(){
		return this.score.Points;
	}
	public void addPoints(int a){
		this.score.Points=this.score.Points+a;
	}
	public String getTarget(){
		return this.target.ChoosenTarget;
	}
	public String getDefense(){
		return this.defense.ChoosenDefense;
	}
}
