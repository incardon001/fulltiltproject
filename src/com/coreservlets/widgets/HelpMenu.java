package com.coreservlets.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class HelpMenu extends Activity {
    // The Android coding style conventions say that non-public instance variables should start with "m".
    // "m" for "member" (as in "data member" or "member variable").
    private String mButtonMessageTemplate;
    private String mImageButtonMessageTemplate;
    private String mToggleButtonMessageTemplate;
    
    /** Initializes the amp when it is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help); // Must call setContentView before findViewById or getString
        mButtonMessageTemplate = 
                getString(R.string.button_message_template);
        mImageButtonMessageTemplate = 
                getString(R.string.image_button_message_template);
        mToggleButtonMessageTemplate = 
                getString(R.string.toggle_button_message_template);
        
    }
    
    /** Makes a Toast showing the label of the Button, RadioButton, or CheckBox.
     *  ImageButtons do not have text, and are not subclasses of Button, so you
     *  cannot pass an ImageButton to this method.
     */
    
    public void showButtonText(View clickedButton) { 
        Button button = (Button)clickedButton;
        CharSequence text = button.getText();
        String message =
                String.format(mButtonMessageTemplate, text);
        showToast(message);
    }
    
    public void showImageButton1Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_1_image);
    }
    
    public void showImageButton2Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_2_image);
    }
    
    public void showImageButton3Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_3_image);
    }
    
    public void showImageButton4Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_4_image);
    }
    
    public void showImageButton5Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_5_image);
    }
    
    public void showImageButton6Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_6_image);
    }
    
    private void showImageButtonInfo(int imageId) {
        String image = getString(imageId);
        String message =
                String.format(mImageButtonMessageTemplate, image);
        showToast(message);
    }
    
    /** Makes a Toast showing whether you turned ToggleButton on or off. Also
     *  shows the resultant text (label).
     */
    
    public void showToggleButtonInfo(View clickedToggleButton) { 
        ToggleButton toggleButton = (ToggleButton)clickedToggleButton;
        String status;
        if (toggleButton.isChecked()) {
            status = "ON";
        } else {
            status = "OFF";
        }
        CharSequence label = toggleButton.getText();
        String message =
                String.format(mToggleButtonMessageTemplate, status, label);
        showToast(message);
    }
    
    /** Creates a "Toast" (temporary popup message) that displays the designated text. */
    
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    
    
        
   }

