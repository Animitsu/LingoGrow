package com.animitsu.lingogrow;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class Activity_Lesson_Menu extends Activity
{
	String language;
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
		overridePendingTransition(0,0); //no transition
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE); //hide the title bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_menu);
        
        SharedPreferences sharedpreferences = getSharedPreferences("LingoGrow",   MODE_PRIVATE);
        language = sharedpreferences.getString("language", "en");
        
    }
}