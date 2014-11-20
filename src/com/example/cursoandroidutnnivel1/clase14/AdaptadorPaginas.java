package com.example.cursoandroidutnnivel1.clase14;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AdaptadorPaginas extends FragmentPagerAdapter
{
	private static int NUM_ITEMS = 3;

	public AdaptadorPaginas(FragmentManager fragmentManager)
	{
		super(fragmentManager);
	}

	@Override
	public int getCount()
	{
		return NUM_ITEMS;
	}
	
	@Override
	public Fragment getItem(int position)
	{
		switch (position)
		{
		case 0:
			return fragment_uno.newInstance(0, "Pagina # 1");
		case 1: 
			return fragment_dos.newInstance(1, "Pagina # 2");
		case 2: 
			return fragment_uno.newInstance(2, "Pagina # 3");
		default:
			return null;
		}
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return "Page " + position;
	}
}
