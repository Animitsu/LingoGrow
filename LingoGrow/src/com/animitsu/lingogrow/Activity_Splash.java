package com.animitsu.lingogrow;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.Window;

import com.animitsu.lingogrow.utils.Folder_Functions;

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
		    	Intent intent = new Intent();
		    	//if the language is set then show the lesson, if not show the language menu
		    	if(isLanguageSet())
		    		intent.setClass(Activity_Splash.this, Activity_Lesson_Menu.class);
		    	else
		    		intent.setClass(Activity_Splash.this, Activity_Language_Menu.class);
		    	
		    	startActivity(intent);
		    	//kill the activity so if the back button is pressed we don't show the splash
		    	finish();
	    	}	
    	}, SPLASH_DURATION);
    }

    public boolean isLanguageSet()
    {
    	//TODO start the download of the language files
    	SharedPreferences sharedpreferences = getSharedPreferences("LingoGrow",   MODE_PRIVATE);
    	
    	//test if base folder exists
    	if(Folder_Functions.folderExists("LingoGrow"))
    	{
    		//if the language has been set check that the directory is there
    		if(sharedpreferences.contains("language"))
    		{
            	if(Folder_Functions.folderExists("LingoGrow/" + sharedpreferences.getString("language", "en")))
            	{
            		return true;
            	}
            	else
            	{
            		//we have a language set but no language folder
            		if(Folder_Functions.createFolder("LingoGrow/" + sharedpreferences.getString("language", "en")))
            			return true;
            		else
            			//TODO bail folder could not be created
            			return false;
            	}
    		}
    		else
    		{
    			//language hasnt been set, base directory exists
    			return false;
    		}
    		
    	}
    	else
    	{
    		//create the base directory
    		if(Folder_Functions.createFolder("LingoGrow"))
    			//recurse if the base folder is successfully created
    			return isLanguageSet();
    		else
    			//TODO bail folder could not be created
    			return false;
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity__splash, menu);
        return true;
    }
    
}
