package com.example.cursoandroidutnnivel1.loginprefs;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cursoandroidutnnivel1.Configuracion;
import com.example.cursoandroidutnnivel1.R;

public class lay_login extends Activity
{
	private EditText edit_user;
	private EditText edit_pass;
	private Button button_login;
	
	private SharedPreferences mSharedPreferences;
	private Button button_prefs;	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		setContentView(R.layout.lay_login);
		levantarXML();		
		asignarEventos();
		super.onCreate(savedInstanceState);
	}
	
	private void levantarXML() 
	{
		edit_user = (EditText)findViewById(R.id.edit_user);
		edit_pass = (EditText)findViewById(R.id.edit_pass);
		button_login = (Button)findViewById(R.id.button_login);
		button_prefs = (Button)findViewById(R.id.button_prefs);
	}
	private void asignarEventos() 
	{
		button_login.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				String validacion = validarDatos();
				if (validacion.length()==0)
				{
					guardarUser();
					Toast.makeText(getApplicationContext(), "Validacion OK", Toast.LENGTH_LONG).show();
					Intent intento = new Intent(lay_login.this,lay_login_correcto.class);
					startActivity(intento);
				}
				else
				{
					Toast.makeText(getApplicationContext(), validacion, Toast.LENGTH_LONG).show();
				}
			}
		});
		button_prefs.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				SharedPreferences.Editor editor = mSharedPreferences.edit();
				editor.remove(Configuracion.user);
				editor.remove(Configuracion.pass);
				//editor.clear();
				editor.commit();
			}
		});
	}
	
	@Override
	protected void onResume() 
	{
		mSharedPreferences = getApplicationContext().getSharedPreferences(Configuracion.misprefs, 0);
		levantarUser();
		super.onResume();
	}
		
	private void levantarUser()
	{
		String nombreRecuperado = mSharedPreferences.getString(Configuracion.user, "");
		Log.i("UTN","la contraseña es :"+mSharedPreferences.getString(Configuracion.pass, ""));
		edit_user.setText(nombreRecuperado);
		edit_pass.setText("");
	}
	
	private void guardarUser()
	{
		SharedPreferences.Editor editor = mSharedPreferences.edit();
		editor.putString(Configuracion.user, edit_user.getText().toString());
		editor.putString(Configuracion.pass, edit_pass.getText().toString());
		editor.commit();
	}	
	private String validarDatos()
	{
		if (edit_pass.getText().toString().length()==0)
		{
			return "Pass vacio";
		}
		if (edit_user.getText().toString().length()==0)
		{
			return "User vacio";
		}
		//tenemos que revisar varias cosas, si el password recuperado es vacio, 
		//se trata de un nuevo usuario
		//por lo cual no podemos validar contra algo. 
		
		//si tenemos password recuperado entonces si lo comparamos con lo ingresado por el usuario
		String pass = mSharedPreferences.getString(Configuracion.pass, "");
		if (pass.length()>0)
		{
			if (!edit_pass.getText().toString().equals(pass))
			{
				return "Contraseña incorrecta";
			}
		}		
		
		//lo mismo con el usuario
		String user = mSharedPreferences.getString(Configuracion.user, "");
		if (user.length()>0)
		{
			if (!edit_user.getText().toString().equals(pass))
			{
				return "Use incorrecta";
			}
		}
		
		return "";		
	}

	
}
