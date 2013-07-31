package com.animitsu.lingogrow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Activity_Language_Menu extends Activity
{
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
		overridePendingTransition(0,0); //no transition
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE); //hide the title bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_menu);
    }
}
