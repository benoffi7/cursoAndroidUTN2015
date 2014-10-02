package com.example.cursoandroidutnnivel1.clase11;

import java.util.ArrayList;

import android.app.Activity;
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
		ArrayList<Equipo> equipos = getEquipos();
		AdaptadorEquipos adap = new AdaptadorEquipos(equipos , getApplicationContext());
		list_equipos.setAdapter(adap);
	}

	void findViews()
	{
		list_equipos = (ListView)findViewById(R.id.list_equipos);
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
		// android.Manifest.permission.SEND_SMS permission.


	}
	
	
}
