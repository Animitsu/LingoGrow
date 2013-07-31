package com.animitsu.lingogrow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.TextView;

public class Activity_Error extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE); //hide the title bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        
        Intent i = getIntent();
        TextView err = (TextView) findViewById(R.id.error);
        err.setText(i.getStringExtra("error"));
        err.setGravity(Gravity.CENTER_HORIZONTAL);
    }
}