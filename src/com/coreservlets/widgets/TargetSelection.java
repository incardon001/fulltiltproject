package com.coreservlets.widgets;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;




public class TargetSelection extends Activity{
    private String mItemSelectedMessageTemplate;
    private TextView text1;
    private TextView text2;
    private Button lock;
    private String knight,target,defense;
	private int points1,points2;
	private static final String TAG = TargetSelection.class.getName();
	private static final String FILENAME = "res.txt";
	//private String filePath="G:/res.txt";
	//private String filePath="C:/Users/frezza002/Desktop/SoftwareFinalProject/src/com/coreservlets/widgets/res.txt";
    /** Initializes the app when it is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);
        knight="no one";
        target="Fess Pale";
        defense="Steady Seat";
    	points1=0;
    	points2=0;
    	 
         //filePath="C:/Users/frezza002/Desktop/SoftwareFinalProject/src/com/coreservlets/widgets/res.txt";
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
		 
        text1= (TextView)findViewById(R.id.textView1);
        text2= (TextView)findViewById(R.id.textView2);
        mItemSelectedMessageTemplate = getString(R.string.spinner_message_template);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new SpinnerInfo());
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
      
        spinner2.setOnItemSelectedListener(new SpinnerInfo());
        //spinner2.
        lock=(Button)findViewById(R.id.Button1);
        
        lock.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View clickedButton) {
				 Intent newActivity = new Intent(TargetSelection.this, Outcome.class);
			        startActivity(newActivity);				
			}
		});
       
    }
    
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    
    /** Returns a slightly randomized List of names.
     *  You can pass either a String[] or a List<String> to the ArrayAdapter<String> constructor.
     *  Here I convert an array to a List so that I can randomize the order of the elements, in
     *  order to demonstrate that Java can dynamically compute the elements to display in a Spinner.
     *  If you have fixed elements, use XML instead of Java, as in the first Spinner example.
     *
    private List<String> getColors() {
        String[] targetArray = { "Crest of Helm" , "Helm","Throat Gorget",
    			"Dexter Chief","Chief Pale","Sinister Chief",
    			"Dexter Fess", "Fess Pale","Sinister Fess",
    			"Base of Shield"		 };
        List<String> colorList = Arrays.asList(targetArray);
        return(colorList);
    }
    */
    private class SpinnerInfo implements OnItemSelectedListener {
        private boolean isFirst = true;
        
        /** Shows a Toast for the selected item. Ignored the very first time,
         *  which is when the item is selected on initial display, rather than
         *  by user interaction.
         */
        @Override
        public void onItemSelected(AdapterView<?> spinner, View selectedView, 
                                   int selectedIndex, long id) {
            if (isFirst) {
                isFirst = false;
            } else {
                String selection = spinner.getItemAtPosition(selectedIndex).toString();
                String message =
                        String.format(mItemSelectedMessageTemplate, selection);
                showToast(message);
                if(spinner.getItemAtPosition(selectedIndex).toString().equals("Crest of Helm")){
                	text1.setText("Target is: Crest of Helm");
                	target="Crest of Helm";
                }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Helm")){
                	text1.setText("Target is: Helm");
                	target="Helm";
                }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Throat")){
                	text1.setText("Target is: Throat Gorget");
                	target="Throat Gorget";
                }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Dexter Chief")){
                	text1.setText("Target is: Dexter Chief (upper right of shield)");
                	target="Dexter Chief";
                }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Chief Pale")){
                	text1.setText("Target is: Chief Pale (upper center of shield)");
                	target="Chief Pale";
                }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Sinister Chief")){
                	text1.setText("Target is: Sinister Chief (upper left of shield)");
                	target="Sinister Chief";
                }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Dexter Fess")){
                	text1.setText("Target is: Dexter Fess (mid right of shield)");
                	target="Dexter Fess";
                }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Fess Pale")){
                	text1.setText("Target is: Fess Pale (middle of shield)");
                	target="Fess Pale";
                }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Sinister Fess")){
                	text1.setText("Target is: Sinister Fess (mid left of shield)");
                	target="Sinister Fess";
                }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Base of Shield")){
                	text1.setText("Target is: Base of Shield");
                	target="Base of Shield";
                }
    			 if(spinner.getItemAtPosition(selectedIndex).toString().equals( "Shield High")){
                  	text2.setText("Defense is: Shield High");
                  	defense="Shield High";
                  }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Shield Low")){
                	  text2.setText("Defense is: Shield Low");
                	  defense="Shield Low";
                  }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Lean Right")){
                	  text2.setText("Defense is: Lean Right");
                	  defense="Lean Right";
                  }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Lean Left")){
                	  text2.setText("Defense is: Lean Left");
                	  defense="Lean Left";
                  }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Steady Seat")){
                	  text2.setText("Defense is: Steady Seat");
                	  defense="Steady Seat";
                  }else if(spinner.getItemAtPosition(selectedIndex).toString().equals("Lower Helm")){
                	  text2.setText("Defense is: Lower Helm");
                	  defense="Lower Helm";
                  }
    			 try {
    		            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(FILENAME, Context.MODE_PRIVATE));
    		            outputStreamWriter.write(points1 +","+defense+","+target+","+knight+","+points2);
    		            outputStreamWriter.close();
    		        }
    		        catch (IOException e) {
    		            Log.e(TAG, "File write failed: " + e.toString());
    		        } 

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> spinner) {
            // Won't be invoked for a Spinner unless you programmatically remove items from the view
        }
        
        
    }
}