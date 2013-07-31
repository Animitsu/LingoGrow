package com.animitsu.lingogrow.utils;

import java.io.File;

import android.os.Environment;
import android.util.Log;

public class Folder_Functions 
{

	public static boolean folderExists(String folderPath)
	{
		File baseDir = new File(Environment.getExternalStorageDirectory() + "/" + folderPath);
		if(baseDir.exists() && baseDir.isDirectory())
			return true;
		else
			return false;
	}
	
	public static boolean createFolder(String folderPath)
	{
		File file = new File(Environment.getExternalStorageDirectory(), "/" + folderPath);
		//make sure the folder doesn't already exists
	    if (!file.exists()) 
	    {
	        if (!file.mkdirs()) 
	        {
	            return false;
	        }
	    }
	    return true;
	}
}
