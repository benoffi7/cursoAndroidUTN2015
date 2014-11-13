package com.example.cursoandroidutnnivel1.clase11;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cursoandroidutnnivel1.R;

public class lay_lista extends Activity
{
	private ListView list_equipos;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.lay_lista);
		findViews();
		setAdapter();		
		super.onCreate(savedInstanceState);
	}
	
	private void setAdapter()
	{
		list_equipos = (ListView)findViewById(R.id.list_equipos);

		ArrayList<Equipo> equipos = getEquipos();
		AdaptadorEquipos adap = new AdaptadorEquipos(equipos , getApplicationContext());
		list_equipos.setAdapter(adap);
	}

	void findViews()
	{
	}

	private ArrayList<Equipo> getEquipos()
	{
		ArrayList<Equipo>equipos = new ArrayList<Equipo>();
		
		Equipo oEquipo = new Equipo();
		oEquipo.setBandera(getResources().getDrawable(R.drawable.arg));
		oEquipo.setNombre("Argentina");
		oEquipo.setPuntos(3);
		equipos.add(oEquipo);
		
		oEquipo = new Equipo();
		oEquipo.setBandera(getResources().getDrawable(R.drawable.ira));
		oEquipo.setNombre("Iran");
		oEquipo.setPuntos(1);
		equipos.add(oEquipo);
		
		oEquipo = new Equipo();
		oEquipo.setBandera(getResources().getDrawable(R.drawable.nig));
		oEquipo.setNombre("Nigeria");
		oEquipo.setPuntos(1);
		equipos.add(oEquipo);
		
		oEquipo = new Equipo();
		oEquipo.setBandera(getResources().getDrawable(R.drawable.bos));
		oEquipo.setNombre("Bosnia");
		oEquipo.setPuntos(0);
		equipos.add(oEquipo);
		
		return equipos;
	}
	
	void sms()
	{
		try
		{
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage("123", null, "mensaje", null,null);
			Toast.makeText(getApplicationContext(), "¡SMS Enviado!", Toast.LENGTH_LONG).show();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// <uses-permission android:name="android.permission.SEND_SMS"/>
	}
	
	void call()
	{
		try
		{
				Intent intent = new Intent(Intent.ACTION_DIAL);
				//Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:" + 123));
				startActivity(intent);
		}
		catch (Exception ex)
		{
		       ex.printStackTrace();
		}
		//  <uses-permission android:name="android.permission.CALL_PHONE"/>
	}
	
	void sendMail()
	{
		Intent intent = new Intent(Intent.ACTION_SEND);

		intent.setType("message/rfc822");

		intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@hola.com.ar"});

		intent.putExtra(Intent.EXTRA_SUBJECT, "Contacto");

		intent.putExtra(Intent.EXTRA_TEXT, "pepe");
		startActivity(Intent.createChooser(intent, "Email"));
	}
	
	
}
