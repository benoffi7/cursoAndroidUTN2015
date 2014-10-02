package com.example.cursoandroidutnnivel1.loginprefs;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cursoandroidutnnivel1.Configuracion;
import com.example.cursoandroidutnnivel1.R;

public class lay_login_correcto extends Activity
{

	SharedPreferences mSharedPreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.lay_login_correcto);
		mSharedPreferences =getSharedPreferences(Configuracion.misprefs, Context.MODE_PRIVATE);
		super.onCreate(savedInstanceState);
		levantarXML();

	}

	private void levantarXML()
	{
		TextView text_nombre = (TextView)findViewById(R.id.text_nombre);
		text_nombre.setText(mSharedPreferences.getString(Configuracion.user, ""));
	}

}
