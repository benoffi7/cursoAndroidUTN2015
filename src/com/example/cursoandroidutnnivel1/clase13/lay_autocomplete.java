package com.example.cursoandroidutnnivel1.clase13;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.cursoandroidutnnivel1.R;

public class lay_autocomplete extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.lay_autocomplete_pager);
		//levanto el auto complete
		AutoCompleteTextView autoComplete_edit = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView_casas);
		//declaro e instacio el adaptador
		AutoCompleteAdapter adapter = new AutoCompleteAdapter(getApplicationContext());
		//se lo asigno al autocomplete
		autoComplete_edit.setAdapter(adapter);
		//cuando haglo click sobre un ITEM levanto el TAG para ver que presione
		autoComplete_edit.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View textView, int pos,long rowId) 
			{
				//recuerden que el tag es como una mochila que se le puede 
				Log.d("Autocomplete", "Seleccione algo: "+textView.getTag().toString());				
			}
		});
		
		//levanto el paginador (objeto XML)
		ViewPager paginador = (ViewPager)findViewById(R.id.imagepager);
		//creo el adaptador
		AdaptadorPaginas adap_pag = new AdaptadorPaginas(getApplicationContext());
		//selecciono el paginador y le asigno el adaptador
		paginador.setAdapter(adap_pag);
		//selecciono el primer item por las dudas, puedo seleccionar como inicio otros
		paginador.setCurrentItem(0);		
		super.onCreate(savedInstanceState);
		
		final EditText edit = new EditText(getApplicationContext());
		
		
		
		edit.setOnKeyListener(new OnKeyListener()
		{
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event)
			{
				if (edit.getText().toString().length()>6)return true;
				else return false; 

			}
		});
		edit.addTextChangedListener(new TextWatcher()
		{
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count)
			{
				if (s.length()>6)
				{
					
				}
				else
				{
					
				}
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
