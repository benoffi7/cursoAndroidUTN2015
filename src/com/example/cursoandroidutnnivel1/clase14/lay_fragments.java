package com.example.cursoandroidutnnivel1.clase14;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.cursoandroidutnnivel1.R;

public class lay_fragments extends FragmentActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.lay_fragments);
		ViewPager paginador = (ViewPager) findViewById(R.id.imagepager);
		AdaptadorPaginas adap_pag = new AdaptadorPaginas(getSupportFragmentManager());
		paginador.setAdapter(adap_pag);
		paginador.setCurrentItem(1);
		super.onCreate(savedInstanceState);
	}
}
