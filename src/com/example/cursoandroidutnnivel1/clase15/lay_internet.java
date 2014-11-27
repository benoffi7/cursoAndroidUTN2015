package com.example.cursoandroidutnnivel1.clase15;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.example.cursoandroidutnnivel1.R;

public class lay_internet extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.lay_internet);

		new descargarCaminatas().execute();

		super.onCreate(savedInstanceState);
	}

	public class descargarCaminatas extends AsyncTask<Void, Void, ArrayList<Caminata>>
	{
		ProgressDialog pd;

		@Override
		protected void onPreExecute()
		{
			pd = new ProgressDialog(lay_internet.this);
			pd.setMessage("Descargando");
			pd.show();
			super.onPreExecute();
		}

		@Override
		protected ArrayList<Caminata> doInBackground(Void... params)
		{
			return getCaminatas.devolverCaminatas();
		}

		@Override
		protected void onPostExecute(ArrayList<Caminata> result)
		{
			pd.dismiss();
			AdaptadorSenderos adap = new AdaptadorSenderos(getApplicationContext(), result);
			ListView listView_circuitos = (ListView) findViewById(R.id.listView_circuitos);
			listView_circuitos.setAdapter(adap);
			super.onPostExecute(result);
		}
	}
}
