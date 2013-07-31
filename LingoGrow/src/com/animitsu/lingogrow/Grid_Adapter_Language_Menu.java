package com.animitsu.lingogrow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Grid_Adapter_Language_Menu extends BaseAdapter
{
	private Context context;
	private final String[] flags;
	
	public Grid_Adapter_Language_Menu(Context context, String[] flags)
	{
		this.context = context;
		this.flags = flags;
	}

	@Override
	public int getCount() 
	{
		return flags.length;
	}

	@Override
	public Object getItem(int arg0) 
	{
		return flags[arg0];
	}

	@Override
	public long getItemId(int arg0) 
	{
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ImageView imageView;
        if (convertView == null) 
        {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(120, 120));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

        } 
        else 
        {
            imageView = (ImageView) convertView;
        }
        int resID = context.getResources().getIdentifier(flags[position], "drawable",  context.getPackageName()); 
        imageView.setImageResource(resID);
        return imageView;
	}

}
