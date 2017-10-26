package com.coreservlets.widgets;

import java.util.Scanner;


public class Game {
	public Player player1;
	public Player player2;
	
	@SuppressWarnings("resource")
	Game(boolean a){
		Scanner input = new Scanner(System.in);
		System.out.print("Please input your name"+"\n");
		String name=input.next();
		
		player1=new Player(name);
		player2=new Player();
	}
	@SuppressWarnings("resource")
	Game(char a){
		Scanner input2 = new Scanner(System.in);
		System.out.print("Please input your name Player 1"+"\n");
		String name=input2.next();
		player1=new Player(name);
		
		Scanner input3 = new Scanner(System.in);
		System.out.print("Please input your name Player 2"+"\n");
		String name2=input3.next();
		player2=new Player(name2);
	}
	Game(int a){
		
		player2=new Player();
	}
	Game(){
		
		player1=new Player();
		player2=new Player();
	}

}
