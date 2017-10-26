package com.coreservlets.widgets;

import java.util.Random;

import android.widget.TextView;


public class Scoreing {
	public String[] DiffrentScores={
		"Miss","Hit","Helm Off","Penalty",
		"Failure","Unhorsed","Injured Unhorsed"
	};
	public String Scored;
	public int Points;
	private int random;
	private int random2;
	private boolean testing;
	Scoreing(){
		Scored="no Score";
		Points=0;		
	}
	Scoreing(Targeting playerA,Defenseive playerB,int roll){
		setScore(playerA,playerB,roll,0,0);
		setPoints(Scored);
		
	}
	public void setPoints(String test){
		if (test.equals((String)"Miss")){
			Points=Points+0;
		}
		else if (test.equals((String)"Hit")){
			Points=Points+1;
		}
		else if (test.equals((String)"Helm Off")){
			Points=Points+2;			
		}
		else if (test.equals((String)"Penalty")){
			Points=Points-1;			
		}
		else if (test.equals((String)"Failure")){
			Points=Points-2;			
		}
		else if (test.equals((String)"Unhorsed")){			
		}
		else if (test.equals((String)"Injured Unhorsed")){			
		}
	}
	public void setScore(Targeting playerA,Defenseive playerB,int roll,int rand,int rand2){
		if(rand>0){
			random=rand;
			random2=rand2;
			testing=true;
		}
		else{
			setRandom();
			setRandom2();
			testing=false;
		}
		
		if(playerA.ChoosenTarget.equals("Crest of Helm")){
			if(playerB.ChoosenDefense.equals("Shield High")){
				if(roll<81){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}
			}
			else if (playerB.ChoosenDefense.equals("Shield Low")){
				if(roll<51){
					Scored="Miss";
				}
				else{
					Scored="Helm Off";
					
					if(random<26){
						Scored="Unhorsed";
					}
				}
				
			}
			else if (playerB.ChoosenDefense.equals("Lean Right")){
				if(roll<91){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lean Left")){
				if(roll<71){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Steady Seat")){
				if(roll<76){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lower Helm")){
				if(roll<97){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
		}
		else if (playerA.ChoosenTarget.equals("Helm")){
			if(playerB.ChoosenDefense.equals("Shield High")){
				if(roll<61){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}
			}
			else if (playerB.ChoosenDefense.equals("Shield Low")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Helm Off";
					
					if(random<26){
						Scored="Unhorsed";
					}
				}				
			}
			else if (playerB.ChoosenDefense.equals("Lean Right")){
				if(roll<91){
					Scored="Miss";
					
					if(random<21){
						Scored="Penalty";
					}
				}
				else{
					Scored="Miss";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lean Left")){
				if(roll<51){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Steady Seat")){
				if(roll<71){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lower Helm")){
				if(roll<91){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
		}
		else if (playerA.ChoosenTarget.equals("Throat Gorget")){
			if(playerB.ChoosenDefense.equals("Shield High")){
				if(roll<76){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}
			}
			else if (playerB.ChoosenDefense.equals("Shield Low")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Helm Off";
					
					if(random<26){
						Scored="Unhorsed";
					}
				}
				
			}
			else if (playerB.ChoosenDefense.equals("Lean Right")){
				if(roll<81){
					Scored="Miss";
					
					if(random<21){
						Scored="Penalty";
					}
				}
				else{
					Scored="Miss";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lean Left")){
				if(roll<21){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Steady Seat")){
				if(roll<66){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lower Helm")){
				if(roll<71){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
		}
		else if (playerA.ChoosenTarget.equals("Dexter Chief")){
			if(playerB.ChoosenDefense.equals("Shield High")){
				if(roll<21){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}
			}
			else if (playerB.ChoosenDefense.equals("Shield Low")){
				if(roll<71){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}
				
			}
			else if (playerB.ChoosenDefense.equals("Lean Right")){
				if(roll<21){
					Scored="Miss";					
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lean Left")){
				if(roll<81){
					Scored="Miss";
					
					if(random<21){
						Scored="Penalty";
					}
				}
				else{
					Scored="Miss";
					}
				}
			else if (playerB.ChoosenDefense.equals("Steady Seat")){
				if(roll<21){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			
			else if (playerB.ChoosenDefense.equals("Lower Helm")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
		}
		else if (playerA.ChoosenTarget.equals("Chief Pale")){
			if(playerB.ChoosenDefense.equals("Shield High")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}
			}
			else if (playerB.ChoosenDefense.equals("Shield Low")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}				
			}
			else if (playerB.ChoosenDefense.equals("Lean Right")){
				if(roll<51){
					Scored="Miss";					
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lean Left")){
				if(roll<41){
					Scored="Miss";
					}
				
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Steady Seat")){
				if(roll<21){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lower Helm")){
				if(roll<21){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
		}
		else if (playerA.ChoosenTarget.equals("Sinister Chief")){
			if(playerB.ChoosenDefense.equals("Shield High")){
				if(roll<71){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}
			}
			else if (playerB.ChoosenDefense.equals("Shield Low")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}				
			}
			else if (playerB.ChoosenDefense.equals("Lean Right")){
				if(roll<91){
					Scored="Miss";
					
					if(random<21){
						Scored="Penalty";
					}
				}
				else{
					Scored="Miss";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lean Left")){
				if(roll<21){
					Scored="Miss";
					}
				
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Steady Seat")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lower Helm")){
				if(roll<71){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
		}	
		else if (playerA.ChoosenTarget.equals("Dexter Fess")){
			if(playerB.ChoosenDefense.equals("Shield High")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}
			}
			else if (playerB.ChoosenDefense.equals("Shield Low")){
				if(roll<21){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}				
			}
			else if (playerB.ChoosenDefense.equals("Lean Right")){
				if(roll<41){
					Scored="Miss";
					
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lean Left")){
				if(roll<71){
					Scored="Miss";
					
					if(random<21){
						Scored="Penalty";
					}
				}
				
				else{
					Scored="Miss";
					}
				}
			else if (playerB.ChoosenDefense.equals("Steady Seat")){
				if(roll<21){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lower Helm")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
		}
		else if (playerA.ChoosenTarget.equals("Fess Pale")){
			if(playerB.ChoosenDefense.equals("Shield High")){
				if(roll<21){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}
			}
			else if (playerB.ChoosenDefense.equals("Shield Low")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}				
			}
			else if (playerB.ChoosenDefense.equals("Lean Right")){
				if(roll<51){
					Scored="Miss";					
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lean Left")){
				if(roll<21){
					Scored="Miss";
					}
				
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Steady Seat")){
				if(roll<31){
					Scored="Hit";
				}
				else{
					Scored="Unhorsed";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lower Helm")){
				if(roll<21){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
		}
		else if (playerA.ChoosenTarget.equals("Sinister Fess")){
			if(playerB.ChoosenDefense.equals("Shield High")){
				if(roll<41){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}
			}
			else if (playerB.ChoosenDefense.equals("Shield Low")){
				if(roll<51){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}				
			}
			else if (playerB.ChoosenDefense.equals("Lean Right")){
				if(roll<81){
					Scored="Miss";
					
					if(random<21){
						Scored="Penalty";
					}
				}
				else{
					Scored="Miss";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lean Left")){
				if(roll<31){
					Scored="Miss";
					}
				
				else{
					Scored="Unhorsed";
					}
				}
			else if (playerB.ChoosenDefense.equals("Steady Seat")){
				if(roll<51){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lower Helm")){
				if(roll<51){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
		}
		else if (playerA.ChoosenTarget.equals("Base of Shield")){
			if(playerB.ChoosenDefense.equals("Shield High")){
				if(roll<11){
					Scored="Hit";
				}
				else{
					Scored="Injured Unhorsed";					
				}
			}
			else if (playerB.ChoosenDefense.equals("Shield Low")){
				if(roll<51){
					Scored="Miss";
				}
				else{
					Scored="Hit";					
				}				
			}
			else if (playerB.ChoosenDefense.equals("Lean Right")){
				if(roll<81){
					Scored="Miss";
					
					if(random<21){
						Scored="Penalty";
						
					}
					else{
						if(random2<21){
							Scored="Failure";
						}
					}
				}
				else{
					Scored="Miss";
					
						if(random<21){
							Scored="Penalty";
							
						}
					}
				}
			else if (playerB.ChoosenDefense.equals("Lean Left")){
				if(roll<41){
					Scored="Miss";
					}
				
				else{
					Scored="Unhorsed";
					}
				}
			else if (playerB.ChoosenDefense.equals("Steady Seat")){
				if(roll<21){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
			else if (playerB.ChoosenDefense.equals("Lower Helm")){
				if(roll<51){
					Scored="Miss";
				}
				else{
					Scored="Hit";
					}
				}
		}	
		
	}
	public void setRandom(){
		  Random genarator = new Random();
		  random=(genarator.nextInt(100)+1);
		  
	  }
	public void setRandom2(){
		  Random genarator = new Random();
		  random2=(genarator.nextInt(100)+1);
		  
	  }
	public void setOverallScore(Player playerA,Player playerB,int roll,int rand,int rand2){
		setScore(playerA.target,playerB.defense,roll,rand,rand2);
		setPoints(Scored);
		//testWinLose(playerA);
	}
	public void testWinLose(Player a){
		if (Scored.equals("Unhorsed")&&testing==false){
			//win
			System.out.print("\n"+a.name+" Wins with an unhorse"+"\n");
			System.exit(0);
		}
		else if (Points >= 3&&testing==false){
			//win
			System.out.print("\n"+a.name+" Wins with 3 points"+"\n");
			System.exit(0);
		}
		else if (Points <= -2&&testing==false){
			//lose
			System.out.print("\n"+a.name+" Loses with too many penalties"+"\n");
			System.exit(0);
		}
		else if (Scored .equals( "Failure")&&testing==false){
			//lose
			System.out.print("\n"+a.name+" Loses by falling off his horse"+"\n");
			System.exit(0);
		}
		else if (Scored .equals( "Injured Unhorsed")&&testing==false){
			//draw
			System.out.print("\n"+a.name+" the game is a draw"+"\n");
			System.exit(0);
		}
	}
	public void testWinLose(Player a,int b,TextView c){
		if (a.score.equals("Unhorsed")){
			//win
			c.setText("\n"+a.name+" Wins with an unhorse"+"\n");
			System.exit(0);
		}
		else if (b >= 3){
			//win
			c.setText("\n"+a.name+" Wins with 3 points"+"\n");
			System.exit(0);
		}
		else if (b <= -2){
			//lose
			c.setText("\n"+a.name+" Loses with too many penalties"+"\n");
			System.exit(0);
		}
		else if (a.score.equals( "Failure")){
			//lose
			c.setText("\n"+a.name+" Loses by falling off his horse"+"\n");
			System.exit(0);
		}
		else if (a.score.equals( "Injured Unhorsed")){
			//draw
			c.setText("\n"+a.name+" the game is a draw"+"\n");
			System.exit(0);
		}
	}
	public static void testdubbleUnhorse(Player a,Player b,TextView c){
		if (a.score.equals("Unhorsed")&&b.score.equals("Unhorsed")){
			c.setText("\n"+a.name+", "+b.name+" the game is a draw"+"\n");
			System.exit(0);
		}		
			
	}

}
