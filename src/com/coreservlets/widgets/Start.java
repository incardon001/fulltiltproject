package com.coreservlets.widgets;



import java.io.IOException;
import java.io.OutputStreamWriter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/** Demonstrates some of the basic input Widgets. The main Activity
 *  simply contains buttons that launch the other Activities. The
 *  other Activities each demonstrate a category of input Widget.
 *  <p>
 *  From <a href="http://www.coreservlets.com/android-tutorial/">
 *  the coreservlets.com Android programming tutorial series</a>.
 */

public class Start extends Activity {
    /** Initializes the app when it is first created. */
	private Button help;
	private Button start;
	private static final String TAG = Start.class.getName();
	private static final String FILENAME = "res.txt";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        help=(Button)findViewById(R.id.helpButton);
        start=(Button)findViewById(R.id.startButton);
        
        help.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View clickedButton) {
				 Intent newActivity = new Intent(Start.this, HelpMenu.class);
			        startActivity(newActivity);				
			}
		});
        start.setOnClickListener(new View.OnClickListener() {
	
        	@Override
			public void onClick(View clickedButton) {
		 		Intent newActivity = new Intent(Start.this, TargetSelection.class);
		 			startActivity(newActivity);				
			}
        });
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(FILENAME, Context.MODE_PRIVATE));
            outputStreamWriter.write(0+","+"Steady Seat"+","+"Fess Pale"+","+"no one"+","+ 0);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e(TAG, "File write failed: " + e.toString());
        } 
        
    }
    
    /** Switches to the given class (which must be a subclass of Activity). 
     *  You must also register the new Activity in AndroidManifest.xml.
     */
    private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
    
    /** Switches to the ButtonActivity when the associated button is clicked. */
    
    public void helpMenu(View clickedButton) {
        goToActivity(HelpMenu.class);
    }
    
    /** Switches to the SpinnerActivity when the associated button is clicked. */
    
    public void showSpinners(View clickedButton) {
        goToActivity(TargetSelection.class);
    }
}