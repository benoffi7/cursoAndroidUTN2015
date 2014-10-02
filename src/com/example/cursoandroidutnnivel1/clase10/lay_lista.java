package com.example.cursoandroidutnnivel1.clase10;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
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
		setList();
		super.onCreate(savedInstanceState);
	}

	private void setList()
	{
		final String[] equipos = new String[]{"Velez","Boca","River","Otro"};
		 
		//adapter
        ArrayAdapter<String> adaptador_elementos = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,equipos);
        list_equipos.setAdapter(adaptador_elementos);     
        list_equipos.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				Toast toast2 = Toast.makeText(getApplicationContext(), equipos[position], Toast.LENGTH_LONG);
        		toast2.setGravity(Gravity.CENTER, 0, 0);
        		toast2.show();				
			}
		});		
	}

	private void findViews()
	{
		list_equipos = (ListView)findViewById(R.id.list_equipos);
		
	}
}
