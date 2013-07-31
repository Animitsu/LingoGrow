package com.animitsu.lingogrow;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;

public class Activity_Splash extends Activity 
{
	private static final int SPLASH_DURATION = 2 * 1000; //milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE); //hide the title bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
    	Handler handler = new Handler();

    	handler.postDelayed(new Runnable()
    	{
	    	@Override
	    	public void run()
	    	{
		    	//kill the activity so if the back button is pressed we don't show the splash
		    	finish();
		    	//start the next activity
		    	Intent intent = new Intent(Activity_Splash.this, Activity_Language_Menu.class);
		    	startActivity(intent);
	    	}	
    	}, SPLASH_DURATION);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity__splash, menu);
        return true;
    }
    
}
