package com.animitsu.lingogrow;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import com.animitsu.lingogrow.utils.Folder_Functions;

public class Activity_Language_Menu extends Activity
{
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
		overridePendingTransition(0,0); //no transition
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE); //hide the title bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_menu);
        
        final String flags[] = getResources().getStringArray(R.array.languages);
        
        GridView gridview = (GridView) findViewById(R.id.gridLanguage);
        gridview.setAdapter(new Grid_Adapter_Language_Menu(this, flags));

        gridview.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            {
            	//TODO download language files
            	//set the language preference 
            	SharedPreferences sharedpreferences = getSharedPreferences("LingoGrow",   MODE_PRIVATE);
            	Editor spEditor = sharedpreferences.edit();
            	spEditor.putString("language", flags[position]);
            	spEditor.commit();
            	
            	if(!Folder_Functions.createFolder("LingoGrow/" + flags[position]))
            	{
            		showError("Folder could not be created.");
            	}
            	else
            	{
            		Intent i = new Intent(Activity_Language_Menu.this, Activity_Lesson_Menu.class);
            		startActivity(i);
            	}
            }
        });
    }
	
	public void showError(String msg)
    {
    	Intent intent = new Intent(Activity_Language_Menu.this, Activity_Error.class);
		intent.putExtra("error", msg);
		startActivity(intent);
    }
}