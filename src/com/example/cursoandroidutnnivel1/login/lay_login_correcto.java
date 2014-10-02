package com.example.cursoandroidutnnivel1.login;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cursoandroidutnnivel1.R;

public class lay_login_correcto extends Activity
{
	private TextView text_nombre;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lay_login_correcto);		
		String usuario = getIntent().getExtras().getString(getResources().getString(R.string.hello_world));
		levantarXML();
		text_nombre.setText(usuario);
	}
	
	private void levantarXML()
	{
		text_nombre  = (TextView)findViewById(R.id.text_nombre);
		
	}
	
	@Override
	protected void onStart()
	{
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	
}
