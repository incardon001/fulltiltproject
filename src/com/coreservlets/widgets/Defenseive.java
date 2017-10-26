package com.coreservlets.widgets;

import java.util.Random;


public class Defenseive {
	public static String[] legalDefense={
			"Shield High",
			"Shield Low",
			"Lean Right",
			"Lean Left",
			"Steady Seat",
			"Lower Helm"
	};
	public String ChoosenDefense;

	Defenseive(){
		vaidateSetDefense("Steady Seat");
	}
	Defenseive(String input){
		vaidateSetDefense(input);
	}
	Defenseive(char input){
		String string="Steady Seat";
		int num=0;
		Random genarator = new Random();
		num=(genarator.nextInt(legalDefense.length));
		string=legalDefense[num];
		vaidateSetDefense(string);
		
	}
	public void vaidateSetDefense(String test){
		boolean found=false;
		
		for (int index=0; index<legalDefense.length;index++){
			
			if(test.equals(legalDefense[index])){
				ChoosenDefense=test;
				found=true;
			}
			
		}
		if(found==false){
			//System.out.print("Invalid defense"+"\n");
			ChoosenDefense="Steady Seat";
		}
	}
	public String getDefense(){
		return this.ChoosenDefense;
	}
	public static boolean equals(String input,String test){
		boolean equal=false;
		for(int i=0;i<input.length();i++){
			for(int j=0;j<test.length();j++){
				if((input.charAt(i))==test.charAt(j)){
					equal=true;
				}else{
					equal=false;
				}
			}
		}
		return equal;
		
	}

}
