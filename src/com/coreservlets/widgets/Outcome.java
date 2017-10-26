package com.coreservlets.widgets;



import java.io.*;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Outcome extends Activity {
    /** Initializes the app when it is first created. */
	private TextView outcomeText;
	private Button menu;
	private Button rerun;
	private static final String TAG = Outcome.class.getName();
	private static final String FILENAME = "res.txt";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outcome);
        outcomeText= (TextView)findViewById(R.id.textView1);
        menu=(Button)findViewById(R.id.menuButton);
        rerun=(Button)findViewById(R.id.rerunButton);
        
        menu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View clickedButton) {
				 Intent newActivity = new Intent(Outcome.this, Start.class);
			        startActivity(newActivity);				
			}
		});
        rerun.setOnClickListener(new View.OnClickListener() {
	
        	@Override
			public void onClick(View clickedButton) {
		 		Intent newActivity = new Intent(Outcome.this, TargetSelection.class);
		 			startActivity(newActivity);				
			}
        });
        
        String knight="no one",target="Fess Pale",defense="Steady Seat";
    	int points1=0,points2=0;
       //read text
      //  String filePath;
       // filePath="C:/Users/frezza002/Desktop/SoftwareFinalProject/src/com/coreservlets/widgets/res.txt";
        //filePath="G:/res.txt";
    	String ret = "";
        
        try {
            InputStream inputStream = openFileInput(FILENAME);
             
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                 
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                 
                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }
        String[] sTestVals = ret.split(",");
        
        points1=Integer.parseInt(sTestVals[0]);
		 defense=sTestVals[1];
		 target=sTestVals[2];
		 knight=sTestVals[3];
		 points2=Integer.parseInt(sTestVals[4]);
        
       Player player1=new Player("You");
       Player player2 = new Player();
       player1.setTarget(Global.Target);
       player1.setDefense(Global.Defense);
        
        if(knight.equals("no one")==true){
        	knight= player2.name;
        }
        player2.target=new Targeting('a');
		player2.defense=new Defenseive('a');
		
		int roll1=0;
		Random genarator = new Random();
		roll1=(genarator.nextInt(100)+1);
		
		int roll2=0;
		Random genarator2 = new Random();
		roll2=(genarator2.nextInt(100)+1);
		
		player1.setScore(player2, roll1);
		player2.setScore(player1, roll2);
		
		//
		//text view edit
		//
		
		points1=points1+player1.getPoints();
		points2=points2+player2.getPoints();
		
		
		 if(player1.getScore().equals((String)"Unhorsed")||points1==3){
				outcomeText.setText((
						"You chose target:"+target+"\n"+
						"You chose defense:"+defense+"\n"+
						"You got a "+player1.getScore()+"\n \n"+
						"You Win"));
				points1=0;
				defense="Steady Seat";
				target="Fess Pale";
				knight="no one";
				points2=0;
				 
		 }else if(player2.getScore().equals((String)"Unhorsed")||points2==3){
				outcomeText.setText((
						knight+" chose target:"+player2.getTarget()+"\n"+
						knight+" chose defense:"+player2.getDefense()+"\n"+
						knight+" got "+player2.getScore()+"\n \n"+
						knight+ " Won, You Lost"
						));
				points1=0;
				defense="Steady Seat";
				target="Fess Pale";
				knight="no one";
				points2=0;
					
		 }else if (points2==3 && points1==3){
			 outcomeText.setText((
					 "You chose target:"+target+"\n"+
								"You chose defense:"+defense+"\n"+
								"You rolled a "+roll1+"\n"+
								"You got a "+player1.getScore()+"\n"+
								"and have "+points1+" point(s) \n \n"+
								knight+" chose target:"+player2.getTarget()+"\n"+
								knight+" chose defense:"+player2.getDefense()+"\n"+
								knight+" rolled a "+roll2+"\n"+
								knight+" got a"+player2.getScore()+"\n"+
								"and has "+points2+" point(s)\n"+
								"You two Tie"
								));
			 					points1=0;
			 					points2=0;
			 	
		 }else {
			 outcomeText.setText((
				"You chose target:"+target+"\n"+
				"You chose defense:"+defense+"\n"+
				"You rolled a "+roll1+"\n"+
				"You got a "+player1.getScore()+"\n"+
				"and have "+points1+" point(s) \n \n"+
				knight+" chose target:"+player2.getTarget()+"\n"+
				knight+" chose defense:"+player2.getDefense()+"\n"+
				knight+" rolled a "+roll2+"\n"+
				knight+" got a "+player2.getScore()+"\n"+
				"and has "+points2+" point(s)\n"
				
					));
			 try {
		            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(FILENAME, Context.MODE_PRIVATE));
		            outputStreamWriter.write(points1 +","+defense+","+target+","+knight+","+points2);
		            outputStreamWriter.close();
		        }
		        catch (IOException e) {
		            Log.e(TAG, "File write failed: " + e.toString());
		        } 
				
		 }
	/**
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scoreing.testdubbleUnhorse(game.player1,game.player2,outcomeText);
		game.player1.score.testWinLose(game.player1,Global.points,outcomeText);
		game.player2.score.testWinLose(game.player2,Global.points2,outcomeText);
	**/
    }
    /**
     Switches to the given class (which must be a subclass of Activity). 
     You must also register the new Activity in AndroidManifest.xml.
    **/
    private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
    public void showButtonLikeWidgets(View clickedButton) {
        goToActivity(Start.class);
    }
    
    /** Switches to the SpinnerActivity when the associated button is clicked. */
    
    public void showSpinners(View clickedButton) {
        goToActivity(TargetSelection.class);
    }
}