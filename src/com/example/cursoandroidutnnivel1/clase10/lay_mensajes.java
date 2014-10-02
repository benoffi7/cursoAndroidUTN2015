package com.example.cursoandroidutnnivel1.clase10;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cursoandroidutnnivel1.R;

public class lay_mensajes extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.activity_empty);	
		

		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void onResume()
	{
		mostrarMensaje();
		super.onResume();
	}
	
	private void mostrarMensaje()
	{
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(lay_mensajes.this);  
        dialogo1.setTitle(getResources().getString(R.string.app_name));  
        dialogo1.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
        dialogo1.setMessage("Hola, mucho gusto, soy un Alert Dialog. Presione cualquiera de mis tres opciones. Gracias y que tenga buen día");            
          
        dialogo1.setPositiveButton("Tostada al medio", new DialogInterface.OnClickListener() 
        {  
            public void onClick(DialogInterface dialogo1, int id)
            {  
            	// toast centrado
        		Toast toast2 = Toast.makeText(getApplicationContext(), "Vamos argentina! (y Velez también)", Toast.LENGTH_LONG);
        		toast2.setGravity(Gravity.CENTER, 0, 0);
        		toast2.show();
                dialogo1.dismiss();  
                mostrarMensaje();
            }  
        });
        dialogo1.setNegativeButton("Tostada personalizada", new DialogInterface.OnClickListener()
		{
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				Toast toast3 = new Toast(getApplicationContext());

				LayoutInflater inflater = getLayoutInflater();
				View layout = inflater.inflate(R.layout.toast_personalizado, (ViewGroup) findViewById(R.id.lytLayout));

				TextView txtMsg = (TextView) layout.findViewById(R.id.txtMensaje);
				txtMsg.setText("Vamos argentina! (y Velez también)");

				toast3.setDuration(Toast.LENGTH_SHORT);
				toast3.setView(layout);
				toast3.show();
				
				dialog.dismiss();
				mostrarMensaje();
			}
		});     
        dialogo1.setNeutralButton("Otra actividad", new DialogInterface.OnClickListener()
		{
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				dialog.dismiss();
				startActivity(new Intent(lay_mensajes.this,lay_lista.class));
			}
		});
        dialogo1.show();
	}

}
