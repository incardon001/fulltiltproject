package com.coreservlets.widgets;

import java.util.Random;


public class Targeting {
	static public String[] legalTargets={
			"Crest of Helm" , "Helm","Throat Gorget",
			"Dexter Chief","Chief Pale","Sinister Chief",
			"Dexter Fess", "Fess Pale","Sinister Fess",
			"Base of Shield"		
	};
	public String ChoosenTarget;
	Targeting(){
		vaidateSetTarget("Fess Pale");
		
	}
	Targeting(String input){
		vaidateSetTarget(input);
		
	}
	Targeting(char input){
		String string="Fess Pale";
		int num=0;
		Random genarator = new Random();
		num=(genarator.nextInt(legalTargets.length));
		string=legalTargets[num];
		vaidateSetTarget(string);
		
	}
	public void vaidateSetTarget(String test){
		boolean found = false;
		String temp;
		for (int index=0; index<legalTargets.length;index++){
			temp=legalTargets[index];
			if(test.equals((String)temp)==true){
				ChoosenTarget=test;
				found=true;
			}
			
		}
		if ((found==false)){
			System.out.print("Invalid target"+"\n");
			ChoosenTarget="Fess Pale";
		}
	}
	public String getTarget(){
		return this.ChoosenTarget;
	}
	public static boolean equals(String input,String test){
		boolean equal=false;
		for(int i=0;i<input.length();i++){
			for(int j=0;j<test.length();j++){
				if(input.charAt(i)==test.charAt(j)){
					equal=true;
				}else{
					equal=false;
				}
			}
		}
		return equal;
		
	}
}
